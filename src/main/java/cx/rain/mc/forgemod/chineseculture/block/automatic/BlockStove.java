package cx.rain.mc.forgemod.chineseculture.block.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockStove extends Block {
    public BlockStove() {
        super(Material.GROUND);
        setUnlocalizedName("stove");
        setRegistryName(ChineseCulture.MODID, "stove");
    }
}