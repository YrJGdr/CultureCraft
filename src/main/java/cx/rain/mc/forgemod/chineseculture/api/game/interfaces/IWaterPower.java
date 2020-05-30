package cx.rain.mc.forgemod.chineseculture.api.game.interfaces;

/**
 * 所有能够利用水能的机器的TileEntity都要实现这个接口
 * I:Interface
 * @author flysong
 */
public interface IWaterPower {
    /**
     * 获得机器的水能
     * @return 水能
     * @author flysong
     */
    int getWaterPower();

    /**
     * 设置机器的水能
     * @param WaterPower 水能
     * @author flysong
     */
    void setWaterPower(int WaterPower);

    /**
     * 重置机器的水能
     * @author flysong
     */
    void resetWaterPower();

    /**
     * 增加机器的水能
     * @param WaterPower 水能
     * @author flysong
     */
    void addWaterPower(int WaterPower);

    /**
     * 减少机器的水能
     * @param WaterPower 水能
     * @author flysong
     */
    void subWaterPower(int WaterPower);
}
