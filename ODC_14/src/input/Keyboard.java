package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private static final int Count = 200;
	private static boolean keys[] = new boolean[Count];
	private static boolean keys_prev[] = new boolean[Count];
	
	public Keyboard(){
		for(int i = 0; i < Count;i++)
			keys[i] = false;
		for(int i = 0; i < Count;i++)
			keys_prev[i] = false;
	}
	
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}

	
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}

	public void update(){
		for(int i = 0; i < Count;i++){
			if(!keys[i])
				keys_prev[i] = false;
		}
	}
	
	public static boolean getKey(int Key){
		return keys[Key];
	}
	
	public static boolean getKeyOnce(int Key){
		if(!keys_prev[Key] && keys[Key]){
			keys_prev[Key] = true;
			return true;
		}
		
		return false;
	}
	
	public void keyTyped(KeyEvent arg0) {}
		

}
