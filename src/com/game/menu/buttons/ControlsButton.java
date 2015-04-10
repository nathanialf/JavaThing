package com.game.menu.buttons;

import com.game.main.Display;
import com.game.menu.*;

public class ControlsButton extends MenuButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlsButton(int x, int y)
	{
		setText("CONTROLS");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void doAction()
	{
		//Display.getState().setSubState(new State());
	}
}
