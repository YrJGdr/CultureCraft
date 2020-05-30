package cx.rain.mc.forgemod.chineseculture.api.game.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;

/**
 * Recipe interface
 * The advanced recipe from ChineseCulture or ChineseCulture extend must implements it
 */
public interface ICooking extends IForgeRegistryEntry<ICooking> {
    /**
     * Judge item set is meeting the rules of this recipe
     * @param items Item set
     * @param tool Cooking tool
     * @param player player
     * @param worldIn the world of player in
     * @param pos the pos
     * @return Is item set meeting the rules of this recipe
     */
    boolean matches(@Nonnull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockPos pos);

    /**
     * Get the result of this recipe
     * @param items Item set
     * @param tool Cooking tool
     * @param player player
     * @param worldIn the world of player in
     * @param pos the pos
     * @return the result of this recipe
     */
    ItemStack getCookingResult(@Nonnull NonNullList<ItemStack> items, ICookingTool tool, EntityPlayer player, World worldIn, BlockPos pos);

    /**
     * Get remaining items after cooked
     * @param items Item set
     * @return Remaining items
     */
    default NonNullList<ItemStack> getRemainingItems(@Nonnull NonNullList<ItemStack> items){
        return NonNullList.create();
    }
}
