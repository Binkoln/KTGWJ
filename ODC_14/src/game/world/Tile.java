package game.world;

import game.world.tiles.Air;
import game.world.tiles.Sand;
import game.world.tiles.Stone;
import graphics.Camera;
import graphics.Screen;

public class Tile {
	public int id;
	public boolean colider,ladder;
	
	public static Tile getTile(int id) {
		if(id == 1)return new Stone();
		if(id == 2)return new Sand();
		return new Air();
	}
	
	public void udate() {}
	
	public void render(Screen s,int x,int y,Camera c) {}
	
}
