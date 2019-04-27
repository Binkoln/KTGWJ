package core;

import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;
import input.Mouse;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{

	public static final String TITLE = "Gra";
	public static final int WIDTH = 1024,HEIGHT = 576;
	private static final int FRAMERATE = 60;
	
	private boolean RUNNING = false;
	private JFrame frame;

	private Screen screen;
	private Keyboard keyboard = new Keyboard();
	private Mouse mouse = new Mouse();
	private GameStateManager gsm ;
	
	
	public Main(){
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setMinimumSize(new Dimension(WIDTH,HEIGHT));
		setMaximumSize(new Dimension(WIDTH,HEIGHT));
		
		frame = new JFrame();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		frame.add(this,new BorderLayout().CENTER);
		
		frame.pack();
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		int i = 17;
		screen = new Screen(16 * i,9 * i);
		
		
		gsm = new GameStateManager();
	}
	
	private void start(){
		if(RUNNING)return;
		RUNNING = true;
		
		new Thread(this,"Game " + TITLE).start();
		
		
	}
	
	
	
	private void stop(){
		if(!RUNNING)return;
		RUNNING = false;
		frame.dispose();
		System.exit(0);
	}
	
	private double timerek = System.currentTimeMillis(); 
	private int UPS = 0;
	private int FPS = 0;
	private double  delta = 0;
	private double frametime = 1000000000 / FRAMERATE;
	private long timeNOW = System.nanoTime();
	private long timeLAST = System.nanoTime();
	
	public void run(){
		
		while(RUNNING && !gsm.exit){
			timeNOW = System.nanoTime();
			delta += (timeNOW - timeLAST) / frametime;
			timeLAST = timeNOW;
			while(delta >= 1){
				update();
				delta -= 1;
				UPS++;
			}
			
			render();
			FPS++;
			
			if(System.currentTimeMillis() - timerek >= 1000){
				timerek = System.currentTimeMillis();
				//System.out.println("FPS: " + FPS +"--- UPS: " + UPS);
				frame.setTitle(TITLE + " -- FPS: " + FPS +"--- UPS: " + UPS);
				FPS = 0;
				UPS = 0;
			}
		}
		stop();
		
	}
	
	
	private void update(){
		keyboard.update();

		mouse.update();
		gsm.update();
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH + 10, HEIGHT + 10);
		
		screen.clear(0x000000);
		gsm.render(screen);
		
		g.drawImage(screen.getImage(),0,0,WIDTH + 10,HEIGHT + 10,null);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Main().start();

	}

}
