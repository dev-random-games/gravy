package co.devrandom.main;

import org.jbox2d.common.Vec2;


public class GameState {
	private static final GameState gameState = new GameState(State.PAUSED);
	
	/*
	 * File path settings
	 */
	public static final String NAME = "Iris";
	public static final String ASSET_PATH = "/assets/";
	public static final String FONT_PATH = ASSET_PATH + "fonts/";
	public static final String IMG_PATH = ASSET_PATH + "img/";
	public static final String AUDIO_PATH = ASSET_PATH + "audio/";
	
	/*
	 * Game window settings
	 */
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final boolean ANTIALIAS = true;
	public static final int FPS = 60; 
	
	/*
	 * jBox2D settings
	 */
	public static float SCALE = 100f;
	public static float TIME_STEP = 1f / 60f;
	public static int VELOCITY_ITERATIONS = 6;
	public static int POSITION_ITERATIONS = 2;
	public static final Vec2 DEFAULT_GRAVITY = new Vec2(0.0f, 9.8f);

	public enum State {
		RUNNING,
		PAUSED,
		MAIN_MENU;
	}
	
	private static State currentState;
	
	private GameState(State initializeState) {
		currentState = initializeState;
	}
	
	public static GameState getInstance() {
		return gameState;
	}
	
	public static boolean isModelRunning() {
		return currentState == State.RUNNING;
	}
	
	public static void pauseUnpause() {
		if (currentState == State.PAUSED)
			currentState = State.RUNNING;
		else if (currentState == State.RUNNING)
			currentState = State.PAUSED;
	}
}
