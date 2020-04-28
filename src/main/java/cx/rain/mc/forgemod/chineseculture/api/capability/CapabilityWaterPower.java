package cx.rain.mc.forgemod.chineseculture.api.capability;

import cx.rain.mc.forgemod.chineseculture.api.interfaces.IWaterPower;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import java.util.concurrent.Callable;

/**
 * WaterPower接口的Capability
 */
public class CapabilityWaterPower {
    /**
     * WaterPower接口的序列化类
     */
    public static class Storage implements Capability.IStorage<IWaterPower>
    {
        @Override
        public NBTBase writeNBT(Capability<IWaterPower> capability, IWaterPower instance, EnumFacing side)
        {
            return new NBTTagInt(instance.getWaterPower());
        }

        @Override
        public void readNBT(Capability<IWaterPower> capability, IWaterPower instance, EnumFacing side, NBTBase nbt)
        {
            instance.setWaterPower(((NBTTagInt)nbt).getInt());
        }
    }

    /**
     * WaterPower接口的工厂方法
     */
    public static class Factory implements Callable<IWaterPower> {

        @Override
        public IWaterPower call() throws Exception {
            return new CapabilityWaterPower.Factory.Implementation();
        }

        /**
         * WaterPower接口的默认实现类
         */
        private class Implementation implements IWaterPower{
            private int WaterPower;

            @Override
            public int getWaterPower() {
                return this.WaterPower;
            }

            @Override
            public void setWaterPower(int WaterPower) {
                this.WaterPower=WaterPower;
            }

            @Override
            public void reset() {
                this.WaterPower=0;
            }

            @Override
            public void addWaterPower(int WaterPower) {
                this.WaterPower+=WaterPower;
            }

            @Override
            public void subWaterPower(int WaterPower) {
                this.WaterPower-=WaterPower;
            }
        }
    }
}
