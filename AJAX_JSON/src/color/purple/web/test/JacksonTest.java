package color.purple.web.test;

import color.purple.web.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class JacksonTest {
    // java对象转JSON字符串
    @Test
    public void test1() throws Exception {
        // 创建对象
        Person p = new Person();
        p.setAge(15);
        p.setGender(true);
        p.setName("alice");

        // 2 创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换
        /**
         * 转换方法:
         *      writeValue(参数1 , obj)
         *          参数1:
         *              File: 将object对象转换为json字符串,保存到指定的文件中
         *              Writer: 将object对象转换为json字符串,并将json数据填充到字符输出流中
         *              OutputStream: 将object对象转换为json字符串 ,并将json数据填充到字节输出流中
         *      writeValueString(obj) : 将obj对象转换为json字符串
         */

        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        File aliceFile = new File("d://alice.txt");
        if (aliceFile.exists()) {
            aliceFile.createNewFile();
        }

        mapper.writeValue(aliceFile, p);

    }

    @Test
    public void test2() throws Exception {
        // 创建对象
        Person p = new Person();
        p.setAge(15);
        p.setGender(true);
        p.setName("alice");
        p.setBirthday(new Date());

        // 2 创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换
        /**
         * 转换方法:
         *      writeValue(参数1 , obj)
         *          参数1:
         *              File: 将object对象转换为json字符串,保存到指定的文件中
         *              Writer: 将object对象转换为json字符串,并将json数据填充到字符输出流中
         *              OutputStream: 将object对象转换为json字符串 ,并将json数据填充到字节输出流中
         *      writeValueString(obj) : 将obj对象转换为json字符串
         */

        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        File aliceFile = new File("d://alice.txt");
        if (aliceFile.exists()) {
            aliceFile.createNewFile();
        }

        mapper.writeValue(aliceFile, p);

    }

    @Test
    public void test3() throws Exception {
        // 创建对象
        Person p1 = new Person();
        p1.setAge(15);
        p1.setGender(true);
        p1.setName("alice");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setAge(15);
        p2.setGender(true);
        p2.setName("alice");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setAge(15);
        p3.setGender(true);
        p3.setName("alice");
        p3.setBirthday(new Date());

        Person p4 = new Person();
        p4.setAge(15);
        p4.setGender(true);
        p4.setName("alice");
        p4.setBirthday(new Date());

        List<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        // 2 创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换
        /**
         * 转换方法:
         *      writeValue(参数1 , obj)
         *          参数1:
         *              File: 将object对象转换为json字符串,保存到指定的文件中
         *              Writer: 将object对象转换为json字符串,并将json数据填充到字符输出流中
         *              OutputStream: 将object对象转换为json字符串 ,并将json数据填充到字节输出流中
         *      writeValueString(obj) : 将obj对象转换为json字符串
         */

        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
        File aliceFile = new File("d://alice.txt");
        if (aliceFile.exists()) {
            aliceFile.createNewFile();
        }

        mapper.writeValue(aliceFile, ps);

    }

    @Test
    public void test4() throws Exception {
        Map<String , Object> aliceMap = new HashMap<>();
        int age[] = {12,14,15,16};
        aliceMap.put("name","alice");
        aliceMap.put("age",age);
        aliceMap.put("gender",true);
        aliceMap.put("birthday",new Date());



        // 2 创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换
        /**
         * 转换方法:
         *      writeValue(参数1 , obj)
         *          参数1:
         *              File: 将object对象转换为json字符串,保存到指定的文件中
         *              Writer: 将object对象转换为json字符串,并将json数据填充到字符输出流中
         *              OutputStream: 将object对象转换为json字符串 ,并将json数据填充到字节输出流中
         *      writeValueString(obj) : 将obj对象转换为json字符串
         */

        String json = mapper.writeValueAsString(aliceMap);
        System.out.println(json);
        File aliceFile = new File("d://alice.txt");
        if (aliceFile.exists()) {
            aliceFile.createNewFile();
        }

        mapper.writeValue(aliceFile, aliceMap);
    }

    // 演示 json字符串转为java对象
    @Test
    public void test5() throws Exception {
        // 1 初始化json字符串
        String json = "{\"age\":15,\"name\":\"alice\",\"gender\":true,\"birthday\":\"2020-08-01\"}";
        // 2 创建 objectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换为java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
