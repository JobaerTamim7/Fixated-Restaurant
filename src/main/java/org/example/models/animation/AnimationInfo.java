package org.example.models.animation;

import javafx.scene.Node;

public class AnimationInfo {
    private Node node;
    private double from;
    private double to;
    private double duration;


    public AnimationInfo(Node node, double from, double to) {
        this.node = node;
        this.from = from;
        this.to = to;
        this.duration = 1500;
    }

    public AnimationInfo(Node node, double from, double to, double duration) {
        this.node = node;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
