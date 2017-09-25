import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Algo {

    //Метод делает из данного массива подмассив разностей элементов
    public static int[] miniMass(int[] mass) {
        int[] smallMass = new int[mass.length - 1];
        for (int i = 0; i < mass.length - 1; i++) {
            smallMass[i] = mass[i+1] - mass[i];
        }
        return smallMass;
    }

    //Главный метод, поиск максимального подмножества, сумма его элементов
    public static int findMax(int[] mass) {

        int maxSum = mass[0];
        int newSum = mass[0];

        for (int i = 1; i < mass.length; i++) {

            newSum += mass[i];

            if (mass[i] > newSum) {
                newSum = mass[i];
            }
            if (maxSum < newSum) {
                maxSum = newSum;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] a = {-4, 23, -23, 34, 44, 2};
        int[] result = miniMass(a);
        System.out.println(Arrays.toString(result)); //вывод на экран подмассива разностей
        System.out.println(findMax(result)); //сумма эл-ов этого массива
    }

    @Test
    public void findMax() throws Exception {
        int[] a = new int[]{1, 2, 1, -3, 2};
        assertEquals(4, findMax(a));
    }

    @Test
    public void findMax1() throws Exception {
        int[] b = new int[]{4, -7, 7, -5, 4};
        assertEquals(7, findMax(b));
    }

    @Test
    public void findMax2() throws Exception {
        int[] c = new int[]{27, -46, 57, 10, -42};
        assertEquals(67, findMax(c));
    }

}
