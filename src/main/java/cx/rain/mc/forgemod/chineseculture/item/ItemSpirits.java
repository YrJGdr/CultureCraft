package cx.rain.mc.forgemod.chineseculture.item;

import cx.rain.mc.forgemod.chineseculture.api.annotation.ModItem;
import cx.rain.mc.forgemod.chineseculture.tab.Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

@ModItem(name = "spirits", translate = "spirits")
public class ItemSpirits extends ItemFood {
    public ItemSpirits() {
        super(4, 0.3F, false);
        this.setAlwaysEdible();
        this.setCreativeTab(Tabs.FOOD);
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
