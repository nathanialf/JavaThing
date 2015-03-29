package com.game.menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.game.main.Display;

public class MenuComponent 
{
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	
	private String text;
	
	protected Rectangle2D body;
	
	public MenuComponent()
	{
		
	}
	
	public void update(double delta)
	{
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(100,175,100));
		g.fill(body);
		
		g.setColor(Color.white);
		g.drawString(getText(), 40, (int) (body.getY() + (body.getHeight() / 2) + (Display.MAIN_FONT.getSize()/2)));
	}
	
	public void buildBody()
	{
		body = new Rectangle2D.Double(Display.getState().getBackground().getX() + getX(), Display.getState().getBackground().getY() + getY(), getWidth(), getHeight());
	}

	public int getX()				{return this.x;}
	public int getY()				{return this.y;}
	public int getWidth()			{return this.WIDTH;}
	public int getHeight()			{return this.HEIGHT;}
	public String getText()			{return this.text;}

	protected void setX(int x)		
	{
		this.x = x;
		buildBody();
	}
	protected void setY(int y)		
	{
		this.y = y;
		buildBody();
	}
	protected void setWidth(int w)	
	{
		this.WIDTH = w;
		buildBody();
	}
	protected void setHeight(int h)	
	{
		this.HEIGHT = h;
		buildBody();
	}
	public void setText(String s)			{text = s;}
}
