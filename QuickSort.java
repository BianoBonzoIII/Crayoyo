/*
  Brian Lin 
  APCS2 pd2 
  HW18 -- So So Quick 
  2018-03-13
 */

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):  
 * 
 * Quicksort selects a pivot value at the end of the original array to use
 * for the partition. After the partition, run partition again on the array 
 * to the left and right of the pviot, repeating this process on the arrays
 * that result from the subsequent passes. Once the method finishes, you will
 * be left with a sorted array. 
 *
 * 2a. Worst pivot choice and associated runtime: 
 *
 * Worst pivot: The largest value in the array
 * Runtime: O(n^2)
 * 
 * 2b. Best pivot choice and associated runtime:
 * 
 * Best pivot: The medium value in the array
 * Runtime: O(n log n)
 *
 * 3. Approach to handling duplicate values in array:
 *Allow partition to do its work
 * 
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  //Partition method
  public static int partition( int arr[], int low, int high, int pivot) {
    int v = arr[pivot];

    swap( pivot, high, arr);
    int s = low;

    for( int i = low; i < high; i++ ) {
        if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;
      }
    }
    swap(s,high,arr);

    return s;
}//end partition
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d ) { 
    qsortH(d, 0, d.length-1);
  }

  //you may need a helper method...
  public static void qsortH(int[] arr, int left, int right) {
    if(left < right) {
      int pvtPos = partition(arr, left, right, left);
      qsortH(arr, left, pvtPos-1);
      qsortH(arr, pvtPos+1, right);
    }
  }

   /*****************************************************
   * void qsort1(int[])
   * @param d -- array of ints to be sorted in place
   * pivot point = middle, used in best case in lab01
   *****************************************************/
   public static void qsort1( int[] d ) { 
    qsortH1(d, 0, d.length-1);
  }

  //you may need a helper method...
  public static void qsortH1(int[] arr, int left, int right) {
    if(left < right) {
	int pvtPos = partition(arr, left, right, (right+left)/2);
      qsortH1(arr, left, pvtPos-1);
      qsortH1(arr, pvtPos+1, right);
    }
  }


  //main method for testing
  public static void main( String[] args )
  {
    

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);
 
    qsort1( arr1 );	
    System.out.println("arr1 after qsort: " );
    printArr(arr1);
    

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort1( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort1( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    

  }//end main

}//end class QuickSort
