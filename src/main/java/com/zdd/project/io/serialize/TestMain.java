package com.zdd.project.io.serialize;

import com.zdd.project.io.serialize.entities.BudgetEvent;
import com.zdd.project.io.serialize.entities.ChargeEvent;
import com.zdd.project.io.serialize.entities.ChargeEventEntity;
import com.zdd.project.io.serialize.entities.Event;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2018/2/27 ??11:52
 */
public class TestMain {

    public static void main(String[] args) {

        ChargeEventEntity eventEntity = new ChargeEventEntity();
        eventEntity.setAccountId(110123L);
        eventEntity.setChargeId(12312312412451L);
        eventEntity.setEventId(11);
        eventEntity.setProduct("wolong");


        byte[] bytes = objectToByteArray(eventEntity);

        System.out.println("object to bytes: " + bytes);

        Object o = byteArrayToObject(bytes);
        System.out.println("object: " + o);


        System.out.println(o instanceof Event);
        System.out.println(o instanceof ChargeEvent);
        System.out.println(o instanceof ChargeEventEntity);
        System.out.println(o instanceof BudgetEvent);
    }

    public static Object byteArrayToObject(byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    public static byte[] objectToByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return bytes;
    }

}
