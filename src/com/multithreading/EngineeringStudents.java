package com.multithreading;

public class EngineeringStudents implements Student,Faculity{

    @Override
    public String getBio(String name) {
        return name + " is Engineering Student !";
    }
}
