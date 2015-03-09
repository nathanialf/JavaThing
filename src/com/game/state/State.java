package com.game.state;

import java.awt.Graphics2D;

public class State 
{
	private static String name;
	
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
	
	@SuppressWarnings("static-access")
	public String getName()						{return this.name;}
	
	@SuppressWarnings("static-access")
	public void setName(String n)				{this.name = n;}
}
