import java.util.Arrays;

public class HW6 {

        public static void main(String[] args) {
            System.out.println(Arrays.toString(sliceArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})));
          //  System.out.println(Arrays.toString(sliceArray(new int[]{1, 2, 3, 3, 5, 6, 7, 8, 9, 0})));     //RuntimeException
            System.out.println(Arrays.toString(sliceArray(new int[]{1, 2, 3, 4})));
            System.out.println();
            System.out.println(OneOrFour(new int[] {1, 1, 1, 1, 4, 4, 4, 4, 1, 1, 4}));       //true массив
            System.out.println(OneOrFour(new int[] {1, 1, 1, 1}));                            //Массив без 4
            System.out.println(OneOrFour(new int[] {4, 4, 4, 4}));                            //Массив без 1
            System.out.println(OneOrFour(new int[] {1, 4, 1, 4, 1, 5, 4, 1, 4, 1, 4}));       //массив с лишним элементом
        }

/**
 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив, метод должен вернуть новый массив,
 который получен путем вытаскивания элементов из исходного массива, идущих после последней четверки. Входной массив должен содержать
 хотя бы одну четверку, в противном случае в методе необходимо выбросить RuntimeException. */
    public static int[] sliceArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("" + "В массиве 4 не найдено");
    }

 /**   2. Написать набор тестов для этого метода (варианта 3-4 входных данных) вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]  */
    public static boolean OneOrFour(int[] arr) {
        boolean oof1 = false;
        boolean oof4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                oof1 = true;
            }
            else if(arr[i] == 4) {
                oof4 = true;
            }
            else {
                return false;
            }
        }
        return oof1 && oof4;
    }
}