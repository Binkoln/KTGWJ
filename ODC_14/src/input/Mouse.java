package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import core.Main;

public class Mouse implements MouseListener,MouseMotionListener{

	public static int X,Y,Xpixel,Ypixel;
	public static boolean button_left,button_right,button_clicked_left,button_clicked_right;
	private static boolean b1 = false,b2 = false;
	
	public static void update() {
		//Klikanie lewym
		if(!b1 && button_left) {
			b1 = true;
			button_clicked_left = true;
		}
		else{
			button_clicked_left = false;
		}
		if(!button_left) {
			b1 = false;
		}
		
		//Klikanie prawym
		if(!b2 && button_right) {
			b2 = true;
			button_clicked_right = true;
		}
		else{
			button_clicked_right = false;
		}
		if(!button_right) {
			b2 = false;
		}
	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
		Xpixel = (int)((float)X*((16.0f*17.0f) / ((float)Main.WIDTH + 10.0f)));
		Ypixel = (int)((float)Y*((9.0f*17.0f) / ((float)Main.HEIGHT + 10.0f)));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
		if(e.getButton() == e.BUTTON1) {//Lewy
			button_left = true;
		}
		
		if(e.getButton() == e.BUTTON3) {//Prawy
			button_right = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseMoved(e);
		
		if(e.getButton() == e.BUTTON1) {//Lewy
			button_left = false;
		}
		
		if(e.getButton() == e.BUTTON3) {//Prawy
			button_right = false;
		}
	}

}
