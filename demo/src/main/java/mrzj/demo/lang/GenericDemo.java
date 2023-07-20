package mrzj.demo.lang;

import java.util.ArrayList;

public class GenericDemo {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
    }

}
