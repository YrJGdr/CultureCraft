package cx.rain.mc.forgemod.chineseculture.api.annotation;

import net.minecraft.creativetab.CreativeTabs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ModItem annotation.
 * For auto register items.
 * Use on class extends Item.
 * @author Infinity_rain
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModItem {
    /**
     * Item registry name.
     * @return RegistryName
     */
    String name();

    /**
     * I18n key for item name.
     * @return TranslateKey
     */
    String translate() default "";
}
