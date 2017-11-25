package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class MenuState extends State {
    private Texture bg;
    private Rectangle rec;
    private Rectangle mouse;
    private Vector2 posMouse;
    private SpriteBatch sb;

    public MenuState(GameStateManager gsm, SpriteBatch sb) {
        super(gsm);
        this.sb = sb;
        posMouse = new Vector2(Gdx.input.getX(),-(Gdx.input.getY() - Gdx.graphics.getHeight()));
        bg = new Texture("ExitButton1.png");
        rec = new Rectangle(200, 200, bg.getWidth(), bg.getHeight());
        mouse = new Rectangle(posMouse.x, posMouse.y,1,1);
    }

    @Override
    protected void handleInput() {
        if(mouse.overlaps(rec)){ //if mouse overlaps button
            bg = new Texture("ExitButton2.png");
            render();
            if (Gdx.input.isTouched())
                gsm.set(new PlayState(gsm, sb));
        }
        else{
            bg = new Texture("ExitButton1.png");
            render();
        }


    }

    @Override
    public void upadte(float dt) {
        posMouse.set(Gdx.input.getX(), -(Gdx.input.getY() - Gdx.graphics.getHeight()));
        System.out.println("x: " + posMouse.x +"y: "+ posMouse.y);
        mouse.setPosition(posMouse.x, posMouse.y);
        handleInput();
    }

    @Override
    public void render() {
        sb.begin();
        sb.draw(bg, 200, 200);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
