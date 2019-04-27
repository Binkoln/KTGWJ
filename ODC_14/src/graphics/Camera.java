package graphics;

import core.Main;
import core.math.Vec2;

public class Camera {
	public static final Camera zero = new Camera(0, 0);
	
	public int x,y;
	public static final int WIDTH = Main.WIDTH / 2,HEIGHT = Main.WIDTH / 2;
	
	public Camera(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2 getPosition() {
		return new Vec2(x, y);
	}
}
