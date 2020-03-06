package lesson5.HW1;

import java.util.Arrays;


public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        filing(arr);
        System.out.println("Time run: " + (System.currentTimeMillis() - a));
        a = System.currentTimeMillis();
        float[] ar1, ar2;
        ar1 = new float[h];
        ar2 = new float[h];
        System.arraycopy(arr, 0, ar1, 0, h);
        System.arraycopy(arr, h, ar2, 0, h);
        Thread thread = new Thread(() -> filing(ar1));
        Thread thread1 = new Thread(() -> filing(ar2));
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.arraycopy(ar1, 0, arr, 0, h);
        System.arraycopy(ar2, 0, arr, h, h);
        System.out.println("Time run: " + (System.currentTimeMillis() - a));

        //        ------------------------------------------------------------------
        a = System.currentTimeMillis();
        float[] arr1, arr2, arr3, arr4;
        arr1 = new float[h / 2];
        arr2 = new float[h / 2];
        arr3 = new float[h / 2];
        arr4 = new float[h / 2];
        System.arraycopy(arr, 0, arr1, 0, h / 2);
        System.arraycopy(arr, h / 2, arr2, 0, h / 2);
        System.arraycopy(arr, h, arr3, 0, h / 2);
        System.arraycopy(arr, (3 * h) / 4, arr4, 0, h / 2);
        Thread thread3 = new Thread(() -> filing(arr1));
        Thread thread4 = new Thread(() -> filing(arr2));
        Thread thread5 = new Thread(() -> filing(arr3));
        Thread thread6 = new Thread(() -> filing(arr4));
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        System.arraycopy(arr1, 0, arr, 0, h / 2);
        System.arraycopy(arr2, 0, arr, h / 2, h / 2);
        System.arraycopy(arr3, 0, arr, h, h / 2);
        System.arraycopy(arr4, 0, arr, (3 * h) / 4, h / 2);
        System.out.println("Time run: " + (System.currentTimeMillis() - a));
    }

    private static void filing(float[] arr) {

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }

    }

}