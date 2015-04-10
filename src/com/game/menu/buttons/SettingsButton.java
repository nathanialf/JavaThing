package com.game.menu.buttons;

import com.game.main.*;
import com.game.menu.*;
import com.game.state.State;

public class SettingsButton extends MenuButton
{
	/**
	 * 
	 */
	public State s = new State();
	private static final long serialVersionUID = 1L;

	public SettingsButton(int x, int y)
	{
		setText("SETTINGS");
		setX(x);
		setY(y);
		setWidth(Display.WIDTH / 4);
		setHeight(Display.HEIGHT / 16);
		buildBody();

		s.setName("");
		s.background.setRect(Display.WIDTH / 3, -Display.HEIGHT, Display.WIDTH, Display.HEIGHT); 
		s.BASE_HEIGHT = Display.HEIGHT;
	}
	
	public void doAction()
	{
		if(Display.getState().getSubState() != Display.getSettingsState())
			Display.getState().setSubState(Display.getSettingsState());
	}
}
