public class Main {
    public static void main(String[] args) {
        // Swapping integers
        Integer[] intArr = {10, 20, 30, 40, 50};
        System.out.println("Before swapping integers:");
        for (int num : intArr) {
            System.out.print(num + " ");
        }

        int ind1 = 1;
        int ind2 = 3;
        System.out.println("\nSwapping: " + intArr[ind1] + " and " + intArr[ind2]);
        SwapArrayElements.swap(intArr, ind1, ind2);

        System.out.println("After swapping integers:");
        for (int num : intArr) {
            System.out.print(num + " ");
        }
        System.out.println("\n#############################\n");


        // Swapping strings
        String[] strArray = {"abc", "efg", "xyz", "pqr"};
        System.out.println("Before swapping strings:");
        for (String str : strArray) {
            System.out.print(str + " ");
        }

        int strIdx1 = 0;
        int strIdx2 = 2;
        System.out.println("Swapping: " + strArray[strIdx1] + " and " + strArray[strIdx2]);

        SwapArrayElements.swap(strArray, strIdx1, strIdx2);
        System.out.println("After swapping strings:");
        for (String str : strArray) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}