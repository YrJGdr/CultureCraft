package cx.rain.mc.forgemod.chineseculture.init;

import cx.rain.mc.forgemod.chineseculture.creativetab.CreativeTabMachine;
import net.minecraft.creativetab.CreativeTabs;

public class RegistryCreativeTab {
    public static CreativeTabs Machine;

    public RegistryCreativeTab(){
        Machine = new CreativeTabMachine();
    }
}
