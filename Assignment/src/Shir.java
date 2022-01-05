import java.util.Arrays;

public class Shir {
    public static void main(String[] args) {
        int[] arr1 ={1,3,6,3,4,3,5,5,2};
        int[] arr2 ={1,2,5,4,3};
        int[] arr3 ={1,2,3,4,5,0,7};
     //   System.out.println(Arrays.toString(oneNumberNotGood(arr1)));

       // System.out.println(Arrays.toString(bubble(arr1)));

       // System.out.println(counterNum(arr1));
        System.out.println(Arrays.toString(oneNumberNotGood(arr3)));
    }


///   public static int max(int[] arr){
////     Finding a maximum in unsorted array
////     n+3  =פונקציית זמן  , o(1) if we know the arr.length.  if we dont  the arr.length so o(n)
////     n = arr.length
//
//        int max=arr[0];
//        for (int i = 1 ; i < n; i++) {
//            if (arr[i]>max)
//                max=arr[i];
//        }
//        return max;
//    }
//
//
//
//    public static double avg(int[] arr){
////    Finding an average
////     n+3  =פונקציית זמן      ,n=arr.length , if we know the arr.length so o(1) .  if we dont know so o(n)
//
//        double avg=0.0;
//        for (int i = 1; i < n; i++) {
//            avg+=arr[i];
//        }
//        return avg/n;
//    }
///1



    public static void maxSorted(int[] arr) {
        // Finding a maximum in a sorted array.
        // o(1) , b=1 =פונקציית זמן

        if (arr[0] > arr[arr.length - 1])
            System.out.println("the max value is : " + arr[0]);
        else
            System.out.println("the max value is : " + arr[arr.length - 1]);
    } //1



    //2
    public static int[] oneNumberNotGood(int[] arr) {
        // o(n) --> if arr.length = n.
            for (int i = 0; i < arr.length-1; i++) {
                    if(arr[i] > arr[i+1]){
                        int temp = arr[i];
                        arr[i]=arr[i+1];
                        arr[i+1]=temp;
                       i=-1;
                    }

                }

        return arr;
    }

    //3

    public  static int[]  bubble(int[] arr){
    int notSwap =0;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < arr.length-1-j; j++) {
                if (arr[j] > arr[j+1]){
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]  =temp;
                    notSwap++;
                }
            }
            if (notSwap==0) return arr;
        }

        return arr;
    }


    // 4:
    // a. The function checks if all the values in array a are bigger than array b
    // b. o(n^2)
    // c
    public static boolean check(int[] a , int[] b){
        int min=a[0], max2 =b[0];
        for (int i = 1 ; i < a.length; i++) {
            if (a[i]<min)
                min=a[i];
        }

        for (int i = 1 ; i < b.length; i++) {
            if (b[i]>max2)
                max2=b[i];
        }

        if (min<max2){
            return false;
        }
        return  true;
    }
    //d o(n)


// 5:
public static int counterNum(int[] arr){
    int counter =0;
    int num =0;
    int bigCounter=0;

    Arrays.sort(arr);

    for (int i = 0; i < arr.length-1; i++) {
        if (arr[i]==arr[i+1])
            counter++;
        else counter =0;

        if (counter>bigCounter){
            bigCounter=counter;
            num=arr[i];
        }

    }
    return  num;
}


}