package com.hackathon.tetris.blocks;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Blocks extends Polygon{
    private Vector2 position;
    private byte numberOfBlocks=4;
    private Texture blockImage=null;
    private BlocksTypesEnum type;

    public Blocks (BlocksTypesEnum blockType, float scale) {
        type=blockType;
        setTexture();
        float[] vertices=BlocksVertices.getTypeVertices(blockType);
        for (int i=0;i<vertices.length;i++){
            vertices[i]=scale*vertices[i];
        }
        this.setVertices(vertices);
    }
    public void setTexture() {
        switch (type) {
            case Z:
                blockImage = new Texture("44.png");
            case NAIL:
                blockImage = new Texture("22.png");
            case L:
                blockImage = new Texture("66.png");
            case Z_INVERSE:
                blockImage = new Texture("33.png");
            case SQUARE:
                blockImage = new Texture("11.png");
            case L_INVERSE:
                blockImage = new Texture("77.png");
            case LINE:
                blockImage = new Texture("55.png");
        }
    }//aaaaaaa
    public void updatePosition(float dt) {

    }
    public void handleInput() {

    }
    public void reposition() {

    }
}
