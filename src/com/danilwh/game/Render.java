package com.danilwh.game;

public class Render {
    private int width, height;
    private int[] pixels;
    
    public Render(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }
    
    public void clear() {
        /*** clears the screen. ***/
        for (int i = 0; i < this.pixels.length; i++) {
            this.pixels[i] = 0;
        }
    }
    
    public void render() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.pixels[x + (y * this.width)] = 0;
            }
        }
    }
}
