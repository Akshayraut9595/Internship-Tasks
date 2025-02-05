public class SwapArrayElements {
    public static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices or array is null.");
        }

        T temp = array[index1];  // Temporary variable to hold one element
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
