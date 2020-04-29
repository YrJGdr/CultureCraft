package cx.rain.mc.forgemod.chineseculture.block.tileentity;

import cx.rain.mc.forgemod.chineseculture.api.interfaces.IMachine;
import cx.rain.mc.forgemod.chineseculture.api.interfaces.IThermal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class tileEntityBlockStove extends TileEntity implements IThermal, ITickable, IMachine {
    private int Thermal;
    private MachineState state;

    @Override
    public int getThermal() {
        return Thermal;
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

    @Override
    public void update() {

    }

    public tileEntityBlockStove(){
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
}
