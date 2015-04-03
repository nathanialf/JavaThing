package com.game.menu.buttons;

import com.game.main.*;
import com.game.menu.MenuButton;

public class ExitButton extends MenuButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
