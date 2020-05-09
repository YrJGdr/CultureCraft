package cx.rain.mc.forgemod.chineseculture.api.annotation;

import net.minecraft.creativetab.CreativeTabs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ModBlock annotation.
 * For auto register blocks.
 * Use on class extends Block.
 * @author Infinity_rain
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModBlock {
    /**
     * Block registry name.
     * @return RegistryName
     */
    String name();

    /**
     * I18n key for block name.
     * @return TranslateKey
     */
    String translate() default "";
}
