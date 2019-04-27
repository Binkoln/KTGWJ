package core.gamestates;

import java.awt.event.KeyEvent;

import core.GameState;
import core.Main;
import core.math.Vec2;
import game.world.Map;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;
import input.Mouse;

public class GS_TestState extends GameState{

	float x = 40,y = 40;
		
	
	public static final Sprite ss = new Sprite(0, 0, 16, Spritesheet.def1);;
	public Map mapa;
	public Camera camera;
	
	//Prostokat
	Vec2 pos1;
	Vec2 size1;
	int color;
	
	//box przy myszy
	Vec2 size2;
	
	public GS_TestState(){
		//ss = new Sprite(0, 0, 16, Spritesheet.def1);
		mapa = new Map(20, 20);
		camera = new Camera(0, 0);
		
		pos1 = new Vec2(50, 40);
		size1 = new Vec2(70, 40);
		size2 = new Vec2(16, 16);
	}
	
	public boolean colide() {
		 if(Mouse.Xpixel + size2.x > pos1.x &&
		    Mouse.Xpixel           < pos1.x + size1.x  &&
		    
			Mouse.Ypixel + size2.y > pos1.y &&
			Mouse.Ypixel < pos1.y + size1.y
				 ) return true;
		return false;
	}
	
	public void update(){
		mapa.update(camera);
		
		
		float speed = 1f;
		if(Keyboard.getKey(KeyEvent.VK_W)){
			camera.y-= speed;
		}
		else if(Keyboard.getKey(KeyEvent.VK_S)){
			camera.y+= speed;
		}
		
		if(Keyboard.getKey(KeyEvent.VK_A)){
			camera.x-= speed;
		}
		else if(Keyboard.getKey(KeyEvent.VK_D)){
			camera.x+= speed;
		}
		
		if(!colide())color = 0x32ff22; else color = 0xff2222;
	}
	
	public void render(Screen s){
		s.clear(0x7CCEE2);
		
		s.frect((int)pos1.x, (int)pos1.y, (int)size1.x, (int)size1.y, color);
		
		s.frect((int)Mouse.Xpixel, (int)Mouse.Ypixel, (int)size2.x, (int)size2.y, 0xfc9832);
		
		//mapa.render(s,camera);
		//s.renderSprite((int)Mouse.Xpixel - 8, (int)Mouse.Ypixel - 8, this.ss,null);
	}

}
