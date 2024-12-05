package com.example.starterhousemod;

public class HeightUtils {

    // Converts a color to a Y-coordinate (height)
    public static int getHeightForColor(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return 0;
            case "black":
                return 1;
            case "yellow":
                return 2;
            case "blue":
                return 3;
            case "pink":
                return 4;
            case "orange":
                return 5;
            case "white":
                return 6;
            default:
                return -1; // Invalid color
        }
    }
}
