import java.util.*;

public class Main {


    //Minimum Distances problem solution
    public static int minimumDistances(List<Integer> a) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> distancesMap = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            Integer currentItem = a.get(i);
            if (distancesMap.get(currentItem) != null) {
                List<Integer> currentIndexesList = distancesMap.get(currentItem);
                currentIndexesList.add(i);
                distancesMap.put(currentItem, currentIndexesList);
            } else {
                List<Integer> currentIndexesList = new ArrayList<>();
                currentIndexesList.add(i);
                distancesMap.put(currentItem, currentIndexesList);
            }
        }

        for (Integer i : distancesMap.keySet()) {
            List<Integer> currentIndexesList = distancesMap.get(i);
            if (currentIndexesList.size() <= 1) continue;
            for (int j = 0; j < currentIndexesList.size() - 1; j++) {
                if (currentIndexesList.get(j + 1) - currentIndexesList.get(j) < minDistance) {
                    minDistance = currentIndexesList.get(j + 1) - currentIndexesList.get(j);
                }
            }
        }

        if (minDistance < Integer.MAX_VALUE) {
            return minDistance;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {

        Integer[] inputArray1 = {3, 2, 1, 2, 3};
        System.out.println(minimumDistances(Arrays.asList(inputArray1)));
        Integer[] inputArray2 = {7, 1, 3, 4, 1, 7};
        System.out.println(minimumDistances(Arrays.asList(inputArray2)));


    }
}
