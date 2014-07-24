package com.mobidevelop.ads;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mobidevelop.ads.controllers.AdsController;
import com.mobidevelop.ads.screens.MenuScreen;

public class AdsGame extends Game {

    private AdsController adsController;

    public AdsController getAdsController () {
        return adsController;
    }

    public AdsGame () {
        this(null);
    }

    public AdsGame (AdsController adsController) {
        if (adsController != null) {
            this.adsController = adsController;
        } else {
            this.adsController = new DummyAdsController();
        }
    }

	@Override
    public void create () {
        setScreen(new MenuScreen(this));
    }

    private class DummyAdsController implements AdsController {

        @Override
        public void showInterstitialAd (Runnable then) {
            Gdx.app.debug("DummyAdController", "showInterstitialAd");
            Gdx.app.postRunnable(then);
        }

        @Override
        public void showBannerAd () {
            Gdx.app.debug("DummyAdController", "showBannerAd");
        }

        @Override
        public void hideBannerAd () {
            Gdx.app.debug("DummyAdController", "hideInterstitialAd");
        }

    }

}
