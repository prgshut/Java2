package lesson3.HW1;

import java.util.*;

public class ArrayDublOff {
    public static void main(String[] args) {
        String[] str = {"Бирка", "Бурдюк", "Кризис", "Карма", "Бумага",
                "Бирка", "Парад", "Выдра", "Орел", "Зима", "Зума",
                "Орел", "Кризис", "Парад", "Бирка"};
        dublOff(str);
        dublCount(str);
    }

    private static void dublCount(String[] str) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : str) {
            map.put(s, 0);
        }
        Integer a;
        for (String ar : str) {
            a = map.get(ar).intValue() + 1;
            map.put(ar, a);
        }
        System.out.println(map);
    }

    private static void dublOff(String[] str) {
        Set<String> stringSet = new LinkedHashSet<>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            stringSet.add(s);
        }
        System.out.println(stringSet);
//        System.out.println(stringSet);
//        for (String st:
//             stringSet) {
//            System.out.println(st);
//
//        }
//        Iterator<String> stringIterator = stringSet.iterator();
//        String s;
//        while (stringIterator.hasNext()){
//             s =stringIterator.next();
//            System.out.println(s);
//
//        }
    }
}
