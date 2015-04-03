package com.game.menu.buttons;

import com.game.main.*;
import com.game.menu.MenuButton;

public class MapButton extends MenuButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapButton(int x, int y)
	{
		setText("MAP");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void doAction()
	{
		//DISPLAYS MAP
		//Display.setState(Display.getMapState());
	}
}
