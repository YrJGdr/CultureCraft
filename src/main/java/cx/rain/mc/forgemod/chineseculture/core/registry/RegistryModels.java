package cx.rain.mc.forgemod.chineseculture.core.registry;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryBlocks;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = ChineseCulture.MODID, value = Side.CLIENT)
public class RegistryModels {
    @SubscribeEvent
    public static void onRegisterModel(ModelRegistryEvent event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Item Models.");
        RegistryItems.ITEMS.forEach((name, item) -> {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, model);
        });

        ChineseCulture.INSTANCE.getLogger().info("Registering Block Models.");
        RegistryBlocks.BLOCKS.forEach((name, block) -> {
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
        });
    }
}
