package com.secondTask.firstSubtask;

public class Shape {

    private String name_;
    private Double surfaceSquare_, volume_;

    public Shape(String name, Double surfaceSquare, Double volume) {
        this.name_ = name;
        this.surfaceSquare_ = surfaceSquare;
        this.volume_ = volume;
    }

    @Override
    public String toString() {
        return "Shape: {"
                + "name_='" + name_ + '\''
                + ", surfaceSquare_=" + surfaceSquare_
                + ", volume_=" + volume_
                + '}';
    }
}
