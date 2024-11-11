package com.pratice;
//SingleTon Pattern
public class SingletonPattern {
}
class SingletonBuilder {

    //supports multithreading
    public static volatile SingletonBuilder singletonBuilder;

    private SingletonBuilder() {
        //initializing to set private constructor
    }

    public static SingletonBuilder getInstance() {
        if (singletonBuilder == null) {
            synchronized (SingletonBuilder.class) {
                if (singletonBuilder == null) {
                    singletonBuilder = new SingletonBuilder();
                }
            }

        }
        return singletonBuilder;
    }
}