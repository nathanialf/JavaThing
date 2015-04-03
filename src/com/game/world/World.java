package com.game.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JComponent;

import com.game.main.Display;

public class World extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private int WIDTH, HEIGHT;
	private int x, y;
	
	private File mapFile;
	
	String image_location;
	
	protected Rectangle2D body;
	
	private int movement [][];
	
	//Will invert controls for if the world moves with the player in the center of the screen
	//and will allow free movement when the world stays static
	private int movement_modifier_x = 1;
	private int movement_modifier_y = 1;
	
	@SuppressWarnings("static-access")
	public World(File f)
	{
		setFile(f);
		
		if(getFile() == null)
		{
			System.out.println("NO FILE SPECIFIED\nFile set to: error.map");
			setFile(new File("res/maps/error.map"));
		}
		
		try 
		{
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(getFile());
			
			while(reader.hasNextLine())
			{
				String values[] = reader.nextLine().split("-");
				
				switch(values[0])
				{
				case "Width":
					setWidth((int)(Display.WIDTH / Integer.parseInt(values[1])));
					break;
				case "Height":
					setHeight((int)(Display.WIDTH / Integer.parseInt(values[1])));
					break;
				case "Image":
					image_location = "res/maps/images/" + values[1];
					break;
				default:
					break;
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		setX((Display.WIDTH / 2) - getWidth() / 2);
		setY((Display.HEIGHT / 2) - getHeight() / 2);
		
		this.movement = Display.getPlayState().getPlayer().movement;
		
		buildBody();
	}

	public void move(int a)
	{
		this.setX((int) (getX() + (movement[0][a] * movement_modifier_x)));
		this.setY((int) (getY() + (movement[1][a] * movement_modifier_y)));
		this.buildBody();
		//gun.setX(getX() + (getWidth() / 2));
		//gun.setY(getY() + (getHeight() / 2));
		//gun.buildBody();
	}
	
	public void update(double delta)
	{
		for(int a = 0; a < 4; a++)
		{
			if(Display.getKeyboard().getPlayerMovement()[a])
			{
				move(a);
			}
		}
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(182, 182, 182));
		g.fill(body);
		
		Image img1 = Toolkit.getDefaultToolkit().getImage(image_location);
	    g.drawImage(img1, getX(), (int)body.getY(), getWidth(), getHeight(), this);
	    g.finalize();
	}
	
	public void buildBody()
	{
		body = new Rectangle2D.Double(Display.getState().getBackground().getX() + getX(), Display.getState().getBackground().getY() + getY(), getWidth(), getHeight());
	}

	public int getWidth()					{return this.WIDTH;}
	public int getHeight()					{return this.HEIGHT;}
	public int getX()						{return this.x;}
	public int getY()						{return this.y;}
	public File getFile()					{return this.mapFile;}

	public void setWidth(int w)				{this.WIDTH = w;}
	public void setHeight(int h)			{this.HEIGHT = h;}
	public void setX(int x)					{this.x = x;}
	public void setY(int y)					{this.y = y;}
	public void setFile(File f)				{this.mapFile = f;}
}
