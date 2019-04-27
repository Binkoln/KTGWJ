package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static final Spritesheet def1 = new Spritesheet("/Spritescheet.png");
	public static final Spritesheet bg_menu = new Spritesheet("/bg_menu.png");
	
	public 	int WIDTH,HEIGHT;
	public  int[] pixels;
	
	public Spritesheet(String path){
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			WIDTH = image.getWidth();
			HEIGHT = image.getHeight();
			pixels = new int[WIDTH * HEIGHT];
			
			image.getRGB(0,0,WIDTH,HEIGHT,pixels,0,WIDTH);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
