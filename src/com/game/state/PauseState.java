package com.game.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.game.main.Display;
import com.game.menu.*;

public class PauseState extends State
{
    int base_y = Display.HEIGHT / 6;
    MenuComponent components [] = {new ResumeButton(0, base_y), 
    		new MapButton(0, base_y + (Display.HEIGHT / 16) + 16), 
    		new SettingsButton(0, base_y + (((Display.HEIGHT / 16) + 16) * 2)),
    		new ExitButton(0, base_y + (((Display.HEIGHT / 16) + 16) * 3))};
    
	public PauseState()
	{
		setName("PAUSE");
		background.setRect(0, -Display.HEIGHT, Display.WIDTH, Display.HEIGHT); 
		BASE_HEIGHT = Display.HEIGHT;
	}
	public void update(double delta)
	{
		Display.getMouse().update();
		
		if(is_open_animating)
		{	
			if(background.getY() < 0)
			{
				background.setRect(background.getX(), background.getY() + (background.getHeight() / 30), background.getWidth(), background.getHeight());
				
				for(int a = 0; a < components.length; a++)
					components[a].buildBody();
			}
			else
			{
				background.setRect(0, 0, background.getWidth(), background.getHeight());
				is_open_animating = false;
			}
		}
		
		for(int a = 0; a < components.length; a++)
		{
			components[a].update(delta);
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(239,239,239));
		g.fill(background);
		
		for(int a = 0; a < components.length; a++)
			components[a].render(g);
	}
	
	public void setBackground(Rectangle2D.Double r)	
	{
		background = r;
		
		for(int a = 0; a < components.length; a++)
			components[a].buildBody();
	}

	public void openAnim()
	{
		is_open_animating = true;
		
		for(int a = 0; a < components.length; a++)
		{
			components[a].buildBody();
		}
	}
}