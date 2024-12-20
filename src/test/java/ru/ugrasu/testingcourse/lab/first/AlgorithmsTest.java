package ru.ugrasu.testingcourse.lab.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlgorithmsTest {

    private final Algorithms algorithms = new Algorithms();

    @Nested
    @DisplayName("1. Тесты сортировки")
    class SortTest {

        @Test
        @DisplayName("Дан валидный несортированный массив — возвращается отсортированный массив")
        public void givenValidUnsortedLongArray_whenSort_thenReturnsSortedLongArray() {
            long[] validUnsortedArray = {10, 1, 5, 6};

            long[] sorted = algorithms.sort(validUnsortedArray);

            assertThat(sorted).isSorted();
        }

        @Test
        @DisplayName("Дан валидный отсортированный массив — возвращается отсортированный массив")
        public void givenValidSortedLongArray_whenSort_thenReturnsSortedLongArray() {
            long[] validUnsortedArray = {1, 2, 3, 4};

            long[] sorted = algorithms.sort(validUnsortedArray);

            assertThat(sorted).isSorted();
        }

        @Test
        @DisplayName("Дан пустой массив — возвращается пустой массив")
        public void givenEmptyArray_whenSort_thenReturnsEmptyArray() {
            long[] validUnsortedArray = {};

            long[] sorted = algorithms.sort(validUnsortedArray);

            assertThat(sorted).isEmpty();
        }

        @Test
        @DisplayName("Дан null — выбрасывается IllegalArgumentException")
        public void givenNull_whenSort_thenThrowsNullPointerException() {
            assertThatThrownBy(() -> algorithms.sort(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("2. Тесты проверки на палиндром")
    class PalindromeTest {

        @Test
        @DisplayName("Дана валидная строка палиндром — возвращается true")
        public void givenValidPalindromeString_whenChecked_thenReturnsTrue() {
            String palindrome = "абба";

            boolean isPalindrome = algorithms.isPalindrome(palindrome);

            assertThat(isPalindrome).isTrue();
        }

        @Test
        @DisplayName("Дана валидная строка не палиндром — возвращается false")
        public void givenValidNonPalindromeString_whenChecked_thenReturnsFalse() {
            String nonPalindrome = "текст";

            boolean isPalindrome = algorithms.isPalindrome(nonPalindrome);

            assertThat(isPalindrome).isFalse();
        }

        @Test
        @DisplayName("Дана пустая строка — возвращается true (пустая строка считается палиндромом)")
        public void givenEmptyString_whenChecked_thenReturnsTrue() {
            String emptyString = "";

            boolean isPalindrome = algorithms.isPalindrome(emptyString);

            assertThat(isPalindrome).isTrue();
        }

        @Test
        @DisplayName("Дана строка из одного символа — возвращается true")
        public void givenSingleCharString_whenChecked_thenReturnsTrue() {
            String singleChar = "a";

            boolean isPalindrome = algorithms.isPalindrome(singleChar);

            assertThat(isPalindrome).isTrue();
        }

        @Test
        @DisplayName("Дан null — выбрасывается IllegalArgumentException")
        public void givenNull_whenChecked_thenThrowsNullPointerException() {
            assertThatThrownBy(() -> algorithms.isPalindrome(null))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("3. Тесты факториала")
    class FactorialTest {

        @Test
        @DisplayName("Дан 1 — возвращается 1 ")
        public void givenOne_whenFactorialCalled_thenReturnsOne() {
            long result = algorithms.factorialOf(1);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан 5 — возвращается 120 (факториал 5 равен 120)")
        public void givenFive_whenFactorialCalled_thenReturnsHundredTwenty() {
            long result = algorithms.factorialOf(5);
            assertThat(result).isEqualTo(120);
        }

        @Test
        @DisplayName("Дан 20 — возвращается 2_432_902_008_176_640_000 (факториал 20)")
        public void givenThirtyNine_whenFactorialCalled_thenReturnsCorrectResult() {
            long result = algorithms.factorialOf(20);
            assertThat(result).isEqualTo(2_432_902_008_176_640_000L);
        }

        @Test
        @DisplayName("Дан 40 — выбрасывается IllegalArgumentException")
        public void givenForty_whenFactorialCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.factorialOf(21))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан -1 — выбрасывается IllegalArgumentException")
        public void givenNegativeOne_whenFactorialCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.factorialOf(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("4. Тесты вычисления числа Фибоначчи")
    class FibonacciTest {

        @Test
        @DisplayName("Дан 1 — возвращается 1 (фибоначчи на позиции 1 равен 1)")
        public void givenPositionOne_whenFibonacciCalled_thenReturnsOne() {
            long result = algorithms.fibonachiByPosition(1);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан 2 — возвращается 1 (фибоначчи на позиции 2 равен 1)")
        public void givenPositionTwo_whenFibonacciCalled_thenReturnsOne() {
            long result = algorithms.fibonachiByPosition(2);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан 3 — возвращается 2 (фибоначчи на позиции 3 равен 2)")
        public void givenPositionThree_whenFibonacciCalled_thenReturnsTwo() {
            long result = algorithms.fibonachiByPosition(3);
            assertThat(result).isEqualTo(2);
        }

        @Test
        @DisplayName("Дан 10 — возвращается 55 (фибоначчи на позиции 10 равен 55)")
        public void givenPositionTen_whenFibonacciCalled_thenReturnsFiftyFive() {
            long result = algorithms.fibonachiByPosition(10);
            assertThat(result).isEqualTo(55);
        }

        @Test
        @DisplayName("Дан 20 — возвращается 6765 (фибоначчи на позиции 20 равен 6765)")
        public void givenPositionTwenty_whenFibonacciCalled_thenReturnsSixThousandSevenHundredSixtyFive() {
            long result = algorithms.fibonachiByPosition(20);
            assertThat(result).isEqualTo(6765);
        }

        @Test
        @DisplayName("Дано 92 — возвращается 7540113804746346429")
        public void givenPositionNinetyTwo_whenFibonacciCalled_thenReturnsCorrectValue() {
            long result = algorithms.fibonachiByPosition(92);
            assertThat(result).isEqualTo(7540113804746346429L);
        }

        @Test
        @DisplayName("Дан -1 — выбрасывается IllegalArgumentException")
        public void givenNegativeOne_whenFibonacciCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.fibonachiByPosition(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дано 93 — выбрасывается IllegalArgumentException")
        public void givenPositionNinetyThree_whenFibonacciCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.fibonachiByPosition(93))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("5. Тесты поиска подстроки в строке")
    class SearchKeywordTest {

        @Test
        @DisplayName("Дан текст и ключевое слово, которое есть в тексте — возвращается индекс первого вхождения")
        public void givenTextWithKeyword_whenSearchKeywordCalled_thenReturnsFirstOccurrenceIndex() {
            String text = "Это тестовый текст для тестирования.";
            String keyword = "тест";
            int index = algorithms.searchKeywordInText(text, keyword);
            assertThat(index).isEqualTo(5);
        }

        @Test
        @DisplayName("Дан текст и ключевое слово, которого нет в тексте — возвращается -1")
        public void givenTextWithoutKeyword_whenSearchKeywordCalled_thenReturnsMinusOne() {
            String text = "Это тестовый текст для тестирования.";
            String keyword = "не найдено";
            int index = algorithms.searchKeywordInText(text, keyword);
            assertThat(index).isEqualTo(-1);
        }

        @Test
        @DisplayName("Дан текст, который совпадает с ключевым словом — возвращается 0")
        public void givenTextEqualsKeyword_whenSearchKeywordCalled_thenReturnsZero() {
            String text = "Совпадает";
            String keyword = "Совпадает";
            int index = algorithms.searchKeywordInText(text, keyword);
            assertThat(index).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан текст, который по длине меньше ключевого слова — возвращается -1")
        public void givenTextLengthLessKeywordLength_whenSearchKeywordCalled_thenReturnsMinusOne() {
            String text = "123";
            String keyword = "123456";
            int index = algorithms.searchKeywordInText(text, keyword);
            assertThat(index).isEqualTo(-1);
        }

        @Test
        @DisplayName("Дан текст с несколькими вхождениями ключевого слова — возвращается индекс первого вхождения")
        public void givenTextWithMultipleKeywords_whenSearchKeywordCalled_thenReturnsFirstOccurrenceIndex() {
            String text = "тест тест тест";
            String keyword = "тест";
            int index = algorithms.searchKeywordInText(text, keyword);
            assertThat(index).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан null в качестве текста — выбрасывается IllegalArgumentException")
        public void givenNullText_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText(null, "ключевое слово"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан null в качестве ключевого слова — выбрасывается IllegalArgumentException")
        public void givenNullKeyword_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("текст", null))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан пустой текст и пустое ключевое слово — выбрасывается IllegalArgumentException")
        public void givenEmptyTextAndEmptyKeyword_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("", ""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан текст и пустое ключевое слово — выбрасывается IllegalArgumentException")
        public void givenTextAndEmptyKeyword_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("Текст", ""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан пустой текст и ключевое слово — выбрасывается IllegalArgumentException")
        public void givenEmptyTextAndKeyword_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("", "ключевое слово"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан текст и ключевое слово, равные пробелам — выбрасывается IllegalArgumentException")
        public void givenTextAndKeywordWithSpaces_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("   ", "   "))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан ключевое слово из пробелов — выбрасывается IllegalArgumentException")
        public void givenTextWithSpacesAndEmptyKeyword_whenSearchKeywordCalled_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.searchKeywordInText("Текст", "   "))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("6. Тесты проверки на простое число")
    class PrimeNumberTest {

        @Test
        @DisplayName("Дан 2 — возвращается true (2 — простое число)")
        public void givenTwo_whenChecked_thenReturnsTrue() {
            boolean result = algorithms.isPrime(2);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Дан 3 — возвращается true (3 — простое число)")
        public void givenThree_whenChecked_thenReturnsTrue() {
            boolean result = algorithms.isPrime(3);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Дан 4 — возвращается false (4 — не простое число)")
        public void givenFour_whenChecked_thenReturnsFalse() {
            boolean result = algorithms.isPrime(4);
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("Дан 5 — возвращается true (5 — простое число)")
        public void givenFive_whenChecked_thenReturnsTrue() {
            boolean result = algorithms.isPrime(5);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Дан -1 — выбрасывается IllegalArgumentException")
        public void givenNegativeOne_whenChecked_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.isPrime(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан 0 — выбрасывается IllegalArgumentException")
        public void givenZero_whenChecked_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.isPrime(0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дан 1 — выбрасывается IllegalArgumentException")
        public void givenOne_whenChecked_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.isPrime(1))
                    .isInstanceOf(IllegalArgumentException.class);
        }


        @Test
        @DisplayName("Дан 13 — возвращается true (13 — простое число)")
        public void givenThirteen_whenChecked_thenReturnsTrue() {
            boolean result = algorithms.isPrime(13);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("Дан 100 — возвращается false (100 — не простое число)")
        public void givenOneHundred_whenChecked_thenReturnsFalse() {
            boolean result = algorithms.isPrime(100);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("7. Тесты реверсирования целого числа")
    class ReverseIntegerTest {

        @Test
        @DisplayName("Дан 123 — возвращается 321")
        public void givenPositiveInteger_whenReversed_thenReturnsReversed() {
            int result = algorithms.reverseInteger(123);
            assertThat(result).isEqualTo(321);
        }

        @Test
        @DisplayName("Дан -120 — возвращается -21")
        public void givenNegativeInteger_whenReversed_thenReturnsReversed() {
            int result = algorithms.reverseInteger(-120);
            assertThat(result).isEqualTo(-21);
        }

        @Test
        @DisplayName("Дан 0 — возвращается 0")
        public void givenZero_whenReversed_thenReturnsZero() {
            int result = algorithms.reverseInteger(0);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("Дан 1000 — возвращается 1")
        public void givenIntegerWithTrailingZeros_whenReversed_thenReturnsExpected() {
            int result = algorithms.reverseInteger(1000);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Дан 1534236469 — возвращается 0 (переполнение)")
        public void givenOverflowInteger_whenReversed_thenReturnsZero() {
            int result = algorithms.reverseInteger(1534236469);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("Дан -2147483648 — возвращается 0 (переполнение)")
        public void givenMinInt_whenReversed_thenReturnsZero() {
            int result = algorithms.reverseInteger(-2147483648);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("Дан 1463847413 — возвращается 0 (переполнение)")
        public void givenMaxInt_whenReversed_thenReturnsZero() {
            int result = algorithms.reverseInteger(1463847413);
            assertThat(result).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("8. Тесты преобразования в римскую систему")
    class ConvertToRomanTest {

        @Test
        @DisplayName("Дано 1 — возвращается 'I'")
        public void givenOne_whenConverted_thenReturnsI() {
            String result = algorithms.convertToRoman(1);
            assertThat(result).isEqualTo("I");
        }

        @Test
        @DisplayName("Дано 4 — возвращается 'IV'")
        public void givenFour_whenConverted_thenReturnsIV() {
            String result = algorithms.convertToRoman(4);
            assertThat(result).isEqualTo("IV");
        }

        @Test
        @DisplayName("Дано 9 — возвращается 'IX'")
        public void givenNine_whenConverted_thenReturnsIX() {
            String result = algorithms.convertToRoman(9);
            assertThat(result).isEqualTo("IX");
        }

        @Test
        @DisplayName("Дано 58 — возвращается 'LVIII'")
        public void givenFiftyEight_whenConverted_thenReturnsLVIII() {
            String result = algorithms.convertToRoman(58);
            assertThat(result).isEqualTo("LVIII");
        }

        @Test
        @DisplayName("Дано 1994 — возвращается 'MCMXCIV'")
        public void givenNineteenNinetyFour_whenConverted_thenReturnsMCMXCIV() {
            String result = algorithms.convertToRoman(1994);
            assertThat(result).isEqualTo("MCMXCIV");
        }

        @Test
        @DisplayName("Дано 3999 — возвращается 'MMMCMXCIX'")
        public void givenThreeThousandNineHundredNinetyNine_whenConverted_thenReturnsMMMCMXCIX() {
            String result = algorithms.convertToRoman(3999);
            assertThat(result).isEqualTo("MMMCMXCIX");
        }

        @Test
        @DisplayName("Дано 0 — выбрасывается IllegalArgumentException")
        public void givenZero_whenConverted_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.convertToRoman(0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дано -1 — выбрасывается IllegalArgumentException")
        public void givenNegativeOne_whenConverted_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.convertToRoman(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Дано 4000 — выбрасывается IllegalArgumentException")
        public void givenFourThousand_whenConverted_thenThrowsIllegalArgumentException() {
            assertThatThrownBy(() -> algorithms.convertToRoman(4000))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
