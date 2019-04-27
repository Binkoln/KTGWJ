package game.world;

import java.util.ArrayList;
import java.util.Random;

import core.math.Vec2;
import graphics.Camera;
import graphics.Screen;
import input.Mouse;

public class Map {

	
	public final int WIDTH,HEIGHT;
	public Vec2 GRAVITY;
	public Tile[][] tiles;
	public static Random r = new Random();
	
	private Mob test;
	public ArrayList<Mob> mobs;
	
	public Map(int w,int h) {
		WIDTH = w;
		HEIGHT = h;
		tiles = new Tile[w][h];
		GRAVITY = new Vec2(0.0f, 0.3f);
		clear(0);
		
		//Generuje flat
		for(int y=8;y < HEIGHT;y++) {
			for(int x = 0;x < WIDTH;x++) {
				tiles[x][y] = Tile.getTile(1); // Wstawia stone
			}
		}
		
		for(int y=8;y < 10;y++) {
			for(int x = 1;x < WIDTH - 1;x++) {
				tiles[x][y] = Tile.getTile(0); // Wstawia stone
			}
		}
		
		//Dodaje mobki
		mobs = new ArrayList<Mob>();
		for(int i = 0;i < 50;i++) {
			float x = 200 * r.nextFloat();
			mobs.add(new Mob(new Vec2(50.0f + x, 0.0f)));
		
		}
		
		test = new Mob(new Vec2(50.0f , 0.0f));

	}
	
	public boolean BoxColision(int px,int py,int w,int h) {
		int tileX = px / 16;
		int tileY = py / 16;
		
		
			
		//Kafelka
		boolean result = false;
		if(BoxCollisionAt(tileX,tileY,px,py,w,h)) result = true;
		if(BoxCollisionAt(tileX ,tileY + 1,px,py,w,h)) result = true;
		if(BoxCollisionAt(tileX + 1,tileY,px,py,w,h)) result = true;
		if(BoxCollisionAt(tileX + 1,tileY + 1,px,py,w,h)) result = true;
		
		return result;
	}
	
	public boolean BoxCollisionAt(int tx,int ty,int px,int py,int w,int h) {
		
		int pixelX = tx * 16;
		int pixelY = ty * 16;
		if(tx < 0 || tx >= WIDTH || ty < 0 || ty >= HEIGHT)
			return false;
		if(px + w > pixelX &&
			px < pixelX + 16 && 
			py + h > pixelY &&
			py < pixelY + 16)
			return tiles[tx][ty].colider;
		
		return false;
	}
	
	
	public void clear(int id) {
		//Random r = new Random();
		for(int y=0;y < HEIGHT;y++) {
			for(int x = 0;x < WIDTH;x++) {
				tiles[x][y] = Tile.getTile(id);//(int)(r.nextFloat() * 3));
			}
		}
	}
	
	public void update(Camera c) {
		int X = (Mouse.Xpixel + c.x) / 16;
		int Y = (Mouse.Ypixel + c.y) / 16;
		
		if(!(X < 0 || X >= WIDTH || Y < 0 || Y >= HEIGHT)) {
		if(Mouse.button_left)
			tiles[X][Y] = Tile.getTile(2);
		if(Mouse.button_right)
			tiles[X][Y] = Tile.getTile(38495643);
		}
		test.update(this);
		for(int i = 0;i < mobs.size();i++) {
			mobs.get(i).update(this);
		}
		
	}
	
	public void render(Screen s,Camera c) {
		for(int y=0;y < HEIGHT;y++) {
			for(int x = 0;x < WIDTH;x++) {
				tiles[x][y].render(s, x, y,c);
			}
		}
		
		
		test.render(s, c);
		for(int i = 0;i < mobs.size();i++) {
			mobs.get(i).render(s, c);
		}
	}
}
