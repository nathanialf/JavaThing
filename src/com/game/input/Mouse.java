package com.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{

	@SuppressWarnings("unused")
	private int leftClicked, rightClicked, wheelClicked;
	
	public void update()
	{
		leftClicked = MouseEvent.BUTTON1;
		rightClicked = MouseEvent.BUTTON3;
		wheelClicked = MouseEvent.BUTTON2;
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		/*
		if(e.getButton() == leftClicked)
			System.out.println("LEFT: " + e.getX() + ", " + e.getY());
		if(e.getButton() == rightClicked)
			System.out.println("RIGHT: " + e.getX() + ", " + e.getY());
		if(e.getButton() == wheelClicked)
			System.out.println("WHEEL: " + e.getX() + ", " + e.getY());
		 */
	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
	}

	public void mouseReleased(MouseEvent e) 
	{
		
	}

}
