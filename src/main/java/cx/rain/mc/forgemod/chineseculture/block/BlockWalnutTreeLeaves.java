package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.core.registry.RegistryBlocks;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

@ModBlock(name = "walnut_tree_leaves",translate = "walnutTreeLeaves")
public class BlockWalnutTreeLeaves extends BlockLeaves {
    public BlockWalnutTreeLeaves() {
        super();
        this.setCreativeTab(Tabs.BLOCK);
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));
    }

    @Override
    public final BlockPlanks.EnumType getWoodType(int meta) {
        return BlockPlanks.EnumType.OAK;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(RegistryBlocks.BLOCKS.get("walnut_tree_sapling"));
    }

    @Override
    public int getSaplingDropChance(IBlockState state) {
        return 40;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1,new ItemStack(this));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (!state.getValue(DECAYABLE).booleanValue()) {
            i |= 2;
        }
        if (state.getValue(CHECK_DECAY).booleanValue()) {
            i |= 4;
        }
        return i;
    }
}