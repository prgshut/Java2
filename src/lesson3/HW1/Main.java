package lesson3.HW1;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("111111", "QQQQQQQQ");
        phonebook.add("222222", "WWWWWWWW");
        phonebook.add("333333", "WWWWWWWW");
        phonebook.add("444444", "q");
        phonebook.add("555555", "q");
        phonebook.add("666666", "WWWWWWWWWW");
        phonebook.add("777777", "3333");
        phonebook.add("999999", "ddddd");
        phonebook.add("888888", "QQQQdddQQQQ");
        phonebook.add("100000", "dd");
        phonebook.get("q");
        phonebook.get("WWWWWWWW");
    }
}
