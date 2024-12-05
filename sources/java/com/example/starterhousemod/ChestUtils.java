package com.example.starterhousemod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class ChestUtils {

    // Add items to a chest only if it is the "primary" chest in a double chest
    public static void addItemsToChest(World world, int x, int y, int z) {
        // Ensure the block is a chest and get its tile entity
        if (world.getBlock(x, y, z) == Blocks.chest) {
            TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
            if (chest != null) {
                // Check if this is the "primary" chest in a double chest
                if (isPrimaryChest(world, x, y, z)) {
                    // Add a door and a bed to the chest
                    chest.setInventorySlotContents(0, new ItemStack(Items.wooden_door, 1)); // Slot 0: Door
                    chest.setInventorySlotContents(1, new ItemStack(Items.bed, 1));        // Slot 1: Bed
                }
            }
        }
    }

    // Helper method to determine if this chest is the "primary" chest in a double chest
    public static boolean isPrimaryChest(World world, int x, int y, int z) {
        // Check adjacent blocks for another chest
        boolean hasNeighborChest =
                (world.getBlock(x + 1, y, z) == Blocks.chest) ||
                (world.getBlock(x - 1, y, z) == Blocks.chest) ||
                (world.getBlock(x, y, z + 1) == Blocks.chest) ||
                (world.getBlock(x, y, z - 1) == Blocks.chest);

        // If this chest has no neighbors, it's a single chest, so it's primary
        if (!hasNeighborChest) {
            return true;
        }

        // If there is a neighbor chest, ensure only one chest adds items by picking the one with the lowest coordinates
        return (world.getBlock(x + 1, y, z) == Blocks.chest && x < x + 1) ||
               (world.getBlock(x - 1, y, z) == Blocks.chest && x < x - 1) ||
               (world.getBlock(x, y, z + 1) == Blocks.chest && z < z + 1) ||
               (world.getBlock(x, y, z - 1) == Blocks.chest && z < z - 1);
    }
}
