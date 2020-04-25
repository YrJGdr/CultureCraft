package cx.rain.mc.forgemod.chineseculture.item;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@EventBusSubscriber(modid = ChineseCulture.MODID)
public class Items {
    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        // Register items manually.

    }
} 
