package cx.rain.mc.forgemod.chineseculture.api.game.interfaces;

/**
 * All Tile Entity of machines that can output wind energy must implement this interface
 * @author Infinity_rain
 */
public interface IWindEnergy {
    /**
     * Get wind energy
     * @return Wind energy
     * @author flysong
     */
    int getWindEnergy();

    /**
     * Set wind energy
     * @param WindEnergy Wind energy
     * @author flysong
     */
    void setWindEnergy(int WindEnergy);

    /**
     * Reset wind energy
     * @author flysong
     */
    void resetWindEnergy();

    /**
     * Add wind energy
     * @param WindEnergy Wind energy
     * @author flysong
     */
    void addWindEnergy(int WindEnergy);

    /**
     * Sub wind energy
     * @param WindEnergy Wind energy
     * @author flysong
     */
    void subWindEnergy(int WindEnergy);
}
