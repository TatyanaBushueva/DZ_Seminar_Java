
import java.util.Scanner;
import java.time.LocalTime;


public class DZ1{
    public static void main(String[] args) {
        System.out.println("Результат выполнения первого задания"); 
        doTask1(2, 3);
        int[] array = new int[] { 1, 2, 3, 4, 5 }; 
        System.out.println();
        System.out.println("\nРезультат выполнения второго задания");
        doTask2(array);
        System.out.println("\nРезультат выполнения третьего задания");
        doTask3();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("\nЗадание четвертое");
        System.out.printf("Введите имя: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        doTask4(name);
        iScanner.close();
        System.out.println("Исходный массив"); 
        int[] array2 = new int[] { 1, 2, 3, 4, 5 };       
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+ " ");
        }
        System.out.println("\nМассив со сдвигом"); 
        doTask5(array2, 2);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+ " ");
        }
    }
    

    // 1. Написать метод, принимающий на вход два аргумента: len и initialValue, 
    // и возвращающий одномерный массив типа int длиной len, 
    // каждая ячейка которого равна initialValue;

    public static void doTask1(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }

    // 2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static void doTask2( int[] arr){
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }


// 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), 
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами 
// (можно только одну из диагоналей, если обе сложно). 
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, 
// то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void doTask3() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



// 4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
// "Доброе утро, <Имя>!", если время от 05:00 до 11:59
// "Добрый день, <Имя>!", если время от 12:00 до 17:59;
// "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
// "Доброй ночи, <Имя>!", если время от 23:00 до 4:59


public static void doTask4(String args) {
    
    LocalTime timeObject;
    timeObject = LocalTime.now();
    double hh = timeObject.getHour();
    double mm = timeObject.getMinute();
    // double hh = 23;
    // double mm = 19;
    double tv = hh + mm / 60;  
    String st = "";    
    if (tv > 5 && tv <= 11.98)  {
        st = "ое утро";
    }
    else if (tv > 12 && tv <= 17.98) {
        st = "ый день";
    }
    else if (tv > 18 && tv <= 22.98) {
        st = "ый вечер";
    }
    else {
        st = "ой ночи";
    }
    System.out.println("Сейчас " + timeObject);
    System.out.printf("Добр%s, %s!\n", st, args);

}


// 5.** Написать метод, которому на вход подается одномерный массив и число n 
// (может быть положительным, или отрицательным), при этом метод должен сместить 
// все элементы массива на n позиций. Элементы смещаются циклично. 
// Для усложнения задачи нельзя пользоваться вспомогательными массивами. 
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] 
// при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. 
// При каком n в какую сторону сдвиг можете выбирать сами.

// Чего то тут ничего не работает

public static int[] doTask5(int[] arr, int shift) {
    if (shift > 0) {
        for (int s = 1; s <= shift; s++) {
            int elemshift = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = elemshift;
        }
    } else if (shift < 0) {
        for (int s = shift; s <= -1; s++) {
            int elemshift = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = elemshift;
        }
    }
    return arr;
}
}
    