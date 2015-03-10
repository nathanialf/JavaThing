package com.game.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;

import com.game.entity.Player;
import com.game.main.Display;
import com.game.world.World;

public class PlayState extends State
{
	//Player
	private static Player player = new Player();
	
	//GAME WORLD
	private static World world = new World(new File("res/maps/error.map"));
	
	public PlayState()
	{
		setName("PLAY");
		background.setRect(0, 0, Display.WIDTH, Display.HEIGHT); 
	}
	
	public void update(double delta)
	{
		if(is_open_animating)
		{
			
			if(background.getY() < 0)
			{
				background.setRect(background.getX(), background.getY() + (background.getHeight() / 15), background.getWidth(), background.getHeight());
				getWorld().buildBody();
				getPlayer().buildBody();
			}
			else
			{
				background.setRect(0, 0, background.getWidth(), background.getHeight());
				is_open_animating = false;
			}
		}
		
		Display.getMouse().update();
		
		getWorld().update(delta);
		getPlayer().update(delta);
	}
	
	public void render(Graphics2D g)
	{
		//is a rectangle with boundaries I use for collisions. Google Rectangle2D 
		g.setColor(new Color(227,242,253));
		g.fill(background);
		
		//Draws world
		getWorld().render(g);
		
		//Draws Player
		getPlayer().render(g);
	}
	
	public void openAnim()
	{
		is_open_animating = true;
	}
	
	public static Player getPlayer()			{return player;}
	public static World getWorld()				{return world;}
	
	public static void setPlayer(Player p)		{player = p;}
	public static void setWorld(World w)		{world = w;}
	public void setBackground(Rectangle2D.Double r)	
	{
		background = r;
		getWorld().buildBody();
		getPlayer().buildBody();
	}
}