package com.game.state;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class State 
{
	private static String name;

	Rectangle2D.Double background = new Rectangle2D.Double();

	public boolean is_open_animating = false;
	
	public int BASE_HEIGHT;
    
   // static MenuPane current_pane = new MenuPane();
	
	public State()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		
	}
	
	public void update(double delta)
	{
		//System.out.println(getName());
	}

	public void openAnim()
	{
		is_open_animating = true;
	}
	
	@SuppressWarnings("static-access")
	public String getName()							{return this.name;}
	public Rectangle2D.Double getBackground()		{return this.background;}
	//public MenuPane getPane()						{return current_pane;}
	
	@SuppressWarnings("static-access")
	public void setName(String n)					{this.name = n;}
	public void setBackground(Rectangle2D.Double r)	{background = r;}
	
	/*
	public void setPane(MenuPane p)		
	{
		MenuPane old = current_pane;
		
		current_pane = p;
		current_pane.openAnim();
		
		Rectangle2D.Double newBody = new Rectangle2D.Double(0, -Display.HEIGHT, Display.WIDTH, Display.HEIGHT);
		
		old.setBody(newBody);
	}
	*/
}
