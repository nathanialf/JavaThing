package com.game.menu;

import com.game.main.*;

public class MapButton extends MenuComponent
{
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
