package com.mobidevelop.ads.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mobidevelop.ads.AdsGame;

public class MenuScreen extends BaseScreen {

    private Stage stage;
    private Texture button;
    private BitmapFont font;

    public MenuScreen (final AdsGame game) {
        super(game);

        font = new BitmapFont();
        Pixmap pixmap = new Pixmap(4, 4, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        pixmap.drawPixel(0,0, 0x00000000);
        pixmap.drawPixel(3,0, 0x00000000);
        pixmap.drawPixel(3,3, 0x00000000);
        pixmap.drawPixel(0,3, 0x00000000);
        button = new Texture(pixmap);
        stage = new Stage();

        Table main = new Table();
        main.setFillParent(true);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(button)){{
                setTopHeight(10);
                setLeftWidth(10);
                setRightWidth(10);
                setBottomHeight(10);
        }};
        style.down = new SpriteDrawable(new Sprite(button)){{
            getSprite().setColor(Color.RED);
        }};
        style.font = font;

        final TextButton button1 = new TextButton("Show / Hide Banner", style);
        final TextButton button2 = new TextButton("Show Interstitial", style);
        main.defaults().space(10);
        main.add(button1).row();
        main.add(button2).row();
        stage.addActor(main);

        Gdx.input.setInputProcessor(stage);
        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (button1.isChecked()) {
                    game.getAdsController().showBannerAd();
                } else {
                    game.getAdsController().hideBannerAd();
                }
            }
        });
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.getAdsController().showInterstitialAd(new Runnable() {
                    @Override
                    public void run() {
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(delta, 1 / 30f));
        stage.draw();
    }
}
