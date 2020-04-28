package cx.rain.mc.forgemod.chineseculture.init;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = ChineseCulture.MODID, value = Side.CLIENT)
public class RegisterModel {
    @SubscribeEvent
    public static void onRegisterModel(ModelRegistryEvent event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Item Models.");
        for (Item i : RegisterItems.ITEMS) {
            ModelResourceLocation model = new ModelResourceLocation(i.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(i, 0, model);
        }

        ChineseCulture.INSTANCE.getLogger().info("Registering Block Models.");
        for (Block b : RegisterBlock.BLOCKS) {
            ModelResourceLocation model = new ModelResourceLocation(b.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, model);
        }
    }
}
