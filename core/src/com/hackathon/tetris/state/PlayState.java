package com.hackathon.tetris.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hackathon.tetris.blocks.Blocks;
import com.hackathon.tetris.board.GameBoard;

import static com.hackathon.tetris.blocks.BlocksTypesEnum.Z;

public class PlayState extends State {
    private int Codes[];

    private Texture bg;
    private SpriteBatch sb;

    private GameBoard gameBoard;

    private Blocks block;

    public PlayState(GameStateManager gsm, SpriteBatch sb) {
        super(gsm);
        bg = new Texture("GameBackground.png"); // core/assets
        this.sb = sb;
        Codes = new int[4];
        gameBoard = new GameBoard();
        block = gameBoard.generateNewBlock();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(131)) // escape - 131
            System.exit(0);
    }

    @Override
    public void upadte(float dt) {
        handleInput();
        gameBoard.handleInput();
        block.updatePosition(dt);
    }

    @Override
    public void render() {
        sb.begin();
        sb.draw(bg, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(block.getBlockImage(), block.getPosition().x,block.getPosition().y,100,150);
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
        block.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
