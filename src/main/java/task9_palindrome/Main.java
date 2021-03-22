package task9_palindrome;

/*
9. Палиндром
Проверить является ли число или его часть палиндромом.
Например, число 1234437 не является палиндромом,
но является палиндромом его часть 3443.
Числа меньшие, чем 10 палиндромом не считать.

Входные параметры: число
Выход: извлечённый из числа палиндром либо 0, если извлечение не удалось.
 */

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //getInt("Input a number: ");
        System.out.print("Input a number: ");
        Palindrome palindrome = new Palindrome(scanner.next());
        System.out.println(palindrome.getPalindromes());
        //isNumeric? exceptions?
    }

    private static int getInt(String msg){
        System.out.print(msg);
        while(true) {
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }
            scanner.next();
        }
    }

}
