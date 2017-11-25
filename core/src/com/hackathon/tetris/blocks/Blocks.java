package com.hackathon.tetris.blocks;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Blocks extends Polygon{
    private static final int GRAVITY = -15;
    private Vector2 velocity;
    private Vector2 position;
    private int rotation = 0;
    private byte numberOfBlocks=4;
    private Texture blockImage;
    private BlocksTypesEnum type;
    private float scale=1;

    public Blocks (BlocksTypesEnum blockType, float scale) {
        position = new Vector2(300, 300);
        velocity = new Vector2(0,GRAVITY);
        type=blockType;
        setTexture();
        this.scale=scale;
        float[] vertices=BlocksVertices.getTypeVertices(blockType);
        for (int i=0;i<vertices.length;i++){
            vertices[i]=scale*vertices[i];
        }
        this.setVertices(vertices);
    }
    public Blocks (Blocks block) {
        this.type=block.type;
        this.scale=block.scale;
        this.position=block.position;
        this.rotation=block.rotation;
        this.blockImage=block.blockImage;
        this.velocity=block.velocity;
    }
    public void setTexture() {
        switch (type) {
            case Z:
                blockImage = new Texture("OKButton1.png");
                break;
            case NAIL:
                blockImage = new Texture("22.png");
                break;
            case L:
                blockImage = new Texture("66.png");
                break;
            case Z_INVERSE:
                blockImage = new Texture("33.png");
                break;
            case SQUARE:
                blockImage = new Texture("11.png");
                break;
            case L_INVERSE:
                blockImage = new Texture("77.png");
                break;
            case LINE:
                blockImage = new Texture("55.png");
                break;
        }
    }

    public void updatePosition(float dt) {
        handleInput();
        velocity.scl(dt);
        position.add(velocity);
        velocity.scl(1/dt);
    }
    public void handleRotation() {
        if(!checkCollisionsAfterRotation()) {
            this.rotate(90);
        }
    }
    public boolean checkCollisionsAfterRotation() {
        int tmpRotation=(rotation+1)%4;
        Blocks tmpBlock=new Blocks(this);
        return false;
    }
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(22)){ //RIGHT - 22
            position.add(40,0);
        }
        else if(Gdx.input.isKeyJustPressed(21))
            position.add(-40,0);


    }
    public void reposition() {

    }

    public Texture getBlockImage() {
        return blockImage;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
