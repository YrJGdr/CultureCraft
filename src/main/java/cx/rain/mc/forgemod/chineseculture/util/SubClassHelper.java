package cx.rain.mc.forgemod.chineseculture.util;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.HashSet;
import java.util.Set;

public class SubClassHelper {
    public static Set<Class<? extends Item>> getItems(String packageName) {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage(packageName))
                        .setScanners(
                                new SubTypesScanner(false),
                                new TypeAnnotationsScanner()
                        )
        );
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(ModItem.class);
        Set<Class<? extends Item>> items = new HashSet<>();
        for (Class<?> clazz : classes) {
            if (clazz.isAssignableFrom(Item.class)) {
                items.add((Class<? extends Item>) clazz);
            }
        }
        return items;
    }

    public static Set<Class<? extends Block>> getBlocks(String packageName) {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage(packageName))
                        .setScanners(
                                new SubTypesScanner(false),
                                new TypeAnnotationsScanner()
                        )
        );
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(ModBlock.class);
        Set<Class<? extends Block>> blocks = new HashSet<>();
        for (Class<?> clazz : classes) {
            if (clazz.isAssignableFrom(Item.class)) {
                blocks.add((Class<? extends Block>) clazz);
            }
        }
        return blocks;
    }
}
