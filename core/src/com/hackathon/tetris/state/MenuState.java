package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class MenuState extends State {
    private Texture bg;
    private Texture playBtn;
    private Rectangle recPlay;
    private Texture exitBtn;
    private Rectangle recExit;
    private Rectangle mouse;
    private Vector2 posMouse;
    private SpriteBatch sb;
    private TextureRegion region;

    public MenuState(GameStateManager gsm, SpriteBatch sb) {
        super(gsm);
        this.sb = sb;
        posMouse = new Vector2(Gdx.input.getX(),-(Gdx.input.getY() - Gdx.graphics.getHeight()));

        //playButton
        playBtn = new Texture("PlayButton1.png");
        recPlay = new Rectangle(600, 110, playBtn.getWidth(), playBtn.getHeight());

        //exitButton
        exitBtn = new Texture("ExitButton1.png");
        recExit = new Rectangle(600 ,40 , exitBtn.getWidth(), exitBtn.getHeight());

        //bg
        bg = new Texture("MainMenuBackground.png");

        //region
        region = new TextureRegion(bg, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        mouse = new Rectangle(posMouse.x, posMouse.y,1,1);
    }

    @Override
    protected void handleInput() {
        if(mouse.overlaps(recPlay)){ //if mouse overlaps button
            playBtn = new Texture("PlayButton2.png");
            if (Gdx.input.isTouched())
                gsm.set(new PlayState(gsm, sb));
        }
        else if(mouse.overlaps(recExit)){
            exitBtn = new Texture("ExitButton2.png");
            if (Gdx.input.isTouched()) {
                System.out.println("siemka");
                System.exit(0);
            }
    }
        else{
            playBtn = new Texture("PlayButton1.png");
            exitBtn = new Texture("ExitButton1.png");
        }


    }

    @Override
    public void upadte(float dt) {
        posMouse.set(Gdx.input.getX(), -(Gdx.input.getY() - Gdx.graphics.getHeight()));
//        System.out.println("x: " + posMouse.x +"y: "+ posMouse.y);
        mouse.setPosition(posMouse.x, posMouse.y);
        handleInput();
    }

    @Override
    public void render() {
        sb.begin();
        sb.draw(bg, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playBtn, 600, 110);
        sb.draw(exitBtn, 600 ,40);
        sb.end();

    }

    @Override
    public void dispose() {
        playBtn.dispose();
        exitBtn.dispose();

    }

    @Override
    public void resize(int width, int height) {

    }

}
