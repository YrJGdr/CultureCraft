package cx.rain.mc.forgemod.chineseculture.api.game.interfaces;

/**
 * Cooking tool interface
 * Every cooking tool from ChineseCulture or ChineseCulture extend must implements it
 */
public interface ICookingTool {
    /**
     * Get the type of cooking tool
     * @return the type of cooking tool
     */
    String getCookingToolType();

    /**
     * Set the type of cooking tool
     * @param type the type of cooking tool
     */
    void setCookingToolType(String type);

    /**
     * 获得厨具等级
     * @return 厨具的等级
     */
    int getCookingToolLevel();

    /**
     * 设置厨具等级
     * @param level 厨具的等级
     */
    void setCookingToolLevel(int level);
}
