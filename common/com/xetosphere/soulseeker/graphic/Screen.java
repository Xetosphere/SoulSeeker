package com.xetosphere.titanproject.graphic;

import java.util.Random;

public class Screen {

	private int width, height;
	public int[] pixels;

	private final int MAP_SIZE = 64;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {

		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}

		tiles[0] = 0;
	}

	public void clear() {

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {

		for (int y = 0; y < height; y++) {
			int yy = y + yOffset;
			//if (yy >= height || yy < 0) break;
			for (int x = 0; x < width; x++) {
				int xx = x + xOffset;
				//if (xx >= width || xx < 0) break;
				int tileIndex = ((xx >> 4) & MAP_SIZE - 1) + ((yy >> 4) & MAP_SIZE - 1) * MAP_SIZE;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}

}
