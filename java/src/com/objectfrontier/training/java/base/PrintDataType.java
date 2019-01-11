package com.objectfrontier.training.java.base;
class PrintDatatype {

    public static void main(String[] arg) {

        Object a = 100 / 24;
        System.out.println(a.getClass().getSimpleName());

        Object b = 100.10 / 10;
        System.out.println(b.getClass().getSimpleName());

        Object c = 'Z' / 2;
        System.out.println(c.getClass().getSimpleName());

        Object d = 10.5 / 0.5;
        System.out.println(d.getClass().getSimpleName());

        Object e = 12.4 % 5.5;
        System.out.println(e.getClass().getSimpleName());

        Object f = 100 % 56;
        System.out.println(f.getClass().getSimpleName());
    }
}
