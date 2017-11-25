package com.hackathon.tetris.board;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.hackathon.tetris.blocks.Blocks;
import com.hackathon.tetris.blocks.BlocksTypesEnum;
import com.hackathon.tetris.blocks.SmallBlocks;

import java.util.List;
import java.util.Random;

import static com.hackathon.tetris.blocks.BlocksTypesEnum.*;

public class GameBoard {
    int xCorner=0;
    int yCorner=0;
    Rectangle board=new Rectangle(xCorner,yCorner,200,200);
    List<Blocks> currentBlocks;
    Blocks activeBlock=null;
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
            //downa
            else {
                if (activeBlock.getVertices()[i]>board.getY())
                    return true;
            }
        }
        return false;
    }
    public Blocks generateNewBlock() {
        if (activeBlock!=null)
            currentBlocks.add(activeBlock);
        Random random=new Random();
        int numberOfType=random.nextInt(7)+1;
        BlocksTypesEnum newBlockType=null;
        switch (numberOfType) {
            case 1:
                newBlockType=Z;
                break;
            case 2:
                newBlockType=NAIL;
                break;
            case 3:
                newBlockType=L;
                break;
            case 4:
                newBlockType=Z_INVERSE;
                break;
            case 5:
                newBlockType=SQUARE;
                break;
            case 6:
                newBlockType=L_INVERSE;
                break;
            case 7:
                newBlockType=LINE;
        }
        float scale=board.getWidth()/10;
        Blocks block = new Blocks(newBlockType,scale);
        int rotation = random.nextInt(4);
        Vector2 position=new Vector2(xCorner+board.getWidth()/2,yCorner+board.getHeight());
        block.setRotation(rotation);
        block.setPosition(position);
        return block;
    }
}
