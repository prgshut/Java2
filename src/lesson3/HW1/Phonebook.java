package lesson3.HW1;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {
    private static Map<String, String> phone = new TreeMap<>();

    public void add(String phone, String fullName) {
        this.phone.put(phone, fullName);
    }

    public void get(String fullName) {
        for (Map.Entry s : phone.entrySet()) {
            if (fullName.equals(s.getValue())) {
                System.out.println(s.getKey() + " " + s.getValue());
            }
        }
//       for (String s : phone.values()) {
//           if (fullName.equals(s)){
//               System.out.println(phone.g);
//           }
//       }

    }
}
