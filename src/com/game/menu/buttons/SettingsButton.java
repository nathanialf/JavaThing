package com.game.menu.buttons;

import com.game.main.*;
import com.game.menu.*;

public class SettingsButton extends MenuButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SettingsButton(int x, int y)
	{
		setText("SETTINGS");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void doAction()
	{
		Display.setState(Display.getSettingsState());
		//Display.getState().setPane(SETTINGS_PANE);
		//DISPLAYS MAP
		//Display.setState(Display.getMapState());
	}
}
