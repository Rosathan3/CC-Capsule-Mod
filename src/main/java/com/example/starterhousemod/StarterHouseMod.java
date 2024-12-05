package com.example.starterhousemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = StarterHouseMod.MODID, name = StarterHouseMod.NAME, version = StarterHouseMod.VERSION)
public class StarterHouseMod {
    public static final String MODID = "starterhousemod";
    public static final String NAME = "CC Capsule Mod";
    public static final String VERSION = "1.0";

    // Define the custom item
    public static Item houseSpawnerItem;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Create the custom item
        houseSpawnerItem = new ItemHouseSpawner()
                .setUnlocalizedName("houseSpawnerItem") // Internal name
                .setTextureName(MODID + ":house_spawner") // Texture path (assets/starterhousemod/textures/items/house_spawner.png)
                .setCreativeTab(CC_Capsule_Mod); // Add to Misc tab in Creative Mode

        // Register the item
        GameRegistry.registerItem(houseSpawnerItem, "houseSpawnerItem");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Additional setup if needed
    	
    	GameRegistry.addRecipe(new ItemStack(houseSpawnerItem, 1), new Object[]{"TFC",
            																	"IBI",
            																	"WSG", 'T', Blocks.crafting_table, 'F', Blocks.furnace, 'C', Blocks.chest, 'G', Blocks.glass, 'S', Blocks.stonebrick, 'W', Blocks.planks, 'I', Blocks.iron_block, 'B', Items.bed,});
    	
    }
    
    public static CreativeTabs CC_Capsule_Mod = new CreativeTabs("CC_Capsule_Mod"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(houseSpawnerItem).getItem();
		}
	};
}
