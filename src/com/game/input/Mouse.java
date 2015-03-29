package com.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{
	private int leftClicked, rightClicked, wheelClicked;
	
	private boolean isLeftClicked, isRightClicked, isWheelClicked;
	
	private int x, y;
	
	public void update()
	{
		leftClicked = MouseEvent.BUTTON1;
		rightClicked = MouseEvent.BUTTON3;
		wheelClicked = MouseEvent.BUTTON2;
	}
	
	public void mouseClicked(MouseEvent e) 
	{
	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
		
		isLeftClicked = (e.getButton() == leftClicked);
		isRightClicked = (e.getButton() == rightClicked);
		isWheelClicked = (e.getButton() == wheelClicked);
	}

	public void mouseReleased(MouseEvent e) 
	{
		x = 0;
		y = 0;
		
		isLeftClicked = false;
		isRightClicked = false;
		isWheelClicked = false;
	}

	public int getX()					{return this.x;}
	public int getY()					{return this.y;}
	public boolean getLeftClicked()		{return this.isLeftClicked;}
	public boolean getRightClicked()	{return this.isRightClicked;}
	public boolean getWheelClicked()	{return this.isWheelClicked;}

}
