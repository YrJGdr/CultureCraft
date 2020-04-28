package cx.rain.mc.forgemod.chineseculture.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class SubClassHelper {
    public static Set<Class<? extends Item>> getItems(String packageName) {
        // Fixme: Bad impl.
        /*
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setScanners(
                                new SubTypesScanner(false)
                                        .filterResultsBy(
                                                new FilterBuilder()
                                                        .excludePackage("net.minecraft.item")
                                        )
                        )
                        .setUrls(ClasspathHelper.forPackage(packageName))
                        .filterInputsBy(
                                new FilterBuilder()
                                        .includePackage(packageName)
                        )
        );

        for (Class<? extends Item> clazz : reflections.getSubTypesOf(Item.class)) {
            System.out.println(clazz.toString());
        }
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));

        for (Class<? extends Item> clazz : getClasses(packageName, Item.class)) {
            System.out.println(clazz.toString());
        }
        return getClasses(packageName, Item.class);
         */
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Item.class);
    }

    public static Set<Class<? extends Block>> getBlocks(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Block.class);
    }

    /*
    private static <T> List<Class<? extends T>> getClasses(String packageName, Class<T> clazz) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace(".", "/");
        List<Class<? extends T>> classes = new ArrayList<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> files = new ArrayList<>();
            while (resources.hasMoreElements()) {
                URL res = resources.nextElement();
                files.add(new File(res.getFile()));
            }
            for (File f : files) {
                classes.addAll(findClasses(f, packageName, clazz));
            }
        } catch (IOException ex) {
            // Silence is gold.
        }
        return classes;
    }

    private static <T> List<Class<? extends T>> findClasses(File f, String packageName, Class<T> clazz) {
        List<Class<? extends T>> classes = new ArrayList<>();
        if (!f.exists()) {
            return classes;
        }
        File[] files = f.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName(), clazz));
            } else if (file.getName().endsWith(".class")) {
                try {
                    Class<?> c = Class.forName(
                            packageName + "." + file.getName().substring(0, file.getName().length() - 6));
                    if (c.isAssignableFrom(clazz)) {
                        classes.add(c);
                    }
                } catch (ClassNotFoundException ex) {
                    // Silence is gold.
                }
            }
        }
    }
     */
}
