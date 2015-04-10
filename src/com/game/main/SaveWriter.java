package com.game.main;

import java.io.*;

public class SaveWriter 
{
	public SaveWriter()
	{
	}
	
	public void saveConfig() throws IOException
	{
		Display.config.createNewFile();
		
		FileWriter fw = new FileWriter(Display.config);

		fw.write("Resolution-" + Display.WIDTH + "x" + Display.HEIGHT + "\n");
		fw.write("Fullscreen-" + Display.FULLSCREEN + "\n");
		fw.write("Up-" + (char)Display.getKeyboard().control[0] + "\n");
		fw.write("Down-" + (char)Display.getKeyboard().control[1] + "\n");
		fw.write("Left-" + (char)Display.getKeyboard().control[2] + "\n");
		fw.write("Right-" + (char)Display.getKeyboard().control[3] + "\n");
		fw.write("Pause-enter" + "\n");
		fw.write("Console-" + (char)Display.getKeyboard().control[5] + "\n");
		fw.write("Volume-" + Display.volume);
		
		fw.close();
	}
}
