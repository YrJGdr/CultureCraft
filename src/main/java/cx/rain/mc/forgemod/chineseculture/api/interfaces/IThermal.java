package cx.rain.mc.forgemod.chineseculture.api.interfaces;

/**
 * 所有能够利用热力的机器的TileEntity都要实现这个接口
 * I:Interface
 * @author flysong
 */
public interface IThermal {
    /**
     * 获得机器的热力
     * @return 热力
     * @author flysong
     */
    int getThermal();

    /**
     * 设置机器的热力
     * @param Thermal 热力
     * @author flysong
     */
    void setThermal(int Thermal);

    /**
     * 重置机器的热力
     * @author flysong
     */
    void resetThermal();

    /**
     * 增加机器的热力
     * @param Thermal 热力
     * @author flysong
     */
    void addThermal(int Thermal);

    /**
     * 减少机器的热力
     * @param Thermal 热力
     * @author flysong
     */
    void subThermal(int Thermal);
}
