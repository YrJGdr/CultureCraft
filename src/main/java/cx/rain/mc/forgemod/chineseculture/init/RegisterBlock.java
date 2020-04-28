package cx.rain.mc.forgemod.chineseculture.init;

import cx.rain.mc.forgemod.chineseculture.util.SubClassHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class RegisterBlock {
    public static List<Block> BLOCKS = new ArrayList<>();

    static {
        for (Class<? extends Block> clazz :
                SubClassHelper.getBlocks("cx.rain.mc.forgemod.chineseculture.block.automatic")) {
            try {
                Constructor<? extends Block> c = clazz.getConstructor();
                Block b = c.newInstance();
                BLOCKS.add(b);
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
        for (Block b : BLOCKS) {
            event.getRegistry().register(b);
        }
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering ItemBlocks.");
        for (Block b : BLOCKS) {
            event.getRegistry().register(new ItemBlock(b).setRegistryName(b.getRegistryName()));
        }
    }
}