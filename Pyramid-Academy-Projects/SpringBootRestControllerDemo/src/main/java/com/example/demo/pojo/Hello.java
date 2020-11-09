package com.example.demo.pojo;

public class Hello {
    String hello;

    public Hello(){};

    public Hello(String s){
        this.hello = s;
    }

    public void setHello(String s){
        this.hello = s;
    }

    public String getHello()
    {
        return hello;
    }

    @Override
    public String toString(){
        return hello;
    }
}
