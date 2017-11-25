package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseState extends State {
    private PlayState playState;
    private SpriteBatch sb;
    private Texture img;

    public PauseState(GameStateManager gsm, PlayState playState, SpriteBatch sb) {
        super(gsm);

        this.sb = sb;
        img = new Texture("bird.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()) {
//            PlayState newPlayState = new PlayState(gsm, sb);
            gsm.set(this.playState);
        }


    }

    @Override
    public void upadte(float dt) {
        handleInput();

    }

    @Override
    public void render() {
        sb.begin();
        sb.draw(img, 200, 200);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
