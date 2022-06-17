package com.example;

import lombok.Value;

@Value
public class Coordinate {
    int x;
    int y;

    public double distance(Coordinate target) {
        return Math.sqrt(Math.pow(this.x - target.x, 2) + Math.pow(this.y - target.y, 2));
    }
}
