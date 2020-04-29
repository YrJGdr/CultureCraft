package cx.rain.mc.forgemod.chineseculture.api.interfaces;

import com.sun.istack.internal.NotNull;
import cx.rain.mc.forgemod.chineseculture.block.automatic.BlockStove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 菜谱类。
 * 高级的菜谱通过继承他来实现。
 */
public abstract class ICooking {
    public abstract boolean matches(@NotNull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos);
    public abstract ItemStack getCookingResult(@NotNull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos);
}
