package com.game.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.game.entity.Player;
import com.game.main.Display;
import com.game.world.World;

public class PlayState extends State
{
	//Player
	private static Player player = new Player();
	
	//GAME WORLD
	private static World world = new World(null);
	
	public PlayState()
	{
		setName("PLAY");
	}
	
	public void update(double delta)
	{
		Display.getMouse().update();
		
		getWorld().update(delta);
		getPlayer().update(delta);
	}
	
	public void render(Graphics2D g)
	{
		//is a rectangle with boundaries I use for collisions. Google Rectangle2D 
		
		Rectangle2D.Double background = new Rectangle2D.Double();
		background.setRect(0, 0, Display.WIDTH, Display.HEIGHT); 
		g.setColor(new Color(227,242,253));
		g.fill(background);
		
		//Draws world
		getWorld().render(g);
		
		//Draws Player
		getPlayer().render(g);
	}
	
	public static Player getPlayer()			{return player;}
	public static World getWorld()				{return world;}
	
	public static void setPlayer(Player p)		{player = p;}
	public static void setWorld(World w)		{world = w;}
}