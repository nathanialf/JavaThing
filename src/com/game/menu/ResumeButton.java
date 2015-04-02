package com.game.menu;

import com.game.main.*;

public class ResumeButton extends MenuComponent
{
	public ResumeButton(int x, int y)
	{
		setText("RESUME");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();
	}
	
	public void doAction()
	{
		Display.setState(Display.getPlayState());
	}
}
