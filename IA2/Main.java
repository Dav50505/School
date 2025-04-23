// 1st program
// public class Main {
//     public static double[] averageAndSum(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return new double[]{0.0, 0.0};
//         }
        
//         double sum = 0;
//         for (int num : arr) {
//             sum += num;
//         }
//         double average = sum / arr.length;
        
//         return new double[]{average, sum};
//     }
// }

// 2nd program

// public class Main {
//     public static int[] maxAndMin(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return new int[]{0, 0};
//         }
        
//         int max = arr[0];
//         int min = arr[0];
        
//         for (int num : arr) {
//             if (num > max) {
//                 max = num;
//             }
//             if (num < min) {
//                 min = num;
//             }
//         }
        
//         return new int[]{max, min};
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         int[] arr1 = {1, 2, 3, 4, 5};
//         int[] result1 = maxAndMin(arr1);
//         System.out.println("Test 1: " + result1[0] + ", " + result1[1]);  // Should print: 5, 1

//         // Test case 2
//         int[] arr2 = {3, 7, 6, 2, 9, 0, 4, 8};
//         int[] result2 = maxAndMin(arr2);
//         System.out.println("Test 2: " + result2[0] + ", " + result2[1]);  // Should print: 9, 0

//         // Test case 3
//         int[] arr3 = {1, 1, 1};
//         int[] result3 = maxAndMin(arr3);
//         System.out.println("Test 3: " + result3[0] + ", " + result3[1]);  // Should print: 1, 1
//     }
// }


// 3rd program

// public class Main {
//     public static int[] evenAndOdd(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return new int[]{0, 0};
//         }
        
//         int oddCount = 0;
//         int evenCount = 0;
        
//         for (int num : arr) {
//             if (num % 2 == 0) {
//                 evenCount++;
//             } else {
//                 oddCount++;
//             }
//         }
        
//         return new int[]{oddCount, evenCount};
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         int[] arr1 = {1, 2, 3, 4, 5};
//         int[] result1 = evenAndOdd(arr1);
//         System.out.println("Test 1: " + result1[0] + ", " + result1[1]);  // Should print: 3, 2

//         // Test case 2
//         int[] arr2 = {3, 7, 6, 2, 9, 0, 4, 8};
//         int[] result2 = evenAndOdd(arr2);
//         System.out.println("Test 2: " + result2[0] + ", " + result2[1]);  // Should print: 3, 5

//         // Test case 3
//         int[] arr3 = {1, 1, 1};
//         int[] result3 = evenAndOdd(arr3);
//         System.out.println("Test 3: " + result3[0] + ", " + result3[1]);  // Should print: 3, 0
//     }
// }

// 4th program

// public class Main {
//     public static int range(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return 0;
//         }
        
//         int max = arr[0];
//         int min = arr[0];
        
//         for (int num : arr) {
//             if (num > max) {
//                 max = num;
//             }
//             if (num < min) {
//                 min = num;
//             }
//         }
        
//         return max - min;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         int[] arr1 = {1, 2, 3, 4, 5};
//         System.out.println("Test 1: " + range(arr1));  // Should print: 4

//         // Test case 2
//         int[] arr2 = {3, 7, 6, 2, 9, 0, 4, 8};
//         System.out.println("Test 2: " + range(arr2));  // Should print: 9

//         // Test case 3
//         int[] arr3 = {1, 1, 1};
//         System.out.println("Test 3: " + range(arr3));  // Should print: 0
//     }
// }

// 5th program

// public class Main {
//     public static int countGreaterThanAvg(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return 0;
//         }
        
//         // Calculate average
//         double sum = 0;
//         for (int num : arr) {
//             sum += num;
//         }
//         double average = sum / arr.length;
        
//         // Count numbers greater than average
//         int count = 0;
//         for (int num : arr) {
//             if (num > average) {
//                 count++;
//             }
//         }
        
//         return count;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         int[] arr1 = {1, 2, 3, 4, 5};
//         System.out.println("Test 1: " + countGreaterThanAvg(arr1));  // Should print: 2

