package cx.rain.mc.forgemod.chineseculture.api.capability;

import cx.rain.mc.forgemod.chineseculture.api.interfaces.IWindEnergy;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import java.util.concurrent.Callable;

/**
 * WindEnergy接口的Capability
 */
public class CapabilityWindEnergy {
    /**
     * WindEnergy接口的序列化类
     */
    public static class Storage implements Capability.IStorage<IWindEnergy>
    {
        @Override
        public NBTBase writeNBT(Capability<IWindEnergy> capability, IWindEnergy instance, EnumFacing side)
        {
            return new NBTTagInt(instance.getWindEnergy());
        }

        @Override
        public void readNBT(Capability<IWindEnergy> capability, IWindEnergy instance, EnumFacing side, NBTBase nbt)
        {
            instance.setWindEnergy(((NBTTagInt)nbt).getInt());
        }
    }

    /**
     * WindEnergy接口的工厂方法
     */
    public static class Factory implements Callable<IWindEnergy> {

        @Override
        public IWindEnergy call() throws Exception {
            return new CapabilityWindEnergy.Factory.Implementation();
        }

        /**
         * WindEnergy接口的默认实现类
         */
        private class Implementation implements IWindEnergy{
            private int WindEnergy;

            @Override
            public int getWindEnergy() {
                return this.WindEnergy;
            }

            @Override
            public void setWindEnergy(int WindEnergy) {
                this.WindEnergy=WindEnergy;
            }

            @Override
            public void resetWindEnergy() {
                this.WindEnergy=0;
            }

            @Override
            public void addWindEnergy(int WindEnergy) {
                this.WindEnergy+=WindEnergy;
            }

            @Override
            public void subWindEnergy(int WindEnergy) {
                this.WindEnergy-=WindEnergy;
            }
        }
    }
}
