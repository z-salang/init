package com.zdd.project.collection.map;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/4/23 ??7:56
 */
public class ToMap {


  public static void main(String[] args) {
    Hobby hobby = new Hobby("swimming");
    Person p = new Person("tony", hobby);

    List<Person> list = Lists.newArrayList(p);

    Map<String, String> collect = list.stream().collect(Collectors.toMap(c -> c.getName(), c -> c.getHobby().getHobbyName()));
//        Map<String, Person> collect1 = list.stream().collect(Collectors.toMap(Person::getName, Function::identity()));
    System.out.println(collect);

    Person p1 = new Person("jack");
    Person p2 = new Person("jack");
    Person p3 = new Person("lily");

    ArrayList<Person> people = Lists.newArrayList(p1, p2, p3);
    people.stream().collect(Collectors.toMap(Person::getName, Function.identity()));

  }
}

class Person {
  private String name;
  private Hobby hobby;

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, Hobby hobby) {
    this.name = name;
    this.hobby = hobby;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Hobby getHobby() {
    return hobby;
  }

  public void setHobby(Hobby hobby) {
    this.hobby = hobby;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", hobby=" + hobby +
            '}';
  }
}

class Hobby {
  private String hobbyName;

  public Hobby(String hobbyName) {
    this.hobbyName = hobbyName;
  }

  public String getHobbyName() {
    return hobbyName;
  }

  public void setHobbyName(String hobbyName) {
    this.hobbyName = hobbyName;
  }

  @Override
  public String toString() {
    return "Hobby{" +
            "hobbyName='" + hobbyName + '\'' +
            '}';
  }
}
