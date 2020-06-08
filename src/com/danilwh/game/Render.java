package com.danilwh.game;

import java.util.Random;

public class Render {
    private int width, height;
    private int[] pixels;
    private int tileIndex;
    private int tileSize = 16;
    private static final int MAP_SIZE = 64;
    private static final int MAP_SIZE_MASK = MAP_SIZE - 1;
    private int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private static final Random random = new Random();
    
    public Render(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
        this.fill();
    }
    
    private void fill() {
        /*** fill the array of tiles with random colors from 0, 0, 0 to 255, 255, 255 (RGB). ***/
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)  
            this.tiles[i] = random.nextInt(0xffffff);
    }
    
    public void clear() {
        /*** clears the screen. (fills the screen with black color. ***/
        for (int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = 0;
        }
    }
    
    public void render() {
        /***
         * Draws each pixel of the screen according to a tile's color
         * that is stored in the array of tiles.
        ***/
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.tileIndex = (x / this.tileSize) + (y / this.tileSize) * MAP_SIZE;
                this.pixels[x + (y * this.width)] = this.tiles[this.tileIndex];
            }
        }
    }
}
