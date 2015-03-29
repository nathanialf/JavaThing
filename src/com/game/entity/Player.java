package com.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.game.main.Display;
//import com.game.weapon.Gun;

public class Player extends Entity
{
	//REMOVED GUN
	//Want the gameplay to be different
	//Gun gun = new Gun();
	
	public int movement [][];
	
	//Will invert controls for if the world moves with the player in the center of the screen
	//and will allow free movement when the world stays static
	private int movement_modifier_x = 1;
	private int movement_modifier_y = 1;
	
	public Player()
	{
		setWidth(Display.WIDTH / 40);
		setHeight(getWidth());
		setX((Display.WIDTH / 2) - (getWidth() / 2));
		setY((Display.HEIGHT / 2) - (getWidth() / 2));
		setAngle(0.0);
		
		//gun.setX(getX() + (getWidth() / 2));
		//gun.setY(getY() + (getHeight() / 2));
		//gun.setBarrel(getWidth());
		
		int movement [][] = 
		{
			{0,					0,					(getWidth() / 8), 	-(getWidth() / 8)},
			{(getWidth() / 8),	-(getWidth() / 8),	0,					0}
		};
		
		this.movement = movement;
		
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
		//gun.update(delta);
	}

	
	public void render(Graphics2D g)
	{	
		//g.rotate(getAngle(), getX() + (getWidth() / 2), getY() + (getHeight() / 2));
		
		g.setColor(new Color( 96, 125, 139));
		g.fill(body);
		
		//g.rotate(-getAngle(), getX() + (getWidth() / 2), getY() + (getHeight() / 2));
		
		//gun.render(g);
	}
}
