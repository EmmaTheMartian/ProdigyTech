package lykrast.prodigytech.common.util;

import lykrast.prodigytech.common.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsProdigyTech extends CreativeTabs {
	
	public static final CreativeTabs instance = new CreativeTabsProdigyTech(CreativeTabs.getNextID(), "prodigytech");

	public CreativeTabsProdigyTech(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.aeroheaterSolid);
	}

}
