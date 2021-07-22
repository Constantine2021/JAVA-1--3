package com.company;
import java.util.*;

public class Lab1 {

        TreeMap<Integer, Integer> treeMap;
        Integer[] digits;

    public Lab1(Integer[]digits){
            this.treeMap = new TreeMap<Integer, Integer>();
            this.digits = digits;
        }

        public void doTheTask () {
            this.addDigitsToHashtable();
            Integer[] result = this.sort();

            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print("sorted: ");
            for (Integer digit : result) {
                System.out.print(digit + " ");
            }
            System.out.print("\n");

        }

        private void addDigitsToHashtable () {
            for (int i = 0; i < this.digits.length; i++) {
                System.out.print(this.digits[i] + " ");
                int counter = 1;
                if (this.treeMap.containsKey(digits[i])) {
                    continue;
                }
                for (int j = i + 1; j < this.digits.length; j++) {
                    if (this.digits[i].equals(this.digits[j])) {
                        counter++;
                    }

                }
                treeMap.put(this.digits[i], counter);
            }
            System.out.println();
        }

        private Integer[] sort () {
            Integer[] result = this.treeMap.keySet().toArray(new Integer[0]);
            for (int i = 0; i < result.length; i++) {
                Integer comparing = result[i];
                for (int j = 0; j < result.length; j++) {
                    Integer comparing_with = result[j];
                    if (this.treeMap.get(comparing) > this.treeMap.get(comparing_with)) {
                        Collections.swap(Arrays.asList(result), i, j);
                    }
                }
            }
            return result;
        }

}
