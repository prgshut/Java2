package lesson2.HW1;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String s) {
        System.out.println("Не является числом " + s);
    }
}
