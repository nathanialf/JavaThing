package com.game.menu;

import com.game.main.*;

public class ExitButton extends MenuComponent
{
	public ExitButton(int x, int y)
	{
		setText("EXIT");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void update(double delta)
	{
		if(Display.getMouse().getLeftClicked() && body.contains(Display.getMouse().getX(), Display.getMouse().getY()))
		{
			System.exit(0);
		}
	}
}
