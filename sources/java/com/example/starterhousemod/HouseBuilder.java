package com.example.starterhousemod;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class HouseBuilder {

    public static void buildHouse(World world, int x, int y, int z) {
        for (int i = 0; i < HouseCoordinates.COORDINATES.length; i++) {
            for (String coordinate : HouseCoordinates.COORDINATES[i]) {
                // Parse the coordinates: Color, Depth (Z), Width (X), Material
                String[] parts = coordinate.split(",");
                String color = parts[0];
                int depth = Integer.parseInt(parts[1]);
                char width = parts[2].charAt(0);
                String material = parts[3];

                // Use the utility classes to determine height and block type
                int height = HeightUtils.getHeightForColor(color);
                Block block = BlockUtils.getBlockForMaterial(material);

                // Convert letter (A-H) to numeric width
                int widthInt = letterToNumber(width);

                // Calculate the final coordinates
                int blockX = x + widthInt;
                int blockY = y + height;
                int blockZ = z + depth - 1;

                // Place the block in the world
                world.setBlock(blockX, blockY, blockZ, block);

                // If the block is a chest, add items to it
                if (block == BlockUtils.getBlockForMaterial("chest")) {
                    ChestUtils.addItemsToChest(world, blockX, blockY, blockZ);
                }
            }
        }
    }

    // Converts a letter (A-H) to a numeric width (0-7)
    private static int letterToNumber(char letter) {
        return letter - 'A';
    }
}
