package com.hackathon.tetris.blocks;

public class BlocksVertices {
    public static float[] zVertices={1,0,
                              3,0,
                              3,1,
                              2,1,
                              2,2,
                              0,2,
                              0,1,
                              1,1,
                              1,0};
    public static float[] nailVertices={1,0,
                                 2,0,
                                 2,1,
                                 3,1,
                                 3,2,
                                 0,2,
                                 0,1,
                                 1,1,
                                 1,0};
    public static float[] lVertices={0,0,
                              3,0,
                              3,2,
                              2,2,
                              2,1,
                              0,1,
                              0,0};
    public static float[] zInverseVertices={0,0,
                                     2,0,
                                     2,1,
                                     3,1,
                                     3,2,
                                     1,2,
                                     1,1,
                                     0,1,
                                     0,0};
    public static float[] squareVertices={0,0,
                                   2,0,
                                   2,2,
                                   0,2,
                                   0,0};
    public static float[] lInverseVertices={2,0,
                                     3,0,
                                     3,2,
                                     0,2,
                                     0,1,
                                     2,1,
                                     2,0};
    public static float[] lineVertices={0,0,
                                        4,0,
                                        4,1,
                                        0,4,
                                        0,0};
    public static float[] getTypeVertices(BlocksTypesEnum type) {
        switch (type) {
            case Z: return zVertices;
            case NAIL: return nailVertices;
            case L: return lVertices;
            case Z_INVERSE: return zInverseVertices;
            case SQUARE: return squareVertices;
            case L_INVERSE: return lInverseVertices;
            case LINE: return lineVertices;
        }
        return null;
    }
}
