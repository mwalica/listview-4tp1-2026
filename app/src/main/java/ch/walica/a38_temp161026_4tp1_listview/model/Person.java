package ch.walica.a38_temp161026_4tp1_listview.model;

import androidx.annotation.NonNull;

import java.util.Random;

public class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
        this.age = new Random().nextInt(81) + 18;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
