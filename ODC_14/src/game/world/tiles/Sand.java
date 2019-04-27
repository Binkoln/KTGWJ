package game.world.tiles;

import game.world.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;

public class Sand extends Tile{

	public static final Sprite texture = new Sprite(2 * 16, 0,16,Spritesheet.def1);
	
	public Sand() {
		id = 2;
		colider = true;
		ladder = false;
	}
	
	public void render(Screen s,int x,int y,Camera c) {
		s.renderSprite(x * 16, y * 16, texture,c);
	}
}
