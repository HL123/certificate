package com.abc.tools;

import java.net.URL;

public class LoadClass {
    public static void main(String[] args) {

        /*
        引导类加载器，又称启动类加载器，是最顶层的类加载器，主要用来加载Java核心类，如rt.jar、resources.jar、charsets.jar等，
         */
        System.out.println("======BootStrap======");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        
        System.out.println("======ExtClassloader======");
        System.out.println(System.getProperty("java.ext.dirs"));


        System.out.println("======AppClassloader======");
        System.out.println(System.getProperty("java.class.path"));


        System.out.println("==========================");
        System.out.println(System.getProperty("sun.boot.class.path"));






    }
}
