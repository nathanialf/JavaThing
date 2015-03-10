package com.game.state;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class State 
{
	private static String name;

	Rectangle2D.Double background = new Rectangle2D.Double();

	public boolean is_open_animating = false;
	
	public State()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		
	}
	
	public void update(double delta)
	{
		System.out.println(getName());
	}

	public void openAnim()
	{
		is_open_animating = true;
	}
	
	@SuppressWarnings("static-access")
	public String getName()							{return this.name;}
	public Rectangle2D.Double getBackground()		{return this.background;}
	
	@SuppressWarnings("static-access")
	public void setName(String n)					{this.name = n;}
	public void setBackground(Rectangle2D.Double r)	{background = r;}
}
