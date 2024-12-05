package com.example.starterhousemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemHouseSpawner extends Item {

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, 
	                          int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
	    if (!world.isRemote) {
	        // Spawn the house
	        HouseBuilder.buildHouse(world, x - 6, y, z - 3); // Adjust the X-coordinate by subtracting 6 and Y by adding 3

	        // Send a custom chat message to the player
	        player.addChatMessage(new ChatComponentText("Starter house created! Thank you for choosing Capsule Corp."));

	        // Play explosion sound effect
	        world.playSoundEffect(player.posX, player.posY, player.posZ, "random.explode", 1.0F, 1.0F);

	        // Remove the item from the player's inventory
	        player.inventory.consumeInventoryItem(this);
	    }
	    return true;
	}

	@Override
    public int getItemStackLimit(ItemStack stack) {
        return 1; // Set the maximum stack size to 1
    }
    
}
