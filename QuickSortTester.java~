/*
Crayoyo
Brian Lin, Aleksandra Koroza, Isaac Jon
APCS2 pd2
L01 -- What Does the Data Say?
2018-03-03
 */

public class QuickSortTester {

    //From lab00, populates an array in ascending order
    public static int[] populateArray (int length) {
	int[] arr = new int[length];
	int pop = 1;
        
        for (int x = 0; x < arr.length; x++){
	    arr[x] = pop;
	    pop += 1;
        }
	
	return arr;
    }

    //From lab00, returns average runtime
    public static long getAverage (int[] arr, int iterCnt) { 

	long sum = 0;

	for (int x = 0; x < iterCnt; x++) {

	    long startTime = System.nanoTime();
	    QuickSort.qsort(arr);
	    long endTime = System.nanoTime();
	    sum += (endTime - startTime);
	}
	long averageTime = (long) (sum / iterCnt);
	return averageTime;
    }

    public static long getAverage1 (int[] arr, int iterCnt) { 

	long sum = 0;

	for (int x = 0; x < iterCnt; x++) {

	    long startTime = System.nanoTime();
	    QuickSort.qsort1(arr);
	    long endTime = System.nanoTime();
	    sum += (endTime - startTime);
	}
	long averageTime = (long) (sum / iterCnt);
	return averageTime;
    }

    public static void main(String[] args) {
	long best, middle, worst;
	//Average Case
	//Create random array, choose left most pivot every time
	//Method: For each array size, repeat QuickSort 1000 times to get average runtime
	//From size 100 up to size 10000, x+= 100
	
	for(int i = 10; i <= 100000; i += 1000) {
	    int[] average = QuickSort.buildArray(i, 50);
	    //shuffling could make sense
	    middle = getAverage(average, 1000);
	    System.out.println(middle);
	}
	
        
	//Best Case
	//Use qsort1, which picks the median pivot point
	//Since the array is in ascending order, median evenly partitions the array
	/*
	for(int i = 10; i <= 100000; i += 1000) {
	    int[] fast = populateArray(i);
	    best = getAverage1(fast, 1000);
	    System.out.println(best);
	}
	*/

	//Worst Case
	//Use qsort, which picks the leftmost pivot point
	//Since the array is in ascending order, the leftmost is the smallest, so no values will be to the left of the pivot
	/*
       	for(int i = 10; i <= 100000; i += 1000) {
	    int[] slow = populateArray(i);
	    worst = getAverage1(slow, 1000);
	}
	*/
    }


}
