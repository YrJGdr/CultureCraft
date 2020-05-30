package cx.rain.mc.forgemod.chineseculture.core.registry;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.util.SubClassHelper;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@EventBusSubscriber(modid = ChineseCulture.MODID)
public class RegistryItems {
    public static Map<String, Item> ITEMS = new HashMap<>();

    static {
        for (Class<? extends Item> clazz :
                SubClassHelper.getItems("cx.rain.mc.forgemod.chineseculture.item")) {
            try {
                ModItem modItem = clazz.getAnnotation(ModItem.class);
                String name = modItem.name();
                String translateKey = modItem.translate();
                if (translateKey.equals("")) {
                    translateKey = name;
                }
                Item item = clazz.getConstructor().newInstance()
                        .setRegistryName(ChineseCulture.MODID, name)
                        .setUnlocalizedName(translateKey);
                ITEMS.put(name, item);
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
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        ChineseCulture.INSTANCE.getLogger().info("Registering Items.");
        ITEMS.forEach((name, item) -> {
            event.getRegistry().register(item);
        });
    }
}
