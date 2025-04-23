import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
    }
    
    public static ArrayList<Integer> allLessThanMean(ArrayList<Integer> list) {
        if (list.isEmpty()) return new ArrayList<>();
        
        // Calculate mean
        double sum = 0;
        for (int num : list) {
            sum += num;
        }
        double mean = sum / list.size();
        
        // Find all numbers less than mean
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (num < mean) {
                result.add(num);
            }
        }
        return result;
    }
    
    public static ArrayList<Double> distancesFromMean(ArrayList<Integer> list) {
        if (list.isEmpty()) return new ArrayList<>();
        
        // Calculate mean
        double sum = 0;
        for (int num : list) {
            sum += num;
        }
        double mean = sum / list.size();
        
        // Calculate distances from mean
        ArrayList<Double> result = new ArrayList<>();
        for (int num : list) {
            result.add(Math.abs(num - mean));
        }
        return result;
    }
    
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // For each number in list1, check if it exists in list2
        for (int num : list1) {
            if (list2.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }
    
    public static ArrayList<Integer> symmetricDiff(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        // Add elements from list1 that aren't in list2
        for (int num : list1) {
            if (!list2.contains(num) && !seen.contains(num)) {
                result.add(num);
                seen.add(num);
            }
        }
        
        // Add elements from list2 that aren't in list1
        for (int num : list2) {
            if (!list1.contains(num) && !seen.contains(num)) {
                result.add(num);
                seen.add(num);
            }
        }
        return result;
    }
    
    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merge the two sorted lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements from list1
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }
}
