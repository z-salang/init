package com.zdd.project.java8.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/12/7 ??5:39
 */
public class TestFilter {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(9);
        list.add(13);
        list.add(2);
        list.add(8);


        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());


        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

//        Person result1 = persons.stream().max(Comparator.comparing(person -> ));

//        System.out.println(result1);
    }
}

class Person implements Comparator {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
