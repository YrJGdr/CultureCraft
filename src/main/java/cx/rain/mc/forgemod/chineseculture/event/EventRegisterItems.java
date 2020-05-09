package cx.rain.mc.forgemod.chineseculture.event;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.utility.SubClassHelper;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class EventRegisterItems {
    public static List<Item> ITEMS = new ArrayList<>();

    static {
        for (Class<? extends Item> clazz :
                SubClassHelper.getItems("cx.rain.mc.forgemod.chineseculture.item.automatic")) {
            try {
                ITEMS.add(clazz.getConstructor().newInstance());
            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InstantiationException
                    | InvocationTargetException ex) {
                ChineseCulture.INSTANCE.getLogger().warn("An item can't be instantiated.");
                ex.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Items.");

        for (Item i : ITEMS) {
            event.getRegistry().register(i);
        }
    }
}
