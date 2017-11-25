package com.hackathon.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hackathon.tetris.state.GameStateManager;
import com.hackathon.tetris.state.MenuState;
import com.hackathon.tetris.state.PlayState;

public class TetrisGame extends ApplicationAdapter {
    public static final String TITLE ="Tetris";
    public static final boolean FULLSCREEN = true;
    public static final int WIDTH = 900;
	SpriteBatch batch;
	GameStateManager gsm;
	
	@Override
	public void create () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm, batch));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.upadate(Gdx.graphics.getDeltaTime());
		gsm.render();
	}
	
	@Override
	public void dispose () {

	}
}
