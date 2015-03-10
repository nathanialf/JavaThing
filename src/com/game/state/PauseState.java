package com.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.game.main.Display;

public class PauseState extends State
{
    Font font = new Font(Font.DIALOG, Font.BOLD, 20);
    
	public PauseState()
	{
		setName("PAUSE");
		background.setRect(0, -Display.HEIGHT, Display.WIDTH, Display.HEIGHT); 
	}
	public void update(double delta)
	{
		Display.getMouse().update();
		
		if(is_open_animating)
		{
			if(background.getY() < 0)
			{
				background.setRect(background.getX(), background.getY() + (background.getHeight() / 15), background.getWidth(), background.getHeight());
			}
			else
			{
				background.setRect(0, 0, background.getWidth(), background.getHeight());
				is_open_animating = false;
			}
		}
	}
	
	public void render(Graphics2D g)
	{	
		//is a rectangle with boundaries I use for collisions. Google Rectangle2D 
		g.setColor(new Color(0,150,136));
		g.fill(background);

		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("GAME IS PAUSED", 40, (int) (background.getY() + (background.getHeight() / 4)));
	}
}