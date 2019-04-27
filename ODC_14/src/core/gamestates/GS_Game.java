package core.gamestates;

import java.awt.event.KeyEvent;

import core.GameState;
import core.Main;
import game.world.Map;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;
import input.Mouse;

public class GS_Game extends GameState{

	float x = 40,y = 40;
		
	
	public static final Sprite ss = new Sprite(0, 0, 16, Spritesheet.def1);;
	public Map mapa;
	public Camera camera;
	private int color;
	
	public GS_Game(){
		//ss = new Sprite(0, 0, 16, Spritesheet.def1);
		mapa = new Map(20, 20);
		camera = new Camera(0, 0);
	}
	
	public void update(){
		mapa.update(camera);
		
		//Ustawia kamêrê na pierwszym mobku 
		//camera.x = (int)(mapa.mobs.get(0).pos.x - 130);
		//camera.y = (int)(mapa.mobs.get(0).pos.y - 80);
		
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
		
		if(!mapa.BoxColision((int)Mouse.Xpixel + camera.x, (int)Mouse.Ypixel + camera.y, 6, 12))
			color = 0x32ff22; //
		else 
			color = 0xff2222; //cz
		
		
	}
	
	public void render(Screen s){
		s.clear(0x7CCEE2);
		
		mapa.render(s,camera);
		//s.renderSprite((int)Mouse.Xpixel - 8, (int)Mouse.Ypixel - 8, this.ss,null);
		s.frect((int)Mouse.Xpixel, (int)Mouse.Ypixel, 6, 12, color);
	}

}
