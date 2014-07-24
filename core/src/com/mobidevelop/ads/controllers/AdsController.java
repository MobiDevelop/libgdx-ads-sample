package com.mobidevelop.ads.controllers;

public interface AdsController {

    public void showInterstitialAd (Runnable then);

    public void showBannerAd ();

    public void hideBannerAd ();

}
