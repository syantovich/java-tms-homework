import java.util.Arrays;

public class Task2 {

    public Task2 (){

    }
    public Task2(int countOfElements){
        int[] arr = this.getFibonacciArr(countOfElements);

        System.out.println("Ряд Фибоначи длинной " + countOfElements + " равен " + Arrays.toString(arr));
    }

    public int[] getFibonacciArr(int length){
        if(length==1){
            return new int[] {0};
        }

        int[] arr = new int[length];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i<arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }
}
