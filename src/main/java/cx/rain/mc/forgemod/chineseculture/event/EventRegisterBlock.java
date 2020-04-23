package cx.rain.mc.forgemod.chineseculture.event;

import cx.rain.mc.forgemod.chineseculture.utility.SubClassHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class EventRegisterBlock {
    private static List<Block> blocks = new ArrayList<>();

    static {
        for (Class<? extends Block> clazz :
                SubClassHelper.getBlocks("cx.rain.mc.forgemod.chineseculture.block.automatic")) {
            try {
                Constructor<? extends Block> c = clazz.getConstructor();
                Block b = c.newInstance();
                blocks.add(b);
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

        for (Block b : blocks) {
            event.getRegistry().register(b);
        }
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering ItemBlocks.");

        for (Block b : blocks) {
            event.getRegistry().register(new ItemBlock(b));
        }
    }

    @SubscribeEvent
    public static void onRegisterModel(ModelRegistryEvent event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Block Models.");

        for (Block b : blocks) {
            ModelResourceLocation model = new ModelResourceLocation(b.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, model);
        }
    }
}