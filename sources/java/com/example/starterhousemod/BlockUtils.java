package com.example.starterhousemod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BlockUtils {

    // Converts a material string to a Block object
    public static Block getBlockForMaterial(String material) {
        switch (material.toLowerCase()) {
            case "wood":
                return Blocks.planks;
            case "glass":
                return Blocks.glass;
            case "stone":
                return Blocks.stonebrick;
            case "craftingtable":
                return Blocks.crafting_table;
            case "furnace":
                return Blocks.furnace;
            case "chest":
                return Blocks.chest;
            case "door":
                return Blocks.wooden_door;
            case "bed":
                return Blocks.bed;
            default:
                return Blocks.air; // Default to air if material is invalid
        }
    }
}
