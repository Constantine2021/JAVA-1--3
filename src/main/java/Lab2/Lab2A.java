package Lab2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Lab2A {


    public void doTheTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of numbers: ");
        int amountNumbers = scanner.nextInt();
        Integer[] numbers = new Integer[amountNumbers];
        for (int i = 0; i < amountNumbers; i++){
            System.out.print("Enter " + (i + 1) + " element: ");
            numbers[i] = scanner.nextInt();
        }

        Integer[] sortedDigits = this.sortByDigitLength(numbers);

        StringBuilder message = new StringBuilder("sorted: ");
        for (Integer digit: sortedDigits){
            message.append(digit.toString()).append(" ");
        }
        System.out.println(message);

        message.delete(0, message.length());
        message.append("reversed: ");
        Collections.reverse(Arrays.asList(sortedDigits));
        for (Integer digit: sortedDigits){
            message.append(digit.toString()).append(" ");
        }
        System.out.println(message);
    }

    private Integer[] sortByDigitLength(Integer[] numbers){
        Integer[] result = numbers.clone();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (countDigitLength(result[i]) > countDigitLength(result[j])) {
                    Collections.swap(Arrays.asList(result), i, j);
                }
            }
        }

        return result;
    }

    private int countDigitLength(int number){
        int length = 0;
        while (number / 10 > 0){
            number /= 10;
            length++;
        }
        return length;
    }
}
