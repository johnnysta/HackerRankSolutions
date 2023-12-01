import java.util.*;

public class Main {


    //HackerRank Minimum Distances problem solution
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

    //HackerRank Halloween Sale problem solution
    public static int howManyGames(int p, int d, int m, int s) {
        int gamesCount = 0;
        int currentPrice = p;
        for (; currentPrice >= m && s >= currentPrice; currentPrice -= d) {
            s -= currentPrice;
            gamesCount++;
        }

        if (s >= currentPrice) {
            currentPrice = m;
            gamesCount += s / currentPrice;
        }
        return gamesCount;
    }

    //HackerRank Service Lane problem solution
    public static List<Integer> serviceLane(List<Integer> width, List<List<Integer>> cases) {
        List<Integer> results = new ArrayList<>();
        for (List<Integer> currentCase : cases) {
            Integer minWidth = Integer.MAX_VALUE;
            for (int i = currentCase.get(0); i <= currentCase.get(1); i++) {
                if (width.get(i) < minWidth) {
                    minWidth = width.get(i);
                }
            }
            results.add(minWidth);
        }
        return results;
    }


    //HackerRank Lisa's Workbook problem solution
    public static int workbook(int n, int k, List<Integer> arr) {
        int currentPage = 0;
        int specialProblemsCount = 0;
        for (Integer totalProblemsInChapter : arr) {
            for (int currentProblemIndex = 1; currentProblemIndex <= totalProblemsInChapter; currentProblemIndex++) {
                if (currentProblemIndex % k == 1 || k == 1) {
                    currentPage++;
                }
                if (currentPage == currentProblemIndex) {
                    specialProblemsCount++;
                }
            }
        }
        return specialProblemsCount;
    }


    //HackerRank Flatland Space Stations problem solution
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = c[0];
        int currentDistance = 0;
        for (int i = 0; i < c.length - 1; i++) {
            currentDistance = (c[i + 1] - c[i]) / 2;
            maxDistance = Math.max(currentDistance, maxDistance);
        }
        if (n - 1 > c[c.length - 1]) {
            currentDistance = ((n - 1) - c[c.length - 1]);
            maxDistance = Math.max(currentDistance, maxDistance);
        }
        return maxDistance;
    }

    //HackerRank Fair Rations problem solution
    public static String fairRations(List<Integer> citizens) {
        boolean neighborToBeIncremented = false;
        int requiredLoaves = 0;
        for (int i = 0; i < citizens.size(); i++) {
            int currentCitizensLoaves = citizens.get(i);
            if (neighborToBeIncremented) {
                currentCitizensLoaves++;
                citizens.set(i, currentCitizensLoaves);
                requiredLoaves++;
            }
            if (currentCitizensLoaves % 2 == 1) {
                currentCitizensLoaves++;
                citizens.set(i, currentCitizensLoaves + 1);
                requiredLoaves++;
                neighborToBeIncremented = true;
            } else {
                neighborToBeIncremented = false;
            }
        }
        if (neighborToBeIncremented) {
            return "NO";
        } else {
            return String.valueOf(requiredLoaves);
        }
    }

    //HackerRank Manasa and Stones problem solution - with recursion (too slow)
    public static List<Integer> stones1(int n, int a, int b) {
        Set<Integer> results = new HashSet<>();
        findResults(n, a, b, 0, results);
        ArrayList<Integer> resultList = new ArrayList<>(results);
        Collections.sort(resultList);
        return resultList;
    }

    static void findResults(int i, int a, int b, int currentValue, Set<Integer> results) {
        if (i > 1) {
            findResults(i - 1, a, b, currentValue + a, results);
            findResults(i - 1, a, b, currentValue + b, results);
        } else {
            results.add(currentValue);
        }
    }

    //HackerRank Manasa and Stones problem solution
    public static List<Integer> stones(int n, int a, int b) {
        Set<Integer> results = new HashSet<>();
        for (int i = 0; i < n; i++) {
            results.add(i * a + (n - i - 1) * b);
        }
        ArrayList<Integer> resultList = new ArrayList<>(results);
        Collections.sort(resultList);
        return resultList;
    }


    public static void main(String[] args) {

//        Integer[] inputArray1 = {3, 2, 1, 2, 3};
//        System.out.println(minimumDistances(Arrays.asList(inputArray1)));
//        Integer[] inputArray2 = {7, 1, 3, 4, 1, 7};
//        System.out.println(minimumDistances(Arrays.asList(inputArray2)));


//        System.out.println(howManyGames(20, 3, 6, 70));
//        System.out.println(howManyGames(100, 1, 1, 99));
//        System.out.println(howManyGames(100, 19, 1, 180));
//        System.out.println(howManyGames(100, 12, 55, 95));


//        Integer[] width = {2, 3, 1, 2, 3, 2, 3, 3};
//
//        List<List<Integer>> cases = new ArrayList<>();
//        cases.add(Arrays.asList(0, 3));
//        cases.add(Arrays.asList(4, 6));
//        cases.add(Arrays.asList(6, 7));
//        cases.add(Arrays.asList(3, 5));
//        cases.add(Arrays.asList(0, 7));
//
//        serviceLane(Arrays.asList(width), cases).forEach(System.out::println);


//        Integer[] chapters = {4, 2, 6, 1, 10};
//        System.out.println(workbook(5, 3, Arrays.asList(chapters)));
//
//        Integer[] chapters2 = {100};
//        System.out.println(workbook(1, 1, Arrays.asList(chapters2)));


//        int[] spaceStations1 = {0, 1, 2, 3, 4, 5};
//        System.out.println(flatlandSpaceStations(6, spaceStations1));
//
//        int[] spaceStations2 = {0, 1, 2, 4, 3, 5};
//        System.out.println(flatlandSpaceStations(6, spaceStations2));
//
//        int[] spaceStations3 = {0, 4};
//        System.out.println(flatlandSpaceStations(5, spaceStations3));
//
//        int[] spaceStations4 = {13, 1, 11, 10, 6};
//        System.out.println(flatlandSpaceStations(20, spaceStations4));


//        Integer[] citizens1 = {2, 3, 4, 5, 6};
//        System.out.println(fairRations(Arrays.asList(citizens1)));
//
//        Integer[] citizens2 = {1, 2};
//        System.out.println(fairRations(Arrays.asList(citizens2)));


//        System.out.println(stones(3, 1, 2));
//        System.out.println(stones(4, 10, 100));
        System.out.println(stones(12, 73, 82));
        System.out.println(stones(58, 69, 24));


    }
}
