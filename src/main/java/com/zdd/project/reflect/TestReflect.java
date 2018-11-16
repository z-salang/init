package com.zdd.project.reflect;

import com.zdd.project.reflect.impl.Hello;
import com.zdd.project.reflect.impl.HelloInvocationHandlerImpl;
import com.zdd.project.reflect.impl.ManyPeople;
import com.zdd.project.reflect.impl.NoHello;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by zhoudongdong<zdd109067> on 17/4/30.
 */
public class TestReflect {
  public static void main(String[] args) {
    HelloInvocationHandlerImpl handler = new HelloInvocationHandlerImpl(new Hello());
    IHello helloProxyInstance = (IHello) Proxy.newProxyInstance(TestReflect.class.getClassLoader(), new Class[] {IHello.class}, handler);
    helloProxyInstance.saySomething("Test invocationHandler!");
    helloProxyInstance.playGames("王者农药");
    System.out.println("===========================");

    InvocationHandler noHelloHandler = new HelloInvocationHandlerImpl(new NoHello());
    INoHello noHelloProxyInstance = (INoHello) Proxy.newProxyInstance(TestReflect.class.getClassLoader(),
        new Class[] {INoHello.class}, noHelloHandler);
    noHelloProxyInstance.sayWhatTheFuck();
    System.out.println("===========================");

    InvocationHandler peopleHandler = new HelloInvocationHandlerImpl(new ManyPeople());
    IHello h1 = (IHello) Proxy.newProxyInstance(TestReflect.class.getClassLoader(),
        new Class[] {IManyPeople.class, IHello.class, INoHello.class}, peopleHandler);
    h1.saySomething("shit ..");
  }
}
