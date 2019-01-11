package com.objectfrontier.training.java.base;
class Enum {

    public static void main(String[] args) {

        Direction s = Direction.SOUTH;
        String s1 = "SOUTH";
        System.out.println(s.toString() == s1);
        System.out.println(s.equals(s1));
    }

    enum Direction {

        SOUTH, WEST, EAST, NORTH;
    }
}
