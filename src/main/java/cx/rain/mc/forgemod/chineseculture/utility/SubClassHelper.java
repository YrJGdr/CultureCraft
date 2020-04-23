package cx.rain.mc.forgemod.chineseculture.utility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;

public class SubClassHelper {
    public static Set<Class<? extends Item>> getItems(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Item.class);
    }

    public static Set<Class<? extends Block>> getBlocks(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Block.class);
    }
}
