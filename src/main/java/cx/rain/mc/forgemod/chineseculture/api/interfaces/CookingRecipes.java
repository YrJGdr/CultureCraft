package cx.rain.mc.forgemod.chineseculture.api.interfaces;

import cx.rain.mc.forgemod.chineseculture.block.automatic.BlockStove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 菜谱类
 * 一般菜谱使用创建此类实例来注册。
 */
public class CookingRecipes extends ICooking{
    @Override
    public boolean matches(NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos) {
        return false;
    }

    @Override
    public ItemStack getCookingResult(NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos) {
        return null;
    }
}
