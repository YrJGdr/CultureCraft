package cx.rain.mc.forgemod.chineseculture.item.automatic;

import cx.rain.mc.forgemod.chineseculture.ChineseCulture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSpirits extends ItemFood {
    public ItemSpirits() {
        super(4, 0.3F, false);
        this.setUnlocalizedName(ChineseCulture.MODID+":spirits");
        this.setRegistryName(ChineseCulture.MODID, "spirits");
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabs.FOOD);
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
           player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20*8, 1 ));
           player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 2,2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20*8, 2 ));
           player.addPotionEffect(new PotionEffect(MobEffects.POISON, 20*8, 1 ));
           super.onFoodEaten(stack, world, player);
    }
}
