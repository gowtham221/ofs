package com.objectfrontier.training.java.base;
class Sorting {

    public static void main(String[] arg) {

        String cities[] = {"Madurai", "Thanjavur", "TRICHY", "Karur", "Erode", "trichy", "Salem"};
        for(int i = 0; i < cities.length; i++) {
            for(int j = i + 1; j < cities.length; j++) {
                int c = cities[i].compareToIgnoreCase(cities[j]);
                String temp;
                if (c > 0) {
                    temp = cities[i];
                    cities[i] = cities[j];
                    cities[j] = temp;
                }
            }
            System.out.println(cities[i]);
        }
        System.out.println('\n');
        for(int i = 0; i < cities.length; i++) {
            if ((i % 2) == 0) {
                cities[i] = cities[i].toUpperCase();
                System.out.println(cities[i]);
            }
        }
    }
}
