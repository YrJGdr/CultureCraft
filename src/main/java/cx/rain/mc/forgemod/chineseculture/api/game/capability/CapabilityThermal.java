package cx.rain.mc.forgemod.chineseculture.api.game.capability;

import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IThermal;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import java.util.concurrent.Callable;

/**
 * Thermal output Capability
 * @author Infinity_rain
 */
public class CapabilityThermal {
    /**
     * Thermal output Storage
     */
    public static class Storage implements Capability.IStorage<IThermal>
    {
        @Override
        public NBTBase writeNBT(Capability<IThermal> capability, IThermal instance, EnumFacing side)
        {
            return new NBTTagInt(instance.getThermal());
        }

        @Override
        public void readNBT(Capability<IThermal> capability, IThermal instance, EnumFacing side, NBTBase nbt)
        {
            instance.setThermal(((NBTTagInt)nbt).getInt());
        }
    }

    /**
     * Thermal output factory method
     */
    public static class Factory implements Callable<IThermal> {

        @Override
        public IThermal call() throws Exception {
            return new CapabilityThermal.Factory.Implementation();
        }

        /**
         * Thermal output default implement
         */
        private class Implementation implements IThermal {
            private int Thermal;

            @Override
            public int getThermal() {
                return this.Thermal;
            }

            @Override
            public void setThermal(int Thermal) {
                this.Thermal=Thermal;
            }

            @Override
            public void resetThermal() {
                this.Thermal=0;
            }

            @Override
            public void addThermal(int Thermal) {
                this.Thermal+=Thermal;
            }

            @Override
            public void subThermal(int Thermal) {
                this.Thermal-=Thermal;
            }
        }
    }
}
