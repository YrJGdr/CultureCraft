package cx.rain.mc.forgemod.chineseculture.tileentity;

import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IMachine;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IThermal;
import cx.rain.mc.forgemod.chineseculture.block.BlockStove;
import cx.rain.mc.forgemod.chineseculture.init.RegistryCapability;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class TileEntityBlockStove extends TileEntity implements IThermal, ITickable, IMachine {
    private int Thermal;
    private MachineState state;
    private int overloadTick;
    private int ThermalLossProgress=0;

    private IThermal ThermalCap = this;

    @Override
    public int getThermal() {
        return Thermal;
    }

    @Override
    public void setThermal(int Thermal) {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal=Thermal;
    }

    @Override
    public void resetThermal() {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal=0;
    }

    @Override
    public void addThermal(int Thermal) {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal+=Thermal;
    }

    @Override
    public void subThermal(int Thermal) {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal-=Thermal;
    }

    @Override
    public void update() {
        if(this.world.isRemote){
            return;
        }
        if(state==MachineState.DAMAGED){
            return;
        }
        if(Thermal>400){
            if(Thermal>600||overloadTick>20*15){
                Thermal=0;
                state=MachineState.DAMAGED;
                BlockStove.transformMachineState(state,this.world,this.pos);
                return;
            }
            else if(state!=MachineState.OVERLOAD){
                state=MachineState.OVERLOAD;
            }
        }
        else{
            if(state==MachineState.OVERLOAD){
                overloadTick=0;
                state=MachineState.IDLE;
            }
        }

        if(Thermal==0){
            state=MachineState.CLOSE;
            IBlockState blockstate = this.world.getBlockState(this.pos);
            blockstate = blockstate.getBlock().getActualState(blockstate,this.world,this.pos);
            this.world.setBlockState(this.pos,blockstate);
            return;
        }
        else{
            if(state==MachineState.CLOSE){
                state=MachineState.IDLE;
            }
        }

        BlockStove.transformMachineState(state,this.world,this.pos);

        if(state==MachineState.OVERLOAD){
            overloadTick++;
        }
        ThermalLossProgress++;
        if(ThermalLossProgress==5){
            ThermalLossProgress=0;
            Thermal-=1;
        }
    }

    public TileEntityBlockStove(){
        Thermal=0;
        state=MachineState.CLOSE;
    }

    @Override
    public MachineState getWorkingState() {
        return state;
    }

    @Override
    public void setWorkingState(MachineState state) {
        this.state=state;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.Thermal=compound.getInteger("Thermal");
        this.state=MachineState.valueOf(compound.getString("MachineState"));
        this.overloadTick=compound.getInteger("OverloadTick");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Thermal",Thermal);
        compound.setString("MachineState",state.toString());
        compound.setInteger("OverloadTick",overloadTick);
        return super.writeToNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability==RegistryCapability.ThermalCapability||super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == RegistryCapability.ThermalCapability) {
            return RegistryCapability.ThermalCapability.cast(this.ThermalCap);
        } else {
            return super.getCapability(capability, facing);
        }
    }
}
