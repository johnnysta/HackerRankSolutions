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


    //HackerRank Ice Cream Parlor problem solution - to slow for bigger inputs
    public static void whatFlavors1(List<Integer> cost, int money) {
        for (int i = 0; i < cost.size(); i++) {
            for (int j = i + 1; j < cost.size(); j++) {
                if (cost.get(i) + cost.get(j) == money) {
                    System.out.println((i + 1) + " " + (j + 1));
                    break;
                }
            }
        }
    }

    //HackerRank Ice Cream Parlor problem solution - fast enough
    public static void whatFlavors(List<Integer> cost, int money) {
        HashMap<Integer, Integer> costsMap = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            costsMap.put(cost.get(i), i);
        }
        int firstIndex = -1;
        Integer otherIndex = -1;
        for (int i = 0; i < cost.size(); i++) {
            firstIndex = i;
            if (((otherIndex = costsMap.get(money - cost.get(i))) != null) && otherIndex != firstIndex) {
                break;
            }
        }
        System.out.println((firstIndex + 1) + " " + (otherIndex + 1));
    }


    //HackerRank Flipping bits problem solution
    public static long flippingBits(long n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result += Math.pow(2, i) * ((n % 2 == 1) ? 0 : 1);
            n = n / 2;
        }
        return result;
    }

    //HackerRank Time Complexity: Primality problem solution
    public static String primality(int n) {
        if (n == 0 || n == 1) {
            return "Not prime";
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }

    //HackerRank Friend Circle Queries problem solution
    static int[] maxCircle(int[][] queries) {
        int[] result = new int[queries.length];
        int maxCircle = 2;
        List<HashSet<Integer>> friendsCircles = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int firstPerson = queries[i][0];
            int secondPerson = queries[i][1];
            int firstPersonsFriendsIndex = findFriendsCircle(friendsCircles, firstPerson);
            int secondPersonsFriendsIndex = findFriendsCircle(friendsCircles, secondPerson);
            if (firstPersonsFriendsIndex != -1) {
                if (secondPersonsFriendsIndex != -1) {
                    if (firstPersonsFriendsIndex != secondPersonsFriendsIndex) {
//                        friendsCircles.get(firstPersonsFriendsIndex).addAll(friendsCircles.get(secondPersonsFriendsIndex));
                        friendsCircles.set(firstPersonsFriendsIndex, optimizedUnion(friendsCircles.get(firstPersonsFriendsIndex),
                                friendsCircles.get(secondPersonsFriendsIndex)));
                        int currentSetSize = friendsCircles.get(firstPersonsFriendsIndex).size();
                        if (currentSetSize > maxCircle) {
                            maxCircle = currentSetSize;
                        }
                        friendsCircles.remove(secondPersonsFriendsIndex);
                    }
                } else {
                    friendsCircles.get(firstPersonsFriendsIndex).add(secondPerson);
                    int currentSetSize = friendsCircles.get(firstPersonsFriendsIndex).size();
                    if (currentSetSize > maxCircle) {
                        maxCircle = currentSetSize;
                    }

                }
            } else {
                if (secondPersonsFriendsIndex != -1) {
                    friendsCircles.get(secondPersonsFriendsIndex).add(firstPerson);
                    int currentSetSize = friendsCircles.get(secondPersonsFriendsIndex).size();
                    if (currentSetSize > maxCircle) {
                        maxCircle = currentSetSize;
                    }
                } else {
                    friendsCircles.add(new HashSet<>(Arrays.asList(firstPerson, secondPerson)));
                }
            }
            result[i] = maxCircle;
        }
        return result;
    }

    private static HashSet<Integer> optimizedUnion(HashSet<Integer> first, HashSet<Integer> second) {
        if (first.size() >= second.size()) {
            first.addAll(second);
            return first;
        } else {
            second.addAll(first);
            return second;
        }
    }

    private static int findFriendsCircle(List<HashSet<Integer>> friendsCircles, int number) {
        for (int i = 0; i < friendsCircles.size(); i++) {
            if (friendsCircles.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }


    //HackerRank Friend Circle Queries problem solution - better time complexity
    static int[] maxCircle2(int[][] queries) {
        int[] result = new int[queries.length];
        int maxCircle = 0;
        Map<Integer, HashSet<Integer>> friendsCircles = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int firstPerson = queries[i][0];
            int secondPerson = queries[i][1];
            HashSet<Integer> firstPersonsSet = findFriendsSet(friendsCircles, firstPerson);
            HashSet<Integer> secondPersonsSet = findFriendsSet(friendsCircles, secondPerson);
            if (firstPersonsSet != secondPersonsSet) {
                firstPersonsSet.addAll(secondPersonsSet);
                for (Integer person : secondPersonsSet) {
                    friendsCircles.put(person, firstPersonsSet);
                }
                if (maxCircle < firstPersonsSet.size()) {
                    maxCircle = firstPersonsSet.size();
                }
            }
            result[i] = maxCircle;
        }
        return result;
    }

    private static HashSet<Integer> findFriendsSet(Map<Integer, HashSet<Integer>> friendsCircles, int person) {
        HashSet<Integer> friendsSet = friendsCircles.get(person);
        if (friendsSet == null) {
            friendsSet = new HashSet<>();
            friendsSet.add(person);
            friendsCircles.put(person, friendsSet);
        }
        return friendsSet;
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
//        System.out.println(stones(12, 73, 82));
//        System.out.println(stones(58, 69, 24));

//        Integer[] cost1 = {1, 4, 5, 3, 2};
//        whatFlavors(Arrays.asList(cost1), 4);
//        Integer[] cost2 = {2, 2, 4, 3};
//        whatFlavors(Arrays.asList(cost2), 4);
//        Integer[] cost3 = {4, 3, 2, 5, 7};
//        whatFlavors(Arrays.asList(cost3), 8);


//        System.out.println(flippingBits(0));

//        System.out.println(primality(986939521));


//        int[][] inputArray = {{1, 2}, {1, 3}};
//        int[][] inputArray = {{1000000000, 23},{11, 3778}, {7, 47}, {11, 1000000000}};
//        int[][] inputArray = {{1, 2}, {3, 4}, {1, 3}, {5, 7}, {5, 6}, {7, 4}};
        int[][] inputArray = {{78, 72}, {67, 74}, {65, 57}, {65, 52}, {70, 55}, {74, 70}, {58, 51}, {70, 76},
                {69, 55}, {64, 78}, {67, 72}, {69, 63}, {77, 59}, {69, 64}, {70, 80}, {66, 67},
                {71, 52}, {60, 77}, {80, 66}, {70, 61}};
        int[] result = maxCircle2(inputArray);
        for (int i : result) {
            System.out.println(i);
        }


    }
}
