package net.minecraft.enchantment;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBowBauxite;
import net.minecraft.item.ItemBowGranite;
import net.minecraft.item.ItemBowMeteor;
import net.minecraft.item.ItemBowOpale;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public enum EnumEnchantmentType
{
    all,
    armor,
    armor_feet,
    armor_legs,
    armor_torso,
    armor_head,
    weapon,
    digger,
    fishing_rod,
    breakable,
    bow;
    private static final String __OBFID = "CL_00000106";

    /**
     * Return true if the item passed can be enchanted by a enchantment of this type.
     */
    public boolean canEnchantItem(Item par1Item)
    {
        if (this == all)
        {
            return true;
        }
        else if (this == breakable && par1Item.isDamageable())
        {
            return true;
        }
        else if (par1Item instanceof ItemArmor)
        {
            if (this == armor)
            {
                return true;
            }
            else
            {
                ItemArmor var2 = (ItemArmor)par1Item;
                return var2.armorType == 0 ? this == armor_head : (var2.armorType == 2 ? this == armor_legs : (var2.armorType == 1 ? this == armor_torso : (var2.armorType == 3 ? this == armor_feet : false)));
            }
        }
        else
        {
            return par1Item instanceof ItemSword ? this == weapon : 
            	(par1Item instanceof ItemTool ? this == digger : 
            	(par1Item instanceof ItemBow ? this == bow : 
            		// Alkazia - add enchantment for bow
            		(par1Item instanceof ItemBowBauxite ? this == bow : 
            			(par1Item instanceof ItemBowGranite ? this == bow : 
            				(par1Item instanceof ItemBowOpale ? this == bow : 
            					(par1Item instanceof ItemBowMeteor ? this == bow : 
            		(par1Item instanceof ItemFishingRod ? this == fishing_rod : false)))))));
        }
    }
}
