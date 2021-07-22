package Lab2;
import java.util.Scanner;


public class Lab2C {
    Integer[][] array;
    int rowsAndColumns;
    Scanner scanner = new Scanner(System.in);

    public void doTheTask(){
        defineArray();
        showArray();
        int max = this.findMax();
        System.out.println("Max: " + max);
        deleteRowAndColumnsWithMax(max);

        showArray();
    }

    private void defineArray(){
        this.defineRowsAndColumns();
        this.generateRandomArray();
    }

    private void defineRowsAndColumns(){
        System.out.print("Enter amount of rows and columns: ");
        rowsAndColumns = scanner.nextInt();

        this.array = new Integer[rowsAndColumns][rowsAndColumns];
    }

    private void generateRandomArray(){
        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < rowsAndColumns; j++){
                this.array[i][j] = generateRandomNumber();
            }
        }
    }

    private int generateRandomNumber(){
        //return (int)(Math.random() * (2 * rowsAndColumns+1) - rowsAndColumns);
        return (int)(Math.random() * (2 * rowsAndColumns+2) - (rowsAndColumns+1));
    }

    private int findMax(){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < array[i].length; j++){
                if (this.array[i][j] > max){
                    max = this.array[i][j];
                }
            }
        }
        return max;
    }

    private void deleteRowAndColumnsWithMax(int max){
        while(max == findMax()){
            int[] indexesOfElement = indexesOfElement(max);
            deleteColumn(indexesOfElement[1]);
            deleteRow(indexesOfElement[0]);
        }

    }

    private int[] indexesOfElement(int element){
        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] == element){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    private void deleteColumn(int columnNumber){
        for (int i = 0; i < rowsAndColumns; i++){
            array[i] = deleteElementFromArray(array[i], columnNumber);
        }
    }

    private void deleteRow(int rowNumber){
        Integer[][] lowerArray = new Integer[rowsAndColumns - 1][rowsAndColumns];
        for (int i = 0; i < lowerArray.length; i++){
            if (i == rowNumber){
                continue;
            }
            lowerArray[i] = array[i];
        }
    }

    private Integer[] deleteElementFromArray(Integer[] array, int index){
        Integer[] result = new Integer[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++){
            if (i == index){
                continue;
            }
            result[k++] = array[i];
        }
        return result;
    }

    private void showArray(){
        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
