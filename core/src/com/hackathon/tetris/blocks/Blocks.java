package com.hackathon.tetris.blocks;


public class Blocks {
    Blocks (BlocksTypesEnum blockType) {
        boolean blockArray[][]=new boolean[2][4];
        for (int i=0;i<2;i++) {
            for (int j=0;j<4;j++) {
                blockArray[i][j]=false;
            }
        }
        switch (blockType) {
            case Z: blockArray[0][0]=true;
                    blockArray[0][1]=true;
                    blockArray[1][1]=true;
                    blockArray[1][2]=true;
            case NAIL: blockArray[0][0]=true;
                    blockArray[0][1]=true;
                    blockArray[0][2]=true;
                    blockArray[1][1]=true;
            case L: blockArray[0][2]=true;
                    blockArray[1][0]=true;
                    blockArray[1][1]=true;
                    blockArray[1][2]=true;
            case Z_INVERSE: blockArray[0][1]=true;
                    blockArray[0][2]=true;
                    blockArray[1][0]=true;
                    blockArray[1][1]=true;
            case SQUARE: blockArray[0][0]=true;
                    blockArray[0][1]=true;
                    blockArray[1][0]=true;
                    blockArray[1][1]=true;
            case L_INVERSE: blockArray[0][0]=true;
                    blockArray[0][1]=true;
                    blockArray[0][2]=true;
                    blockArray[1][2]=true;
            case LINE: blockArray[0][0]=true;
                    blockArray[0][1]=true;
                    blockArray[0][2]=true;
                    blockArray[0][3]=true;
        }
    }
}
