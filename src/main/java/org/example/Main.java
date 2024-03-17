package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[] numbers = new double[15];
        //Наполнем массив дробными случайными числами
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            if (i < 2) {
                //Первые два числа положительные
                numbers[i] = random.nextDouble() * 100; //генерируем случайное положительное число
            } else {
                //Остальные числа могут быть как положительными так и отрицательными
                numbers[i] = random.nextDouble() * 200 - 100; //генерируем случайное число от -100 до 100
            }
        }


        //находим среднее арифметическое положительных чисел после  первого отрицательного числа
        boolean negative = false;
        double sum = 0;
        int count = 0;
        for (double number : numbers) {
            if (negative && number > 0) {
                sum += number;
                count++;
            }
            if (!negative && number < 0) {
                negative = true;
            }
        }
        //проверка, чтобы избежать деления на ноль
        double average = count > 0 ? sum / count : 0;

        //выводим результат на экран
        System.out.println("Массив чисел: ");
        for (double number : numbers) {
            System.out.println(number + " ");

        }
        System.out.println("\nСреднее арифметическое положительных чисел после первого отрицательного числа: " + average);

    }
}
