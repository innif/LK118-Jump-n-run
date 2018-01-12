package de.L118.game;

import graphics.Graphics;
import graphics.renderer.Renderer;

/**
 * 
 * @author james_000
 *
 *	Die Game-Klasse
 *	Hauptklasse des Spiels.
 *	Game-loop, update- and render-methode in dieser klasse
 */
public class Game {

	private boolean running;
	
	Player p;
	World w;
	
	long timer;
	
	public Game()
	{
		
	}
	
	/**
	 * Initialisierung des Spiels
	 */
	private void init()
	{
		Renderer.init();
		w = new World();
		p = new Player(w);
	}
	
	/**
	 * Cleans up the game
	 */
	private void cleanUp()
	{
		Renderer.cleanUp();
	}
	
	/**
	 * 
	 * Updating des Spiels
	 */
	private void update()
	{
		p.update();
		p.jump();
		p.moveRight(0.01);
	}
	
	/**
	 * 
	 * Rendering des Spiels
	 * 
	 */
	private void render()
	{
		w.render();
		p.draw();
	}
	
	/**
	 *
	 * 	Start und Initialisierung des Spiels
	 *  
	 */
	public void start()
	{
		running = true;
		run();
	}
	
	/**
	 * 
	 * Schlie�t das Spiel
	 * 
	 */
	public void stop()
	{
		running = false;
	}
	
	/**
	 * 
	 * Die game-loop des spiels
	 * TODO: Timer
	 */
	private void run()
	{
		Graphics.createWindow(1270, 720, "Jump n Run", false);
		init();
		while (running)
		{
			update();
			
			Graphics.clearWindow();
			render();
			
			Graphics.updateWindow();
			running = Graphics.windowOpen();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cleanUp();
	}
	
}
