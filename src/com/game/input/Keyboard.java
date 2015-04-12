package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.game.state.*;
import com.game.main.Display;

public class Keyboard implements KeyListener
{
	/*
	 * 0 - UP
	 * 1 - DOWN
	 * 2 - LEFT
	 * 3 - RIGHT
	 * 4 - PAUSE
	 * 5 - CONSOLE
	 */
	
	/*
	 * F1 - 112
	 * F2 - 113
	 */
	public int 	control [] = 					{0,		0,		0,		0,		0,		0};
	private String 	control_description [] =	{"Up", 	"Down",	"Left",	"Right","Pause","Console"};
	private boolean player_move [] = 			{false,	false, 	false, 	false, 	false, 	false};
	
	public Keyboard()
	{
		//CONFIGURATION FILE
		File config = new File("res/config.ini");
		//reader will read the config file
		Scanner reader;
		try 
		{
			//sets the reader to the config file
			reader = new Scanner(config);
			
			//while the file is not done
			while(reader.hasNextLine())
			{
				//takes a line of the file
				String line = reader.nextLine();
				
				//splits it at the ':'
				String values [] = line.split("-");
				
				//applies the description
				for(int a = 0; a < control.length; a++)
				{
					if(values[0].equals(control_description[a]))
					{
						if(values[1].equals("enter"))
						{
							control[a] = '\n';
						}
						else if(values[1].equals("enter"))
						{
							control[a] = '\t';
						}
						else
						{
							control[a] = values[1].charAt(0);
						}
					}
				}
			}
			
			//closes reader
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) 
	{
		
		//if(e.getKeyCode() == e.VK_ESCAPE)System.exit(0);
		if(e.getKeyCode() == e.VK_F2)
		{
			if(Display.getState().getSubState() != Display.getInformationState())
				Display.getState().setSubState(Display.getInformationState());
			else
				Display.getState().setSubState(new State());
		}
		
		if(e.getKeyChar() == control[5]  && !Display.getState().is_open_animating)
		{
			//OPENS THE CONSOLE
			System.out.println("This will open the console for debugging");
		}
		
		//Toggles play and pause state
		if(e.getKeyChar() == control[4] && !Display.getState().is_open_animating)
		{
			if(!player_move[4])
			{
				if(Display.getState() == Display.getPlayState())
				{
					Display.setState(Display.getPauseState());
				}
				else if(Display.getState() == Display.getPauseState())
				{
					Display.setState(Display.getPlayState());
				}
			}
		}
		
		//HOW TO USE THE CONTROLS
		for(int a = 0; a < control.length; a++)
		{	
			if(e.getKeyChar() == control[a])
			{
				player_move[a] = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		for(int a = 0; a < control.length; a++)
		{
			if(e.getKeyChar() == control[a])
			{
				player_move[a] = false;
			}
		}
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public boolean[] getPlayerMovement()		{return this.player_move;}
}
