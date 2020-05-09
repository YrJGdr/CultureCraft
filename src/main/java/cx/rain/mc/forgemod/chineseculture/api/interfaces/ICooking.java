package cx.rain.mc.forgemod.chineseculture.api.interfaces;

import cx.rain.mc.forgemod.chineseculture.block.automatic.BlockStove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 菜谱类。
 * 高级的菜谱通过继承他来实现。
 */
public interface ICooking extends IForgeRegistryEntry<ICooking> {
    /**
     * 判断物品组合是否符合这个菜谱的规则
     * @param items 烹饪组合
     * @param tool 厨具
     * @param player 玩家
     * @param worldIn 所在世界
     * @param stove 炉灶
     * @param pos 炉灶位置
     * @return 是否符合这个菜谱的规则
     */
    boolean matches(@Nonnull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos);

    /**
     * 获得菜谱的结果
     * @param items 烹饪组合
     * @param tool 厨具
     * @param player 玩家
     * @param worldIn 所在世界
     * @param stove 炉灶
     * @param pos 炉灶位置
     * @return 菜谱结果
     */
    ItemStack getCookingResult(@Nonnull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockStove stove, BlockPos pos);

    /**
     * 获得烹饪后剩下的物品
     * @param items 烹饪组合
     * @return 剩下的物品
     */
    default NonNullList<ItemStack> getRemainingItems(@Nonnull NonNullList<ItemStack> items){
        return NonNullList.create();
    }
}
