package cx.rain.mc.forgemod.chineseculture.api.interfaces;

import net.minecraft.util.IStringSerializable;

/**
 * 所有机器的TileEntity都必须实现这个接口
 * I:Interface
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
    enum MachineState implements IStringSerializable {
        /**关闭*/
        CLOSE("close"),
        /**空闲*/
        IDLE("idle"),
        /**工作*/
        WORKING("working"),
        /**过载*/
        OVERLOAD("overload"),
        /**损坏*/
        DAMAGED("damaged");
        private String name;

        /**
         * 获得该枚举常量的名字
         * @return 该枚举常量的名字
         */
        @Override
        public String getName(){
            return name;
        }

        MachineState(String name){
            this.name=name;
        }
    }
}
