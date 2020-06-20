package cx.rain.mc.forgemod.chineseculture.block;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModBlock;
import cx.rain.mc.forgemod.chineseculture.api.game.interfaces.IMachine;
import cx.rain.mc.forgemod.chineseculture.api.game.block.BlockMachineBase;
import cx.rain.mc.forgemod.chineseculture.tileentity.TileEntityBlockStove;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;

@ModBlock(name = "stove", translate = "stove")
public class BlockStove extends BlockMachineBase {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum<IMachine.MachineState> STATE = PropertyEnum.create("state",IMachine.MachineState.class);

    public BlockStove() {
        super(Material.GROUND);
        this.setHardness(5F);
        this.setHarvestLevel("pickaxe",1);
        this.setCreativeTab(Tabs.MACHINE);
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, STATE);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        switch (state.getValue(STATE)){
            case OVERLOAD:
                return 15;
            case IDLE:
                return 12;
            case WORKING:
                return 8;
            case CLOSE:
            case DAMAGED:
            default:
                return 0;
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            TileEntity te = worldIn.getTileEntity(pos);
            if(te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,state.getValue(FACING))) {
                for (int i = 0; i < 2; i++) {
                    playerIn.setHeldItem(hand,te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, state.getValue(FACING)).insertItem(i,playerIn.getHeldItem(hand), false));
                    break;
                }
            }
            else{
                return false;
            }
            worldIn.setTileEntity(pos,te);
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityBlockStove();
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof IMachine){
            state.withProperty(STATE,((IMachine) te).getWorkingState());
        }
        return state;
    }
}