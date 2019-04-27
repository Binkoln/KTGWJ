package game.world;

import java.awt.event.KeyEvent;

import core.gamestates.GS_Game;
import core.math.Vec2;
import graphics.Camera;
import graphics.Screen;
import input.Keyboard;
import input.Mouse;

public class Mob {

	public Vec2 pos;
	public Vec2 vel;
	
	public float HP;
	public boolean isFlying;
	public boolean onGround;
	
	
	public Mob(Vec2 pos) {
		this.pos = pos;
		vel = new Vec2(1.0f + (2.5f * Map.r.nextFloat()), -3.0f* Map.r.nextFloat());
		HP = 10.0f;
		isFlying = false;
		onGround = false;

	}
	
	public void update(Map m) {
		//if(pos.y > 300) pos.y = -20;
		vel.y += m.GRAVITY.y;
		
		if(vel.y > 12.0f)vel.y = 12.0f;
		else if(vel.y < -12.0f)vel.y = -12.0f;
		
		if(vel.x > 12.0f)vel.x = 12.0f;
		else if(vel.x < -12.0f)vel.x = -12.0f;
		
		//if(pos.y + vel.y > 112) vel.y *= -0.45f;
		if(Keyboard.getKeyOnce(KeyEvent.VK_SPACE))vel.y = -7.0f;
		
		
		
		move(m);
		
	}
	
	public void move(Map m) {
		
		//X
		if(m.BoxColision((int)(pos.x + vel.x), (int)pos.y,16,16)){
			vel.x *= -1;
			if(onGround) {
				onGround = false;
				vel.y = -8.0f;
			}
		}else {
			pos.x += vel.x;
		}
		
		//Y
		if(m.BoxColision((int)pos.x,(int)( pos.y + vel.y), 16, 16)) {
			vel.y = -0.2f;
			//if(vel > )
			onGround = true;
		}
		else {
			onGround = false;
			pos.y += vel.y;
		}
	}
	
	public void render(Screen s,Camera c) {
		s.renderSprite((int)pos.x,(int)pos.y, GS_Game.ss,c);
	}
}
