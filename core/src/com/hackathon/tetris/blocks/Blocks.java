package com.hackathon.tetris.blocks;


import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Blocks extends Polygon{
    private Vector2 position;
    private byte numberOfBlocks=4;

    Blocks (BlocksTypesEnum blockType, float scale) {
        float[] vertices=BlocksVertices.getTypeVertices(blockType);
        for (int i=0;i<vertices.length;i++){
            vertices[i]=scale*vertices[i];
        }
        this.setVertices(vertices);
    }
    public void updatePosition(float dt) {

    }
    public void handleInput() {

    }
    public void reposition() {

    }
}
