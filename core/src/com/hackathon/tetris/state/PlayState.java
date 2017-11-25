package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
    private int Codes[];

    private Texture bg;
    private SpriteBatch sb;


    public PlayState(GameStateManager gsm, SpriteBatch sb) {
        super(gsm);
        bg = new Texture("11.png"); // core/assets
        this.sb = sb;
        Codes = new int[4];
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
    public void render() {
        sb.begin();
        sb.draw(bg,0, 0);
        sb.end();

    }

    public Texture getBg() {
        return bg;
    }

    public void setBg(Texture texture){
        this.bg = texture;
    }

    @Override
    public void dispose() {
        bg.dispose();

    }
}
