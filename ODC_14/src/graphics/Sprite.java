package graphics;

public class Sprite {
	public int x,y,width,height;
	public Spritesheet sp;
	
	public Sprite(int x,int y,int width,int height,Spritesheet sp){
		this.x  = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sp = sp;
	}
	
	public Sprite(int x,int y,int size,Spritesheet sp){
		this.x  = x;
		this.y = y;
		this.width = size;
		this.height = size;
		this.sp = sp;
	}
}
