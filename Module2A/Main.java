public class Main {
    public static void main(String[] args) {
        int[] myArray = {3, 7, 6, 2, 9, 0, 4, 8};
        System.out.println(range(myArray));
    }
    public static int sumOfOdds(int [] data){
        int sum = 0;

        for(int value : data){
            if(value%2 == 1)
                sum += value;
        }
        return sum;
    }
    public static int [] getMinAndMax(int [] data){
        int [] getMinAndMax = new int[2];
        getMinAndMax [0] = data[0]; //min
        getMinAndMax [1] = data[0]; //max

        for(int value : data){
            if(value < getMinAndMax[0])
                getMinAndMax[0] = value;
            if(value > getMinAndMax[1])
                getMinAndMax[1] = value;
        }

        return getMinAndMax;
    }
    public static int range(int[] data) {
        int[] minMax = getMinAndMax(data);
        return minMax[1] - minMax[0]; // max - min
    }

    public static int getSecondLargest(int[] data) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int value : data) {
            if (value > largest) {
                secondLargest = largest;
                largest = value;
            } else if (value > secondLargest && value != largest) {
                secondLargest = value;
            }
        }
        return secondLargest;
    }

    public static int[] getDifferences(int[] data) {
        int[] differences = new int[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            differences[i] = data[i + 1] - data[i];
        }
        return differences;
    }
}