//         // Test case 2
//         int[] arr2 = {13, 7, 6, 5, 99, 10, 4, 8};
//         System.out.println("Test 2: " + countGreaterThanAvg(arr2));  // Should print: 1

//         // Test case 3
//         int[] arr3 = {1, 1, 1};
//         System.out.println("Test 3: " + countGreaterThanAvg(arr3));  // Should print: 0
//     }
// }

// 6th program

// import java.util.ArrayList;

// public class Main {
//     public static ArrayList<Integer> getInRange(ArrayList<Integer> list, int min, int max) {
//         ArrayList<Integer> result = new ArrayList<Integer>();
        
//         for (int num : list) {
//             if (num >= min && num <= max) {
//                 result.add(num);
//             }
//         }
        
//         return result;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         ArrayList<Integer> list1 = new ArrayList<Integer>();
//         list1.add(1);
//         list1.add(2);
//         list1.add(3);
//         list1.add(4);
//         list1.add(5);
//         ArrayList<Integer> result1 = getInRange(list1, 2, 4);
//         System.out.println("Test 1: " + result1);  // Should print: [2, 3, 4]

//         // Test case 2
//         ArrayList<Integer> list2 = new ArrayList<Integer>();
//         list2.add(3);
//         list2.add(7);
//         list2.add(6);
//         list2.add(2);
//         list2.add(9);
//         list2.add(0);
//         list2.add(4);
//         list2.add(8);
//         ArrayList<Integer> result2 = getInRange(list2, 3, 10);
//         System.out.println("Test 2: " + result2);  // Should print: [3, 7, 6, 9, 4, 8]

//         // Test case 3
//         ArrayList<Integer> list3 = new ArrayList<Integer>();
//         list3.add(1);
//         list3.add(1);
//         list3.add(1);
//         ArrayList<Integer> result3 = getInRange(list3, 1, 1);
//         System.out.println("Test 3: " + result3);  // Should print: [1, 1, 1]
//     }
// }

// 7th program

// import java.util.ArrayList;

// public class Main {
//     public static ArrayList<Integer> lessThanAverage(ArrayList<Integer> list) {
//         ArrayList<Integer> result = new ArrayList<Integer>();
        
//         if (list == null || list.isEmpty()) {
//             return result;
//         }
        
//         // Calculate average
//         double sum = 0;
//         for (int num : list) {
//             sum += num;
//         }
//         double average = sum / list.size();
        
//         // Find numbers less than average
//         for (int num : list) {
//             if (num < average) {
//                 result.add(num);
//             }
//         }
        
//         return result;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         ArrayList<Integer> list1 = new ArrayList<Integer>();
//         list1.add(1);
//         list1.add(2);
//         list1.add(3);
//         list1.add(4);
//         list1.add(5);
//         ArrayList<Integer> result1 = lessThanAverage(list1);
//         System.out.println("Test 1: " + result1);  // Should print: [1, 2]

//         // Test case 2
//         ArrayList<Integer> list2 = new ArrayList<Integer>();
//         list2.add(3);
//         list2.add(7);
//         list2.add(6);
//         list2.add(2);
//         list2.add(9);
//         list2.add(0);
//         list2.add(4);
//         list2.add(8);
//         ArrayList<Integer> result2 = lessThanAverage(list2);
//         System.out.println("Test 2: " + result2);  // Should print: [3, 2, 0, 4]

//         // Test case 3
//         ArrayList<Integer> list3 = new ArrayList<Integer>();
//         list3.add(1);
//         list3.add(1);
//         list3.add(1);
//         ArrayList<Integer> result3 = lessThanAverage(list3);
//         System.out.println("Test 3: " + result3);  // Should print: []
//     }
// }

// 8th program

// import java.util.ArrayList;

// public class Main {
//     public static ArrayList<Integer> getDuplicates(ArrayList<Integer> list) {
//         ArrayList<Integer> result = new ArrayList<Integer>();
        
//         if (list == null || list.isEmpty()) {
//             return result;
//         }
        
