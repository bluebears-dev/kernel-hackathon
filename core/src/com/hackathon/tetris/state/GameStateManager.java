package com.hackathon.tetris.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> states;  // keep all states no stack

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);         //add new state
    }
    public void pop(){

        states.pop().dispose();    //free memory
    }
    public void set(State state){
        states.pop().dispose();     // set new state
        states.push(state);
    }
    public void upadate(float dt){   //update state
        states.peek().upadte(dt);
    }
    public void render(SpriteBatch sb){  //render state
        states.peek().render(sb);
    }
}
