package cx.rain.mc.forgemod.chineseculture.recipes.cooking;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.ICooking;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.ICookingTool;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IThermal;
import cx.rain.mc.forgemod.chineseculture.block.BlockStove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

/**
 * 普通菜谱类
 * 一般菜谱使用创建此类实例来注册。
 */
public class CookingRecipes extends IForgeRegistryEntry.Impl<ICooking> implements ICooking{
    private int toolLevel;
    private String toolClass;
    private int minThermal;
    private int maxThermal;
    private NonNullList<ItemStack> stacks;
    private ItemStack recipeResult;

    /**
     * @param registryName 注册名
     * @param toolLevel 厨具最低等级
     * @param toolClass 厨具类型
     * @param minThermal 最低热力值
     * @param maxThermal 最大热力值
     * @param recipeResult 菜谱结果
     * @param stacks 物品组合，可使用var-arg形式
     */
    public CookingRecipes(String registryName,int toolLevel,String toolClass,int minThermal,int maxThermal,ItemStack recipeResult,ItemStack... stacks){
        this.setRegistryName(registryName);
        this.toolLevel=toolLevel;
        this.toolClass=toolClass;
        this.minThermal=minThermal;
        this.maxThermal=maxThermal;
        this.recipeResult=recipeResult;
        this.stacks = NonNullList.create();
        for (ItemStack stack : stacks){
            this.stacks.add(stack);
        }
    }

    @Override
    public boolean matches(NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockPos pos) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof IThermal){
            int t = ((IThermal) te).getThermal();
            if(t<minThermal){
                return false;
            }
            else if(items.equals(stacks)){
                if(tool.getCookingToolType()==toolClass&&tool.getCookingToolLevel()>=toolLevel){
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public ItemStack getCookingResult(NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockPos pos) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof IThermal) {
            int t = ((IThermal) te).getThermal();
            if(t>maxThermal){
                return new ItemStack(Item.getByNameOrId(ChineseCulture.MODID+":charred_food"),1);
            }
            else{
                return recipeResult;
            }
        }
        return ItemStack.EMPTY;
    }
}
