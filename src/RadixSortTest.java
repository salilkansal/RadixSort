import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class RadixSortTest {
    public static void main(String[] args) {

        int[] array = {4346, 9675, 529, 2456, 8760, 3345, 1346, 8764, 1247, 4564, 2367, 7457, 2364, 8554, 3267};
        System.out.println("Original List");
        for (int cuurNum : array) {
            System.out.print(cuurNum + " ");
        }
        radixSort(array, 4);

    }

    public static void radixSort(int[] array, int noOfDigits) {
        int modValue = 10;
        int divisor = 1;
        int digit = 0;

        ArrayList<LinkedList<Integer>> listArrayList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            listArrayList.add(linkedList);
        }
        while (digit < noOfDigits) {
            for (int currNum : array) {
                int temp = currNum % modValue;
                temp /= divisor;
                listArrayList.get(temp).add(currNum);
            }
            modValue *= 10;
            divisor *= 10;
            digit++;

            array = insertIntoArray(listArrayList);
        }
        System.out.println("\nAfter Radix Sort");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static int[] insertIntoArray(ArrayList<LinkedList<Integer>> listArrayList) {
        LinkedList<Integer> temp = new LinkedList<>();
        for (LinkedList<Integer> currList : listArrayList) {
            temp.addAll(currList);
            currList.clear();
        }

        return toIntArray(temp);
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] temp = new int[list.size()];
        for (int i = 0; i < temp.length; i++)
            temp[i] = list.get(i);
        return temp;
    }

}