/**
 * Programming Project 4: Sorting
 * Complete the implementation of selection sort and quick sort and compare the run times
 * of the sorts on various arrays of 5000 random integers.
 * @author Stefon Glover
 * @version 11/2/20
 */
public class ProgrammingProject4 {

    public static void main(String[] args)
    {
        //Selection Sort test
        //Create an Integer[] array and 
        //fill it with random numbers up to 50000
        Integer[] selectionSortArray = new Integer[5000];

        for(int i = 0; i < selectionSortArray.length; i++)
        {
            selectionSortArray[i] = (int)(Math.random() * 5000);
        }

        long selectionStartTime = System.currentTimeMillis();

        selectionSort(selectionSortArray, selectionSortArray.length);

        long selectionEndTime = System.currentTimeMillis();

       //printAll(myArray);

       System.out.println("Total time for selection sort: "+(selectionEndTime - selectionStartTime)+" milliseconds");

       //Quick Sort test
       //Create an empty integer array and fill it with 5000 random integers
       int[] quickSortArray = new int[5000];
       for(int j = 0; j < quickSortArray.length; j++)
       {
           quickSortArray[j] = (int)(Math.random() * 5000);
       }

       long quickSortStartTime = System.currentTimeMillis();

       quickSort(quickSortArray, 0, quickSortArray.length - 1);

       long quickSortEndTime = System.currentTimeMillis();

       System.out.println("Total time for quick sort: "+(quickSortEndTime - quickSortStartTime)+" milliseconds");


       //printAll(quickSortArray);


    }

    /**
     * The main method for Selection Sorting
     * @param <T> Generic type to be sorted
     * @param n Number of elements in the array
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n)
    {
        for (int index = 0; index < n -1; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
        }
    }

    // Finds the index of the smallest value in a portion of an array a.
    // Preconditon: a.length > last >= first >= 0.
    // Returns the index of the smallest value among
    // a[first], a[first-1]......, a[lasts]
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
    {
        T min = a[first];
        int indexOfMin = first;

        for(int index = first + 1; index <= last; index++)
        {
            if(a[index].compareTo(min) < 0)
            {
                min = a[index];
                indexOfMin = index;
            }
        }

        return indexOfMin;
    }

    // Swaps the array entries a[i] and a[j].
    private static void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Helper method to print all the elements in the Object[]
    public static void printAll(Object[] array)
    {
        for (Object object : array) {

            System.out.print(object+ " ");
            
        }
    }

    //Helper method to print all elements in the array
    public static void printAll(int[] array)
    {
        for (int i : array) {

            System.out.print(i+" ");
            
        }
    }

    /**
     * The main method that implements Quicksort
     * @param array The array that is to be sorted
     * @param left The starting index of the array
     * @param right The ending index of the array
     */
    public static void quickSort(int[] array, int left, int right)
    {
        if(left < right)
        {
           int partitionIndex = partition(array, left, right);

            quickSort(array, left, partitionIndex - 1);

            quickSort(array, partitionIndex + 1, right);
        }
    }

    /**
     * This method takes the last element as the pivot, places it at its correct sorted position, 
     * and places anything smaller than the pivot to the left and anything greater to the right
     * @param array The array used to determine the pivot
     * @param left The starting point of the array
     * @param right The ending point of the array
     * @return
     */
    public static int partition (int[] array, int left, int right)
    {
        //Pivot for the method
        int pivot = array[right];  
 
        //Get the index of the smaller element in the array
        int i = (left - 1);  

        for (int j = left; j <= right - 1; j++)
        {
            //Swap the elements at index i and j if the pivot is greater than array[j]
            if (array[j] < pivot)
            {
                //Increase the index of the smaller element
                i++;    
                swap(array[i], array[j]);
            }
        }
        swap(array[1 + 1], array[right]);
        return (i + 1);
    }   

    /**
     * This method swaps two value
     * @param a int to be swapped
     * @param b int to be swapped
     */
    public static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    
}