package cx.rain.mc.forgemod.chineseculture.api.annotation;

import net.minecraft.creativetab.CreativeTabs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Todo
/**
 * For setting creative tabs.
 * @author Infinity_rain
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Creative {
    /**
     * Creative Tabs.
     * @return CreativeTab
     */
    Class<? extends CreativeTabs>[] Tabs();
}
