package com.multithreading;

public class University {
    public static void main(String[] args) {
        Student engineeringStudent = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is an Engineering Student";
            }
        };

        Student lawStudent = (name) -> {return name + "is Law Student";};

        String bio = engineeringStudent.getBio("Ehsan");
        System.out.println(bio);
    }
}
