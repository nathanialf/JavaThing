package com.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener
{
	private int x;
	private int y;
	
	public void mouseDragged(MouseEvent e) 
	{
		setX(e.getX());
		setY(e.getY());
	}

	public void mouseMoved(MouseEvent e) 
	{
		setX(e.getX());
		setY(e.getY());
	}

	public void setX(int x)			{this.x = x;};
	public void setY(int y)			{this.y = y;};
	
	public int getX()				{return this.x;}
	public int getY()				{return this.y;}
}