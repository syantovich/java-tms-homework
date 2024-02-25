import java.util.Arrays;

public class Task1 {
    public Task1(){

    }

    public Task1 (int countOfElements){
        int[] arr = this.getRandomArr(countOfElements);

        float average = this.getAverage(arr);

        System.out.println("Массив - " + Arrays.toString(arr));

        System.out.println("Среднее арифметическое " + average);

        int[] duplicateInfo = this.getDuplicateItem(arr);

        if(duplicateInfo[1]!=0){
            System.out.println("Повторяеться элемент " + duplicateInfo[0] + " - " + duplicateInfo[1] + " раз");
        }else {
            System.out.println("Duplicate element not found");
        }

        int[] reverseCopy = this.getReverseCopy(arr);

        System.out.println("Копия массива - " + Arrays.toString(reverseCopy));
    }

    public int[] getRandomArr(int count){

        int[] arrRandom = new int[count];

        for(int i = 0; i<count; i++) {
            arrRandom[i]=(int)(Math.random() * 10);
        }

        return arrRandom;
    }

    public float getAverage(int[] arr){
        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        return (float) sum / arr.length;
    }

    public int[] getReverseCopy(int[] arr){
        int[] arrCopy= new int[arr.length];

        for(int i = 0; i< arr.length;i++){
            arrCopy[arr.length-i-1] = arr[i];
        }

        return arrCopy;
    }

    public int[] getDuplicateItem (int[] arr){
        int arrCount = 0;
        int arrItem = 0;

        for(int i = 0; i<arr.length; i++){
            int count = 1;
            for(int j = i+1; j<arr.length;j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count>arrCount){
                arrCount = count;
                arrItem = arr[i];
            }
        }

        return new int[] {arrItem,arrCount};
    }
}
