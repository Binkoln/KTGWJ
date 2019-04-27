package core.gamestates;

import java.awt.event.KeyEvent;

import core.GameState;
import core.GameStateManager;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;

public class GS_Menu extends GameState{

	public static final Sprite s_bg = new Sprite(0, 0, Spritesheet.bg_menu.WIDTH,Spritesheet.bg_menu.HEIGHT, Spritesheet.bg_menu);
	public static final Sprite s_pointer = new Sprite(16, 0, 16, Spritesheet.def1);
	public static final Sprite s_logo = new 	Sprite(0, 16, 64,32, Spritesheet.def1);
	public static final Sprite s_newGame = new 	Sprite(0, 48, 96,16, Spritesheet.def1);
	public static final Sprite s_continue = new Sprite(0, 64, 96,16, Spritesheet.def1);
	public static final Sprite s_credits = new 	Sprite(0, 80, 80,16, Spritesheet.def1);
	public static final Sprite s_exit = new 	Sprite(0, 96, 48,16, Spritesheet.def1);
	
	private int choose = 0;
	private float pointerPosition = 0;
	
	public GS_Menu(){
		
	}
	
	public void update(){
		if(Keyboard.getKey(KeyEvent.VK_ENTER)){
			if(choose == 0)GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME); //New Game
			if(choose == 3)GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_EXIT); //Exit
		}
		
		if(Keyboard.getKeyOnce(KeyEvent.VK_DOWN))choose++;
		if(Keyboard.getKeyOnce(KeyEvent.VK_UP))choose--;
		
		if(choose > 3)choose = 0;
		if(choose < 0) choose = 3;
		
		if(choose == 0)setPointer(40); //New Game
		if(choose == 1)setPointer(60); //Continue
		if(choose == 2)setPointer(80); //Credits
		if(choose == 3)setPointer(96); //Exit
		
	}
	
	private void setPointer(int i){
		pointerPosition += (i - pointerPosition) / 4;
	}
	
	public void render(Screen s){
		s.clear(0x000000);
		s.renderSprite(0, 0, s_bg);
		
		s.renderSprite(150, 5, s_logo);
		
		s.renderSprite(14, 40, s_newGame);
		s.renderSprite(14, 60, s_continue);
		s.renderSprite(12, 80, s_credits);
		s.renderSprite(12, 96, s_exit);
		s.renderSprite(0, (int)pointerPosition, s_pointer);
	}

}
