package com.hackathon.tetris.blocks;


import com.badlogic.gdx.math.Polygon;

public class Blocks extends Polygon{
    Blocks (BlocksTypesEnum blockType, float scale) {
        float[] vertices=BlocksVertices.getTypeVertices(blockType);
        for (int i=0;i<vertices.length;i++){
            vertices[i]=scale*vertices[i];
        }
    }

}
