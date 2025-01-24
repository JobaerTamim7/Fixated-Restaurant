package org.example.utils;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import org.example.models.animation.AnimationInfo;

public class AnimationFactory {
    public static TranslateTransition runAnimation(AnimationInfo animation) {
        TranslateTransition anim = Utility.verticalSliderTransition(animation.getNode(),animation.getFrom(),animation.getTo());
        anim.setInterpolator(Interpolator.EASE_IN);
        return anim;
    }

    public static ParallelTransition runParallelAnimation(AnimationInfo... animations) {
        ParallelTransition parallelTransition = new ParallelTransition();
        for (AnimationInfo animation : animations) {
            TranslateTransition transition = Utility.verticalSliderTransition(animation.getNode(),animation.getFrom(),animation.getTo(),animation.getDuration());
            transition.setInterpolator(Interpolator.EASE_IN);
            parallelTransition.getChildren().add(transition);
        }
        return parallelTransition;
    }
}
