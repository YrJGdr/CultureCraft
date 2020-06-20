package cx.rain.mc.forgemod.chineseculture.core.registry;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.util.SubClassHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class RegistryBlocks {
    public static Map<String, Block> BLOCKS = new HashMap<>();

    static {
        for (Class<? extends Block> clazz :
                SubClassHelper.getBlocks("cx.rain.mc.forgemod.chineseculture.block")) {
            try {
                String name = clazz.getAnnotation(ModBlock.class).name();
                String translateKey = clazz.getAnnotation(ModBlock.class).translate();
                if (translateKey.equals("")) {
                    translateKey = name;
                }
                Block block = clazz.getConstructor().newInstance()
                        .setRegistryName(ChineseCulture.MODID, name)
                        .setUnlocalizedName(ChineseCulture.MODID+"."+translateKey);
                BLOCKS.put(name, block);
            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InstantiationException
                    | InvocationTargetException ex) {
                ChineseCulture.INSTANCE.getLogger().warn("A block can't be instantiated.");
                ex.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Blocks.");
        BLOCKS.forEach((name, block) -> {
            event.getRegistry().register(block);
        });
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering ItemBlocks.");
        BLOCKS.forEach((name, block) -> {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        });
    }
}
