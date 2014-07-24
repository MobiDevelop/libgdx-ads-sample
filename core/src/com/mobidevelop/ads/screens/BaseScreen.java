package com.mobidevelop.ads.screens;

import com.badlogic.gdx.Screen;
import com.mobidevelop.ads.AdsGame;

public class BaseScreen implements Screen {

    protected AdsGame game;

    public BaseScreen (AdsGame game) {
        this.game = game;
    }

    @Override
    public void dispose () {
    }

    @Override
    public void show () {
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void render (float delta) {
    }

    @Override
    public void resize (int width, int height) {
    }

}
