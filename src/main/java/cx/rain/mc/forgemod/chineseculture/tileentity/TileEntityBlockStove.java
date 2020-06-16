package cx.rain.mc.forgemod.chineseculture.tileentity;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IMachine;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IThermal;
import cx.rain.mc.forgemod.chineseculture.block.BlockStove;
import cx.rain.mc.forgemod.chineseculture.init.RegistryCapability;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityBlockStove extends TileEntity implements IThermal, ITickable, IMachine{
    private int Thermal;
    private MachineState state;
    private int overloadTick;
    private int ThermalLossProgress=0;

    private IThermal ThermalCap = this;

    private IItemHandler handler = new ItemStackHandler(2);
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

    public void decThermal(){
        ThermalLossProgress++;
        if(ThermalLossProgress==5){
            ThermalLossProgress=0;
            if(Thermal!=0){
                Thermal-=1;
            }
        }
    }

    public void burningFuel(){
        ChineseCulture.INSTANCE.getLogger().info("Burn:"+handler.getStackInSlot(0).getDisplayName()+"in slot 0");
        ChineseCulture.INSTANCE.getLogger().info("Burn:"+handler.getStackInSlot(1).getDisplayName()+"in slot 1");
        for(int i=0;i<2;i++){
            if(handler.getStackInSlot(i)!= ItemStack.EMPTY){
                FuelProgress[i]+=1;
                Thermal+=(TileEntityFurnace.getItemBurnTime(handler.getStackInSlot(i))/100);
                if(FuelProgress[i]==100){
                    ChineseCulture.INSTANCE.getLogger().info("Burn:"+handler.getStackInSlot(i).getDisplayName());
                    handler.insertItem(i,ItemStack.EMPTY,false);
                    FuelProgress[i]=0;
                }
            }
        }
        this.markDirty();
    }

    @Override
    public void update() {
        if(this.world.isRemote&&state==MachineState.DAMAGED){
            return;
        }
        if(Thermal>400){
            if(Thermal>600||overloadTick>20*15){
                Thermal=0;
                state=MachineState.DAMAGED;
                BlockStove.transformMachineState(state,this.world,this.pos);
                this.markDirty();
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
        if(Thermal==0){
            state=MachineState.CLOSE;
            BlockStove.transformMachineState(state,this.world,this.pos);
            this.markDirty();
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
        this.markDirty();
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

    private static EnumFacing getFacing(IBlockAccess worldIn,BlockPos pos){
        return worldIn.getBlockState(pos).getValue(BlockStove.FACING);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.Thermal=compound.getInteger("Thermal");
        this.state=MachineState.valueOf(compound.getString("MachineState")==""?"CLOSE":compound.getString("MachineState"));
        this.overloadTick=compound.getInteger("OverloadTick");
        for(int i=0;i<2;i++){
            this.handler.insertItem(i,new ItemStack(compound.getCompoundTag("ItemStack"+i)),false);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("Thermal",Thermal);
        compound.setString("MachineState",state.toString());
        compound.setInteger("OverloadTick",overloadTick);
        for(int i=0;i<2;i++){
            compound.setTag("ItemStack"+i,this.handler.getStackInSlot(i).writeToNBT(new NBTTagCompound()));
        }
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
            return RegistryCapability.ThermalCapabilityOutput.cast(this.ThermalCap);
        }
        else  if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY&&facing==getFacing(world,pos)){
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(handler);
        }
        else {
            return super.getCapability(capability, facing);
        }
    }
}