package com.example.demo.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileApplicationTests {

    @Test
    public void contextLoads() {
        String a1 = "a",b1 = "b";
        String c1 = "a" + "b",c2 = "ab",c3 = a1 + b1;
        String h1 = "Hello";
        String h2 = "Hello";
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        System.out.println("c3:" + c3);
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2.equals(c3));
        System.out.println(h1 == h2);
        System.out.println(h1.equals(h2));
    }

    @Test
    public void split(){
        //字符串末尾的分隔符不能识别
        int i = "sn\\\\|sn\\".split("\\\\|sn").length;
        String[] arr = "sn\\\\|sn\\".split("\\\\|sn");
        String[] arr1 = "andoruu=?orn=?andor".split("and|or");
        List<String> list = Arrays.asList(arr);
        List<String> list1 = Arrays.asList(arr1);
        System.out.println(list);
        System.out.println(i);
        System.out.println(list1);
    }

    @Test
    public void choose(){
        //如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
       int i =9;
       switch (i){
           default:
               System.out.println("default");
           case 1:
               System.out.println("1");
               break;
           case 2:
               System.out.println("2");
           case 3:
               System.out.println("3");
       }
    }

    @Test
    public void test1(){

    }

}
