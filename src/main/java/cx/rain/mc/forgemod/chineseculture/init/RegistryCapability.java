package cx.rain.mc.forgemod.chineseculture.init;

import cx.rain.mc.forgemod.chineseculture.api.capability.*;
import cx.rain.mc.forgemod.chineseculture.api.interfaces.*;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RegistryCapability {
    @CapabilityInject(IMEnergy.class)
    public static Capability<IMEnergy> MEnergyCapability;

    @CapabilityInject(IThermal.class)
    public static Capability<IThermal> ThermalCapability;

    @CapabilityInject(IWaterPower.class)
    public static Capability<IWaterPower> WaterPowerCapability;

    @CapabilityInject(IWindEnergy.class)
    public static Capability<IWindEnergy> WindEnergyCapability;

    public RegistryCapability(FMLPreInitializationEvent event)
    {
        CapabilityManager.INSTANCE.register(IMEnergy.class, new CapabilityMEnergy.Storage(),new CapabilityMEnergy.Factory());
        CapabilityManager.INSTANCE.register(IThermal.class, new CapabilityThermal.Storage(),new CapabilityThermal.Factory());
        CapabilityManager.INSTANCE.register(IWaterPower.class, new CapabilityWaterPower.Storage(),new CapabilityWaterPower.Factory());
        CapabilityManager.INSTANCE.register(IWindEnergy.class, new CapabilityWindEnergy.Storage(),new CapabilityWindEnergy.Factory());
    }
}
