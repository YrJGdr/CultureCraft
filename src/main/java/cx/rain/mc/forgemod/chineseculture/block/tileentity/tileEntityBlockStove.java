package cx.rain.mc.forgemod.chineseculture.block.tileentity;

import cx.rain.mc.forgemod.chineseculture.api.interfaces.IThermal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class tileEntityBlockStove extends TileEntity implements IThermal, ITickable {
    private int Thermal;

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
}
