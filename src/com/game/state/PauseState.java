package com.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.game.main.Display;

public class PauseState extends State
{
    Font font = new Font(Font.DIALOG, Font.BOLD, 20);
    
	public PauseState()
	{
		setName("PAUSE");
	}
	public void update(double delta)
	{
		Display.getMouse().update();
	}
	
	public void render(Graphics2D g)
	{	
		//is a rectangle with boundaries I use for collisions. Google Rectangle2D 
		
		Rectangle2D.Double background = new Rectangle2D.Double();
		background.setRect(0, 0, Display.WIDTH, Display.HEIGHT); 
		g.setColor(new Color(33,150,243));
		g.fill(background);

		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("GAME IS PAUSED", 40, Display.HEIGHT / 4);
	}
}