//         // For each number in the list
//         for (int i = 0; i < list.size(); i++) {
//             int num = list.get(i);
//             int count = 0;
            
//             // Count occurrences of this number
//             for (int j = 0; j < list.size(); j++) {
//                 if (list.get(j) == num) {
//                     count++;
//                 }
//             }
            
//             // If number appears more than once and hasn't been added to result yet
//             if (count > 1 && !result.contains(num)) {
//                 result.add(num);
//             }
//         }
        
//         return result;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         ArrayList<Integer> list1 = new ArrayList<Integer>();
//         list1.add(1);
//         list1.add(2);
//         list1.add(3);
//         list1.add(4);
//         list1.add(5);
//         ArrayList<Integer> result1 = getDuplicates(list1);
//         System.out.println("Test 1: " + result1);  // Should print: []

//         // Test case 2
//         ArrayList<Integer> list2 = new ArrayList<Integer>();
//         list2.add(3);
//         list2.add(2);
//         list2.add(3);
//         list2.add(1);
//         list2.add(4);
//         list2.add(2);
//         list2.add(1);
//         list2.add(3);
//         list2.add(0);
//         ArrayList<Integer> result2 = getDuplicates(list2);
//         System.out.println("Test 2: " + result2);  // Should print: [3, 2, 1]

//         // Test case 3
//         ArrayList<Integer> list3 = new ArrayList<Integer>();
//         list3.add(1);
//         list3.add(1);
//         list3.add(1);
//         ArrayList<Integer> result3 = getDuplicates(list3);
//         System.out.println("Test 3: " + result3);  // Should print: [1]
//     }
// }

// 9th program

// import java.util.ArrayList;

// public class Main {
//     public static ArrayList<Integer> inBoth(ArrayList<Integer> list1, ArrayList<Integer> list2) {
//         ArrayList<Integer> result = new ArrayList<Integer>();
        
//         if (list1 == null || list2 == null) {
//             return result;
//         }
        
//         // For each number in the first list
//         for (int num : list1) {
//             // If number is in second list and not already in result
//             if (list2.contains(num) && !result.contains(num)) {
//                 result.add(num);
//             }
//         }
        
//         return result;
//     }

//     public static void main(String[] args) {
//         // Test case 1
//         ArrayList<Integer> list1a = new ArrayList<Integer>();
//         list1a.add(1);
//         list1a.add(2);
//         list1a.add(3);
//         list1a.add(4);
//         list1a.add(5);
        
//         ArrayList<Integer> list1b = new ArrayList<Integer>();
//         list1b.add(0);
//         list1b.add(2);
//         list1b.add(9);
//         list1b.add(3);
        
//         ArrayList<Integer> result1 = inBoth(list1a, list1b);
//         System.out.println("Test 1: " + result1);  // Should print: [2, 3]

//         // Test case 2
//         ArrayList<Integer> list2a = new ArrayList<Integer>();
//         list2a.add(3);
//         list2a.add(1);
//         list2a.add(2);
//         list2a.add(3);
//         list2a.add(5);
//         list2a.add(1);
//         list2a.add(0);
        
//         ArrayList<Integer> list2b = new ArrayList<Integer>();
//         list2b.add(0);
//         list2b.add(2);
//         list2b.add(9);
//         list2b.add(3);
//         list2b.add(5);
//         list2b.add(5);
        
//         ArrayList<Integer> result2 = inBoth(list2a, list2b);
//         System.out.println("Test 2: " + result2);  // Should print: [3, 2, 5, 0]

//         // Test case 3
//         ArrayList<Integer> list3a = new ArrayList<Integer>();
//         list3a.add(1);
//         list3a.add(2);
//         list3a.add(3);
//         list3a.add(4);
//         list3a.add(5);
        
//         ArrayList<Integer> list3b = new ArrayList<Integer>();
//         list3b.add(6);
//         list3b.add(7);
//         list3b.add(8);
        
//         ArrayList<Integer> result3 = inBoth(list3a, list3b);
//         System.out.println("Test 3: " + result3);  // Should print: []
//     }
// }