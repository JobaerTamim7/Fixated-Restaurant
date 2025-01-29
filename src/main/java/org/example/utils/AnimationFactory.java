package org.example.utils;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import org.example.models.animation.AnimationInfo;

public class AnimationFactory {
    public static TranslateTransition createTranslateTransition(AnimationInfo animationInfo, boolean horizontal) {
        TranslateTransition transition;
        if (horizontal) {
            transition = Utility.horizontalSliderTransition(animationInfo.getNode(), animationInfo.getFrom(), animationInfo.getTo(), animationInfo.getDuration());
        }
        else {
            transition = Utility.verticalSliderTransition(animationInfo.getNode(), animationInfo.getFrom(), animationInfo.getTo(), animationInfo.getDuration());
        }
        return transition;
    }

}
