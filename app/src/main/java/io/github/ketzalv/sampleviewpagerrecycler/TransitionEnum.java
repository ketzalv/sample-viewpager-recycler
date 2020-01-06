package io.github.ketzalv.sampleviewpagerrecycler;

import androidx.annotation.AnimRes;

public enum TransitionEnum {
//    FORDWARD(R.anim.slide_from_left, R.anim.slide_to_left),
//    BACK(R.anim.slide_from_right, R.anim.slide_to_right),
    FADE(android.R.anim.fade_in, android.R.anim.fade_out),
    NONE(0, 0);

    private int enterAnimation;
    private int exitAnimation;

    TransitionEnum(@AnimRes int enterAnimation, @AnimRes int exitAnimation) {
        this.enterAnimation = enterAnimation;
        this.exitAnimation = exitAnimation;
    }

    public int getEnterAnimation() {
        return enterAnimation;
    }

    public int getExitAnimation() {
        return exitAnimation;
    }
}

