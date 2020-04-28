package cx.rain.mc.forgemod.chineseculture.api.interfaces;

/**
 * 所有能够利用风能机器的TileEntity都要实现这个接口
 * I:Interface
 * @author flysong
 */
public interface IWindEnergy {
    /**
     * 获得机器的风能
     * @return 风能
     * @author flysong
     */
    int getWindEnergy();

    /**
     * 设置机器的风能
     * @param WindEnergy 风能
     * @author flysong
     */
    void setWindEnergy(int WindEnergy);

    /**
     * 重置机器的风能
     * @author flysong
     */
    void resetWindEnergy();

    /**
     * 增加机器的风能
     * @param WindEnergy 风能
     * @author flysong
     */
    void addWindEnergy(int WindEnergy);

    /**
     * 减少机器的风能
     * @param WindEnergy 风能
     * @author flysong
     */
    void subWindEnergy(int WindEnergy);
}
