package cx.rain.mc.forgemod.chineseculture.proxy;

import cx.rain.mc.forgemod.chineseculture.init.RegistryCapability;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
        new RegistryCapability(event);
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
