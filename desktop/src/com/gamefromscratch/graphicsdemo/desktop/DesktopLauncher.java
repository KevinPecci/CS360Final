package com.gamefromscratch.graphicsdemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gamefromscratch.graphicsdemo.DragonAnimationDemo4;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		final int WIDTH = 1000;
		final int HEIGHT = 1000;
		config.width = WIDTH;
		config.height = HEIGHT;
		
		new LwjglApplication(new DragonAnimationDemo4(), config);
	}
}
