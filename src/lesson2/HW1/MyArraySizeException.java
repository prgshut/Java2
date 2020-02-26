package lesson2.HW1;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
        System.out.println("Введен неверный размер массива!! Введите заного!");
    }
}
