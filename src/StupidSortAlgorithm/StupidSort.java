package StupidSortAlgorithm;
import java.util.List;

public class StupidSort {
    public <T extends Comparable <T>> List<T> stupidSort(List<T> unsorted) {
        int pointer = 0; // Start at the first entry in the list.

        while (pointer < unsorted.size()) {
            int left = pointer - 1;  // The index of entry to the left of the entry at pointer.

            /*
            If you are pointing at the first element in the list,
                                    OR
            the element at pointer is greater than the element at left.
             */
            if (pointer == 0 || unsorted.get(pointer).compareTo(unsorted.get(left)) >= 0) {
                pointer++;  // Move to the right.
            } else {
                swap(unsorted, pointer);  // Change the positions of the entries at pointer and left.
                pointer--;  // Move to the left.
            }
        }
        return unsorted;
    }


    /**
     * Helper function for the main stupidSort method.
     *
     * @param unsorted
     * @param pointer
     */
    public static <T extends Comparable <T>> void swap(List<T> unsorted, int pointer) {
        T pointerObject = unsorted.get(pointer);
        T beforeObject = unsorted.get(pointer - 1);
        unsorted.set(pointer, beforeObject);
        unsorted.set(pointer - 1, pointerObject);
    }
}
