package com.hackathon.tetris.board;


import com.badlogic.gdx.math.Rectangle;
import com.hackathon.tetris.blocks.Blocks;
import com.hackathon.tetris.blocks.SmallBlocks;

import java.util.List;

public class GameBoard {
    Rectangle board;
    List<Blocks> currentBlocks;
    Blocks activeBlock;
    SmallBlocks[][] gameBoard=new SmallBlocks[10][10];
    public void removeRow(int number) {

    }
    public boolean checkCollision() {
        for(int i=0; i<activeBlock.getVertices().length;i++) {
            //left or right
            if (i%2==0) {
                if (activeBlock.getVertices()[i]<board.getX())
                    return true;
                if (activeBlock.getVertices()[i]>board.getX()+board.getWidth())
                    return true;
            }
            //down
            else {
                if (activeBlock.getVertices()[i]>board.getY())
                    return true;
            }
        }
        return false;
    }
}
