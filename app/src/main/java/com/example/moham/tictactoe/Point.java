package com.example.moham.tictactoe;

/**
 * Created by moham on 5/20/2016.
 */
public class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
