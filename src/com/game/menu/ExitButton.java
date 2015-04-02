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
	
	public void doAction()
	{
		System.exit(0);
	}
}