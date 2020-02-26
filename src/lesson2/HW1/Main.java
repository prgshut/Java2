package lesson2.HW1;

import java.util.Scanner;

public class Main {
    private static String[][] ar;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isTrye = false;
        do {
            arrayCreation();
            try {
                arraySize();
                isTrye = true;
            } catch (MyArraySizeException e) {
                System.out.println("Введите заного размер масива");
            }
        } while (!isTrye);
        arrayFilling();
        arraySum();

    }

    private static void arraySum() {
        int sumArray = 0;
        for (String[] strings : ar) {
            for (String string : strings) {
                try {
                    sumArray += fornatException(string);
                } catch (MyArrayDataException e) {
                    System.out.println("Элемент масива " + string + "не является число");
                    //  throw new MyArrayDataException("error");
                }
            }
        }
        System.out.println("Сумма всех элементов массива равна: "+ sumArray);
    }

    private static int fornatException(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(string);
        }
    }

    private static void arrayFilling() {
        scanner.nextLine();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.printf("Введите значение ячейки [%d][%d] ", i, j);
                ar[i][j] = scanner.nextLine();
            }
        }
    }

    private static void arrayCreation() {
        System.out.print("Введие количество колонок 4: ");
        int col = scanner.nextInt();
        System.out.print("\nВведие количество строк 4: ");
        int row = scanner.nextInt();
        ar = new String[col][row];
    }

    private static void arraySize() {
        if (ar.length != 4 || ar[0].length != 4) {
            throw new MyArraySizeException();
        }

    }
}
