package cx.rain.mc.forgemod.chineseculture.api.capability;

import cx.rain.mc.forgemod.chineseculture.api.interfaces.IMEnergy;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import java.util.concurrent.Callable;

/**
 * MEnergy接口的Capability
 */
public class CapabilityMEnergy {

    /**
     * MEnergy接口的序列化类
     */
    public static class Storage implements Capability.IStorage<IMEnergy>
    {
        @Override
        public NBTBase writeNBT(Capability<IMEnergy> capability, IMEnergy instance, EnumFacing side)
        {
            return new NBTTagInt(instance.getMEnergy());
        }

        @Override
        public void readNBT(Capability<IMEnergy> capability, IMEnergy instance, EnumFacing side, NBTBase nbt)
        {
            instance.setMEnergy(((NBTTagInt)nbt).getInt());
        }
    }

    /**
     * MEnergy接口的工厂方法
     */
    public static class Factory implements Callable<IMEnergy> {

        @Override
        public IMEnergy call() throws Exception {
            return new Implementation();
        }

        /**
         * MEnergy的接口默认实现类
         */
        private class Implementation implements IMEnergy{
            private int MEnergy;

            @Override
            public int getMEnergy() {
                return this.MEnergy;
            }

            @Override
            public void setMEnergy(int MEnergy) {
                this.MEnergy=MEnergy;
            }

            @Override
            public void resetMEnergy() {
                this.MEnergy=0;
            }

            @Override
            public void addMEnergy(int MEnergy) {
                this.MEnergy+=MEnergy;
            }

            @Override
            public void subMEnergy(int MEnergy) {
                this.MEnergy-=MEnergy;
            }
        }
    }
}
