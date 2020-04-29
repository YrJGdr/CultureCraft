package cx.rain.mc.forgemod.chineseculture.api.interfaces;

/**
 * 厨具类
 * 所有的厨具都要实现这个接口
 */
public interface ICookingTool {
    /**
     * 获得厨具类型
     * @return 厨具的类型
     */
    String getCookingToolClass();

    /**
     * 设置厨具类型
     * @param clazz 厨具的类型
     */
    void setCookingToolClass(String clazz);

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
