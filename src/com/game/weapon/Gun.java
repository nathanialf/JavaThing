package com.game.weapon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

import com.game.main.Display;

public class Gun
{
	private int x;
	private int y;
	private int barrel;
	private int mouse_x;
	private int mouse_y;
	private double angle;
	
	private Line2D body;
	
	public Gun ()
	{
		setAngle(0);
		setMouseX(0);
		setMouseY(0);
		buildBody();
	}
	
	public void update(double delta)
	{
		setMouseX(Display.getMouseMotion().getX());
		setMouseY(Display.getMouseMotion().getY());
		setAngle(-Math.atan2((getY() - getMouseY()), (getX() - getMouseX())) - Math.toRadians(90));
		buildBody();
		
		//if(Display.getMouse())
		
		//System.out.println(getAngle());
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.red);
		g.draw(body);
		//g.drawLine((int)body.getX1(), (int)body.getY1(), (int)body.getX2(), (int)body.getY2());
	}
	
	public void buildBody()
	{
		body = new Line2D.Double(getX(), getY(), getX() + barrel * Math.sin(getAngle()), getY() + barrel * Math.cos(getAngle()));
	}

	public int getX()				{return this.x;}
	public int getY()				{return this.y;}
	public int getMouseX()			{return this.mouse_x;}
	public int getMouseY()			{return this.mouse_y;}
	public int getBarrel()			{return this.barrel;}
	public double getAngle()		{return this.angle;}

	public void setX(int x)			{this.x = x;}
	public void setY(int y)			{this.y = y;}
	public void setMouseX(int x)	{this.mouse_x = x;}
	public void setMouseY(int y)	{this.mouse_y = y;}
	public void setBarrel(int b)	{this.barrel = b;}
	public void setAngle(double a)	{this.angle = a;}
	
}

