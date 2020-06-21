package cx.rain.mc.forgemod.chineseculture.tileentity;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.api.game.capability.FuelStackHandler;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IMachine;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IThermal;
import cx.rain.mc.forgemod.chineseculture.api.game.tileentity.TileEntityMachineBase;
import cx.rain.mc.forgemod.chineseculture.block.BlockStove;
import cx.rain.mc.forgemod.chineseculture.init.RegistryCapability;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityBlockStove extends TileEntityMachineBase implements IThermal, ITickable, IMachine{
    private int Thermal;
    private int overloadTick;
    private int ThermalLossProgress=0;

    private IThermal ThermalCap = this;

    private ItemStackHandler handler;
    private int[] FuelProgress = new int[]{0, 0};

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
        isChange=true;
        this.updateData();
    }

    @Override
    public void resetThermal() {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal=0;
        isChange=true;
        this.updateData();
    }

    @Override
    public void addThermal(int Thermal) {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal+=Thermal;
        isChange=true;
        this.updateData();
    }

    @Override
    public void subThermal(int Thermal) {
        if(state==MachineState.DAMAGED){
            return;
        }
        this.Thermal-=Thermal;
        isChange=true;
        this.updateData();
    }

    public void decThermal(){
        if(Thermal==0){
            return;
        }
        ThermalLossProgress++;
        if(ThermalLossProgress==5){
            ThermalLossProgress=0;
            Thermal-=1;
        }
        isChange=true;
        this.updateData();
    }

    public void burningFuel(){
        ChineseCulture.INSTANCE.getLogger().info("Burning:"+handler.getStackInSlot(0).getDisplayName()+"in slot 0");
        ChineseCulture.INSTANCE.getLogger().info("Burning:"+handler.getStackInSlot(1).getDisplayName()+"in slot 1");
        for(int i=0;i<2;i++){
            if(handler.getStackInSlot(i)!= ItemStack.EMPTY){
                FuelProgress[i]+=1;
                Thermal+=(TileEntityFurnace.getItemBurnTime(handler.getStackInSlot(i))/100);
                if(FuelProgress[i]==100){
                    ChineseCulture.INSTANCE.getLogger().info("Burned:"+handler.getStackInSlot(i).getDisplayName());
                    handler.insertItem(i,ItemStack.EMPTY,false);
                    FuelProgress[i]=0;
                }
                isChange=true;
            }
        }
        this.updateData();
    }

    @Override
    public void update() {
        ChineseCulture.INSTANCE.getLogger().info("In:"+handler.getStackInSlot(0).getDisplayName()+"in slot 0");
        ChineseCulture.INSTANCE.getLogger().info("In:"+handler.getStackInSlot(1).getDisplayName()+"in slot 1");
        if(this.world.isRemote||state==MachineState.DAMAGED){
            return;
        }
        this.updateData();
        if(Thermal>400){
            if(Thermal>600||overloadTick>20*15){
                Thermal=0;
                state=MachineState.DAMAGED;
                BlockStove.transformMachineState(state,this.world,this.pos);
                isChange=true;
                this.updateData();
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

        burningFuel();

        ChineseCulture.INSTANCE.getLogger().info("Burn:"+handler.getStackInSlot(0).getDisplayName()+"in slot 0");
        ChineseCulture.INSTANCE.getLogger().info("Burn:"+handler.getStackInSlot(1).getDisplayName()+"in slot 1");
        if(Thermal==0){
            state=MachineState.CLOSE;
            BlockStove.transformMachineState(state,this.world,this.pos);
            isChange=true;
            this.updateData();
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
        decThermal();
        this.updateData();
    }

    public TileEntityBlockStove(){
        Thermal=0;
        state=MachineState.CLOSE;
        handler=new FuelStackHandler(2);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.Thermal=compound.getInteger("Thermal");
        this.overloadTick=compound.getInteger("OverloadTick");
        this.handler.deserializeNBT(compound.getCompoundTag("Fuels"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Thermal",Thermal);
        compound.setInteger("OverloadTick",overloadTick);
        compound.setTag("Fuels",handler.serializeNBT());
        compound.setIntArray("FuelProgress",FuelProgress);
        return super.writeToNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return (capability==RegistryCapability.ThermalCapabilityOutput&&facing==EnumFacing.UP)||(capability==CapabilityItemHandler.ITEM_HANDLER_CAPABILITY&&facing==getFacing(world,pos))||super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == RegistryCapability.ThermalCapabilityOutput&&facing==EnumFacing.UP) {
            isChange=true;
            return RegistryCapability.ThermalCapabilityOutput.cast(this.ThermalCap);
        }
        else  if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY&&facing==getFacing(world,pos)){
            isChange=true;
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(handler);
        }
        else {
            return super.getCapability(capability, facing);
        }
    }
}