package com.doctor_ew.pojo_generator;

import com.doctor_ew.pojo_generator.Enumerations.ResultEnum;
import org.apache.commons.lang3.ClassUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class GeneratePojo {

    private Random rand = new Random();

    public Object generateNewInstance(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
//            if (Collection.class.isAssignableFrom(field.getType())) {
//                try {
//                    field.set(obj, newCollection(field));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
            if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType() == String.class) {
                try {
                    field.set(obj, putFakeValueInPrimitiveField(field));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Object nestedObject = new Object();
                    nestedObject = generateNewInstance(field.getType().newInstance());
                    field.set(obj, nestedObject);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    public Object putFakeValueInPrimitiveField(Field field) {
        if(field.getType().isAssignableFrom(Byte.class) ||
                field.getType().isAssignableFrom(byte.class)) {
            byte[] newBytes = new byte[1];
            rand.nextBytes(newBytes);
            return newBytes;
        }
        if(field.getType().isAssignableFrom(Short.class) ||
                field.getType().isAssignableFrom(short.class)) {
            return (short)rand.nextInt();
        }
        if(field.getType().isAssignableFrom(Integer.class) ||
                field.getType().isAssignableFrom(int.class)) {
            return rand.nextInt();
        }
        if(field.getType().isAssignableFrom(Long.class) ||
                field.getType().isAssignableFrom(long.class)) {
            return rand.nextLong();
        }
        if(field.getType().isAssignableFrom(Float.class) ||
                field.getType().isAssignableFrom(float.class)) {
            return rand.nextFloat();
        }
        if(field.getType().isAssignableFrom(Double.class) ||
                field.getType().isAssignableFrom(double.class)) {
            return rand.nextDouble();
        }
        if(field.getType().isAssignableFrom(Boolean.class) ||
                field.getType().isAssignableFrom(boolean.class)) {
            return rand.nextBoolean();
        }
        if(field.getType().isAssignableFrom(Character.class) ||
                field.getType().isAssignableFrom(char.class)) {
            String chars = "1234567890-=!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>?";
            return chars.charAt(rand.nextInt(chars.length()));
        }
        if(field.getType().isAssignableFrom(String.class)) {
            List<String> words;
            StringBuilder randomWords = new StringBuilder();
            try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/en.txt"))) {
                words = lines.collect(Collectors.toList());

                int numberOfWords = rand.nextInt(6);
                for(int i = 1; i < numberOfWords; i ++) {
                    randomWords.append(words.get(rand.nextInt(words.size()))).append(" ");
                }
                randomWords.trimToSize();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return randomWords.toString();
        }
        return ResultEnum.FAILED;
    }

//    public Object newCollection(Field field) {
//        Object collection = null;
//        try {
//            collection = field.getType().newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return collection;
//    }
}
