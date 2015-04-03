package com.game.main;

import com.game.input.*;
import com.game.state.*;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Display extends Canvas implements Runnable 
{
	private static final long serialVersionUID = 1L;
	
	/*
	 * Capitalized variables are ones that should not change ever or through the use of a restart
	 */
	
	//DIMENSIONS
	public static int WIDTH;
	public static int HEIGHT;

	private Thread thread;
	private boolean running = false;

	private static Display display = new Display();
	private static JFrame frame = new JFrame();
	
	//INPUT
	private static Keyboard keyboard;
	private static Mouse mouse;
	private static MouseMotion mouse_motion;
	
	//GAME STATE
	//Will define what needs to happen when in each state to
	//improve performance over previous games
	private static State current_state = new State();
	private static PlayState PLAY_STATE = new PlayState();
	private static PauseState PAUSE_STATE = new PauseState();
	private static SettingsState SETTINGS_STATE = new SettingsState();
	
	public static Font MAIN_FONT;

	public Display()
	{	
		//imports configurations for the game
		//All pertinent information will live there
		File config = new File("res/config.ini");
		
		try 
		{
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(config);
			
			while(reader.hasNextLine())
			{
				String line = reader.nextLine();
				String values[] = line.split("-");
				if(values[0].equals("Resolution"))
				{
					if(values[1].equals("Automatic"))
					{
						
					}
					else
					{
						String dimensions [] = values[1].split("x");
						WIDTH = Integer.parseInt(dimensions[0]);
						HEIGHT = Integer.parseInt(dimensions[1]);
					}
				}
				if(values[0].equals("Fullscreen"))
				{
					System.out.println(values[1]);
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		keyboard = new Keyboard();
		mouse = new Mouse();
		mouse_motion = new MouseMotion();
	}

	private synchronized void start() 
	{	
		running = true;
		thread = new Thread(this);
		thread.start();
		
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse_motion);
	}

	private synchronized void stop() 
	{
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run() 
	{	
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;

		int frames = 0;
		int updates = 0;

		while (running) 
		{
			//
			long now = System.nanoTime();
			// delta is the change in time. used for compensating lag
			delta += (now - lastTime) / ns;

			lastTime = now;

			while (delta >= 1) {
				// updates the game loop every 1/60 th a second
				update(delta);
				updates++;
				delta--;
			}
			// renders as fast as you can, not limited to 60fps, but will cause
			// the lag that update will have to compensate for it in the update
			// loop
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// displays updates and frames per second in the window title
				frame.setTitle(updates + " UPS, " + frames + "FPS");
				
				frames = 0;
				updates = 0;
			}

		}
		stop();
	}

	private void update(double delta) 
	{
		// Update loop. Runs at 60UPS, the MINIMUM that should be in a game
		current_state.update(delta);
	}

	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) 
		{
			createBufferStrategy(3);
			return;
		}

		// Graphics g = bs.getDrawGraphics();
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// draw
		
		g.setFont(MAIN_FONT);
		
		//RENDER THINGS IN THE CURRENT STATE
		current_state.render(g);
		 
		g.dispose();

		bs.show();

	}

	public static void main(String[] args) throws FileNotFoundException, FontFormatException, IOException 
	{
		long start = System.currentTimeMillis();
		// sets everything. straight forward
		frame.add(display);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		display.start();
		
		current_state = getPlayState();
		
		frame.setFocusable(true);
		frame.requestFocus();
		
		MAIN_FONT = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("res/fonts/Roboto-Regular.ttf"));
		MAIN_FONT = MAIN_FONT.deriveFont((HEIGHT/60F));
		
		long end = System.currentTimeMillis();
		System.out.println("Time to load: " + (end - start) + " Milliseconds");
	}
	
	//ACCESSORS AND MUTATORS
	public static Keyboard getKeyboard() 			{return keyboard;}
	public static Mouse getMouse()					{return mouse;}
	public static MouseMotion getMouseMotion()		{return mouse_motion;}
	public static State getState()					{return current_state;}
	public static PlayState getPlayState()			{return PLAY_STATE;}
	public static PauseState getPauseState()		{return PAUSE_STATE;}
	public static SettingsState getSettingsState()	{return SETTINGS_STATE;}
	public int getWidth()							{return WIDTH;}
	public int getHeight()							{return HEIGHT;}
	
	public static void setState(State s)		
	{
		State old = current_state;
		
		current_state = s;
		current_state.openAnim();
		
		Rectangle2D.Double newBody = new Rectangle2D.Double(0, -current_state.BASE_HEIGHT, WIDTH, current_state.BASE_HEIGHT);
		
		old.setBackground(newBody);
	}
}