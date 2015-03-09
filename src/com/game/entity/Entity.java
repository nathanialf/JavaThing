package com.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Entity 
{
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private double angle;
	
	protected Rectangle2D body;
	
	public Entity ()
	{
	}
	
	public void update(double delta)
	{
	}
	
	public void render(Graphics2D g)
	{
		g.rotate(getAngle(), getX() + (getWidth() / 2), getY() + (getHeight() / 2));
		
		g.setColor(new Color(85,35,200));
		g.fill(body);
		
		g.rotate(-getAngle(), getX() + (getWidth() / 2), getY() + (getHeight() / 2));
	}
	
	public void buildBody()
	{
		body = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
	}

	public int getX()				{return this.x;}
	public int getY()				{return this.y;}
	public int getWidth()			{return this.WIDTH;}
	public int getHeight()			{return this.HEIGHT;}
	public double getAngle()			{return this.angle;}

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
	protected void setAngle(double a)	{this.angle = a;}
	
}
