package game.world.tiles;

import game.world.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;

public class Stone extends Tile{

	public static final Sprite texture = new Sprite(3 * 16, 0,16,Spritesheet.def1);
	
	public Stone() {
		id = 1;
		colider = true;
		ladder = false;
	}
	
	
	public void render(Screen s,int x,int y,Camera c) {
		s.renderSprite(x * 16, y * 16, texture,c);
	}
	
}
