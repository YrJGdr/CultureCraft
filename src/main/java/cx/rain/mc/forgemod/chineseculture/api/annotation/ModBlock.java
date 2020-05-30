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
     * 方块注册名
     * @return RegistryName
     */
    String name();

    /**
     * 未本地化名称
     * @return TranslateKey
     */
    String translate() default "";
}
