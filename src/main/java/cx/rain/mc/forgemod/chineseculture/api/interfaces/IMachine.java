package cx.rain.mc.forgemod.chineseculture.api.interfaces;

/**
 * 所有机器的TileEntity都必须实现这个接口
 * @author flysong
 */
public interface IMachine {
    /**
     * 获得机器状态
     * @return 机器状态
     * @author flysong
     */
    MachineState getWorkingState();

    /**
     * 设置机器状态
     * @param state 机器状态
     * @author flysong
     */
    void setWorkingState(MachineState state);

    /**
     * 机器状态类
     * 所有的机器都必须处于5种状态其一
     * @author flysong
     */
    enum MachineState
    {
        /**关闭*/
        CLOSE("Close"),
        /**空闲*/
        IDLE("IDLE"),
        /**工作*/
        WORKING("Working"),
        /**过载*/
        OVERLOAD("Overload"),
        /**损坏*/
        DAMAGED("Damaged");
        private String name;

        /**
         * 获得该枚举常量的名字
         * @return 该枚举常量的名字
         */
        public String getName(){
            return name;
        }

        MachineState(String name){
            this.name=name;
        }
    }
}
