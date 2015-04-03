package com.game.menu.buttons;

import com.game.main.*;
import com.game.menu.*;

public class BackButton extends MenuButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BackButton(int x, int y)
	{
		setText("BACK");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void doAction()
	{
		Display.setState(Display.getPauseState());
		//Display.getState().setPane(SETTINGS_PANE);
		//DISPLAYS MAP
		//Display.setState(Display.getMapState());
	}
}
