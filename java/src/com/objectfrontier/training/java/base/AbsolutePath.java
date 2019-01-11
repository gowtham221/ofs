package com.objectfrontier.training.java.base;
class AbsolutePath {

    public static void main(String[] args) {

        AbsolutePath className = new AbsolutePath();
        Class<? extends AbsolutePath> curClass = className.getClass();
        // ClassLoader curClassFile = curClass.getClassLoader();
        // System.out.println(curClassFile.getResource("AbsolutePath.class"));
//        System.out.println(curClass.getProtectionDomain().getCodeSource().getLocation().getPath());
//        System.out.println(curClass.getProtectionDomain().getCodeSource().getLocation().toString());
        System.out.println(curClass.getProtectionDomain().getCodeSource().getLocation().getFile());
    }
}
