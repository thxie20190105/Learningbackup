package org.xigua.study.javabase.createobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author xigua
 * @description
 * @date 2020/5/31
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        Student student = new Student();

        Student student1 = (Student) student.clone();

        Student student2 = Student.class.newInstance();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
        Student student3 = (Student) objectInputStream.readObject();

    }
}

class Student implements Cloneable {
    public String name;
    public int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
