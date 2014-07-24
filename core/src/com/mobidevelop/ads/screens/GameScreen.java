package com.mobidevelop.ads.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mobidevelop.ads.AdsGame;

public class GameScreen extends BaseScreen {

    public GameScreen (AdsGame game) {
        super(game);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
