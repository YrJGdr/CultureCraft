package cx.rain.mc.forgemod.chineseculture.api.interfaces;

/**
 * 所有所有能够利用机械能的机器的TileEntity都要实现这个接口
 * MEnergy:MechanicalEnergy
 * @author flysong
 */
public interface IMEnergy {

    /**
     * 获得机器的机械能
     * @return 机械能
     * @author flysong
     */
    int getMEnergy();

    /**
     * 设置机器的机械能
     * @param MEnergy 机械能
     * @author flysong
     */
    void setMEnergy(int MEnergy);

    /**
     * 重置机器的机械能
     * @author flysong
     */
    void reset();

    /**
     * 增加机器的机械能
     * @param MEnergy 机械能
     * @author flysong
     */
    void addMEnergy(int MEnergy);

    /**
     * 减少机器的机械能
     * @param MEnergy 机械能
     * @author flysong
     */
    void subMEnergy(int MEnergy);
}
