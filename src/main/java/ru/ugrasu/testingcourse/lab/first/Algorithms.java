package ru.ugrasu.testingcourse.lab.first;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.lang.Math.*;

public class Algorithms {

    /**
     * 1. Функцию выполняющую сортировку(любым алгоритмом на выбор) массива целых чисел.
     *
     * @param array Не отсортированный массив
     * @return Отсортированный массив
     * @throws IllegalArgumentException Если массив null
     */
    public long[] sort(long[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }

        long[] newArray = Arrays.copyOf(array, array.length);
        heapSort(newArray);
        return newArray;
    }

    private void heapSort(long[] array) {

        int mid = array.length / 2;

        for (int i = mid - 1; i >= 0; i--) {
            heapSort(array, array.length, i);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapSort(array, i, 0);
        }
    }

    private void heapSort(long[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapSort(array, n, largest);
        }
    }

    private void swap(long[] array, int first, int second) {
        long temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * 2. Функцию, которая проверяет является ли введенная строка палиндромом.
     *
     * @param line Введенная строка
     * @return true, если строка палиндром, иначе false
     * @throws IllegalArgumentException Если строка null
     */
    public boolean isPalindrome(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Строка не должен быть null");
        }
        String reverseLine = new StringBuilder(line)
                .reverse()
                .toString();
        return reverseLine.equals(line);
    }

    /**
     * 3. Функцию выполняющую вычисление факториала для целого числа.
     *
     * @param n Целое число для вычисления факториала
     * @return Значение факториала числа n
     * @throws IllegalArgumentException Если n меньше 1 или больше 20
     */
    public long factorialOf(int n) {
        if (n < 1 || n > 20) {
            throw new IllegalArgumentException("Факториал вычисляется в пределах от 1 до 20");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * 4. Функцию, которая возвращает число Фибоначчи на указанной позиции.
     *
     * @param position Позиция числа Фибоначчи
     * @return Число Фибоначчи на указанной позиции
     * @throws IllegalArgumentException Если позиция меньше еденицы или больше 92
     */
    public long fibonachiByPosition(int position) {
        if (position < 1 || position > 92) {
            throw new IllegalArgumentException("Позиция не может быть меньше еденицы или больше 92.");
        }

        if (position <= 2) {
            return 1;
        }
        long a = 1;
        long b = a;
        long result = 0;
        for (int i = 2; i < position; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    /**
     * 5. Функцию, выполняющую поиск подстроки в строке.
     *
     * @param text    Текст, в котором выполняется поиск
     * @param keyword Подстрока для поиска
     * @return Индекс первого вхождения подстроки, или -1, если не найдено
     * @throws IllegalArgumentException Если текст или подстрока null или пустыми
     */
    public int searchKeywordInText(String text, String keyword) {
        if (text == null || text.isBlank() || keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Не должны быть null или пустыми");
        }
        char[] line = text.toCharArray();
        char[] subLine = keyword.toCharArray();
        return kmpSearch(line, subLine);
    }

    private int kmpSearch(char[] line, char[] subline) {
        int[] prefixFunc = getPrefixFunc(subline);
        int i = 0;
        int j = 0;

        while (i < line.length) {
            if (subline[j] == line[i]) {
                j++;
                i++;
            }
            if (j == subline.length) {
                return i - j + 1;
            } else if (i < line.length && subline[j] != line[i]) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    private int[] getPrefixFunc(char[] subLine) {
        int[] prefixFunc = new int[subLine.length];
        for (int i = 1; i < subLine.length; i++) {
            int j = 0;
            while (i + j < subLine.length && subLine[i] == subLine[i + j]) {
                prefixFunc[i + j] = max(prefixFunc[i + j], j + 1);
                j++;
            }
        }
        return prefixFunc;
    }

    /**
     * 6. Функцию, проверяющую является ли число простым.
     *
     * @param number Проверяемое число
     * @return true, если число простое, иначе false
     * @throws IllegalArgumentException Если меньше еденицы
     */
    public boolean isPrime(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Простым может быть только число больше 1");
        }
        double sqrtOfNumber = sqrt(number);
        for (int i = 2; i <= sqrtOfNumber; i++) {
            if (sqrtOfNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 7. Функцию, которая принимает целое 32-битное число х, и возвращает это число с цифрами в обратном порядке.
     * Например, для 123 возвращается 321; для -120 возвращается -21. Если число х после инверсии превышает
     * размер 32 бит, то тогда следует вернуть 0.
     *
     * @param integer Целое 32-битное число для реверсирования
     * @return Число с цифрами в обратном порядке
     */
    public int reverseInteger(int integer) {
        boolean isNegative = integer < 0;
        int reversedInteger = 0;
        integer = abs(integer);
        while (integer > 0) {
            int lastDigit = integer % 10;
            if (reversedInteger > (Integer.MAX_VALUE - lastDigit) / 10) {
                return 0;
            }
            reversedInteger = reversedInteger * 10 + lastDigit;
            integer /= 10;
        }
        return reversedInteger * (isNegative ? -1 : 1);
    }

    /**
     * 8. Функцию, которая принимает целое число x и возвращает это число в римской системе счисления.
     *
     * @param number Целое число для преобразования в римскую систему
     * @return Римское представление числа
     * @throws IllegalArgumentException Если число отрицательное или больше 3999
     */
    public String convertToRoman(long number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 3999.");
        }
        StringBuilder roman = new StringBuilder();
        Roman[] romans = Roman.values();
        for (int i = 0; i < romans.length; i++) {
            while (number >= romans[i].years) {
                roman.append(romans[i]);
                number -= romans[i].years;
            }
        }

        return roman.toString();
    }

    @RequiredArgsConstructor
    private enum Roman {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);
        private final int years;
    }
}
