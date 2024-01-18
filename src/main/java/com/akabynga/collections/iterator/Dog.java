package com.akabynga.collections.iterator;

import java.util.Objects;

public class Dog implements Comparable{
    private final String nickName;
    private int age;

    public Dog(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }
    public Dog(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;
//    return true;
        return Objects.equals(nickName, dog.nickName);
    }

    @Override
    public int hashCode() {
//    return 0;
        return nickName != null ? nickName.hashCode() : 0;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.age,((Dog) o).age);
    }
}