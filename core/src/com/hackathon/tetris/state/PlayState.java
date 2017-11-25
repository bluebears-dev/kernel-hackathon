package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {

    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("badlogic.jpg"); // core/assets
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(131)) // escape - 131
            System.exit(0);
    }

    @Override
    public void upadte(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0, 0);
        sb.end();

    }

    public Texture getBg() {
        return bg;
    }

    @Override
    public void dispose() {
        bg.dispose();

    }
}
