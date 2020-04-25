package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class Blocks {
    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        // Register blocks manually.

    }
} 
