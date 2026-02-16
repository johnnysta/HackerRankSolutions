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


    //HackerRank Happy Ladybugs problem solution
    public static String happyLadybugs(String b) {
        boolean hasSpace = false;
        boolean isHappyInitially = true;
        String stringToCheck = "*" + b + "*";
        Map<Character, Integer> ladybugMap = new HashMap<>();

        for (int i = 1; i < stringToCheck.length() - 1; i++) {
            Integer prevValue = ladybugMap.put(stringToCheck.charAt(i), 1);
            if (prevValue != null) {
                ladybugMap.put(stringToCheck.charAt(i), prevValue + 1);
            }
            if (isHappyInitially
                    && stringToCheck.charAt(i - 1) != stringToCheck.charAt(i)
                    && stringToCheck.charAt(i) != stringToCheck.charAt(i + 1)) {
                isHappyInitially = false;
            }
        }

        if (isHappyInitially) return "YES";

        for (Character key : ladybugMap.keySet()) {
            if (ladybugMap.get(key) == 1 && !key.equals('_')) {
                return "NO";
            } else if (key.equals('_')) {
                hasSpace = true;
            }
        }

        return (hasSpace) ? "YES" : "NO";
    }


    //HackerRank Strange Counter problem solution
    public static long strangeCounter(long t) {
        long cycleMax = 3;
        long timeCounter = 0;
        while (timeCounter < t) {
            timeCounter += cycleMax;
            cycleMax = cycleMax * 2;
        }
        long remainingTime = t - (timeCounter - cycleMax / 2);
        return cycleMax / 2 - remainingTime + 1;
    }


    //HackerRank Super Reduced String problem solution
    public static String superReducedString(String s) {
        int sameStartIndex = findAdjacentSameChars(s);
        while (sameStartIndex != -1 && s.length() > 0) {
            s = replaceToNothing(s, sameStartIndex);
            sameStartIndex = findAdjacentSameChars(s);
        }
        return (s.length() > 0) ? s : "Empty String";
    }

    private static String replaceToNothing(String s, int sameStartIndex) {
        String reducedString = ((sameStartIndex > 0) ? s.substring(0, sameStartIndex) : "")
                + ((sameStartIndex + 2 <= s.length() - 1) ? s.substring(sameStartIndex + 2) : "");
        return reducedString;
    }

    private static int findAdjacentSameChars(String s) {
        if (s.length() < 2) return -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }


    //HackerRank Encryption problem solution
    public static String encryption(String s) {
        String cleanedInput = s.replaceAll(" ", "");
        int length = cleanedInput.length();
        double lengthSqrt = Math.sqrt(length);
        int lowValue = (int) lengthSqrt;
        int upperValue = (lengthSqrt % 1 == 0) ? lowValue : lowValue + 1;
        int columns = upperValue;
        int rows = (lowValue * upperValue >= length) ? lowValue : upperValue;
        char[][] charArray = new char[rows][columns];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                charArray[y][x] = (cleanedInput.length() > y * columns + x) ? cleanedInput.charAt(y * columns + x) : ' ';
            }
        }

        StringBuilder encryptBuilder = new StringBuilder();
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
                if (charArray[y][x] != ' ') {
                    encryptBuilder.append(charArray[y][x]);
                }
            }
            encryptBuilder.append(" ");
        }

        return encryptBuilder.toString();
    }

    //HackerRank The Power Sum problem solution
    //Iterating through the possible sum combinations with the help of a binary masking number (its value: 2^maxBase)
    public static int powerSum(int X, int N) {
        int numOfWays = 0;
        int maxBase = (int) Math.pow(X, (1.0 / N));
        long maskingNum = (long) Math.pow(2, maxBase);
        for (long i = 1; i <= maskingNum; i++) {
            int currentSum = 0;
            for (int j = maxBase; j >= 1; j--) {
                long bit = (i >> (j - 1)) & 1;
                currentSum += Math.pow((bit * j), N);
                if (currentSum > X) {
                    break;
                }
            }
            if (currentSum == X) {
                numOfWays++;
            }
        }
        return numOfWays;
    }


    //Sample for a recursive iteration for all possible values of a binary number
    public static void iterateBinary(int N, int index, String prefix) {
        // Base case: if we have generated N bits, print the binary number
        if (index == N) {
            System.out.println(prefix);
            return;
        }
        // Recursive case: append 0 or 1 to the prefix and recursively generate the rest of the bits
        iterateBinary(N, index + 1, prefix + "0");
        iterateBinary(N, index + 1, prefix + "1");
    }


    //HackerRank The Power Sum problem solution with recursion
    //(iterating through the possible sum combinations with the help of a recursive function)
    public static int powerSum2(int X, int N) {
        int numOfSolutions = 0;
        int maxBase = (int) Math.pow(X, (1.0 / N));
        return powerSumRecursion(maxBase, N, 0, numOfSolutions, 0, X);
    }

    public static int powerSumRecursion(int range, int index, int currentBase, int numOfSolutions, int currentSum, int desiredSum) {
        if (currentSum > desiredSum) {
            return numOfSolutions;
        }
        if (currentBase == range) {
            if (currentSum == desiredSum) {
                numOfSolutions++;
            }
            return numOfSolutions;
        }
        numOfSolutions = powerSumRecursion(range, index, currentBase + 1, numOfSolutions, currentSum, desiredSum);
        numOfSolutions = powerSumRecursion(range, index, currentBase + 1, numOfSolutions,
                currentSum + (int) Math.pow(currentBase + 1, index), desiredSum);
        return numOfSolutions;
    }

    //HackerRank CamelCase problem solution
    public static int camelcase(String s) {
        int numOfWords = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                numOfWords++;
            }
        }
        return numOfWords;
    }

    //HackerRank Strong Password problem solution with sets
    public static int minimumNumber(int n, String password) {
        Set<Character> numbersSet = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        Set<Character> lowerCaseSet = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Set<Character> upperCaseSet = Set.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        Set<Character> specialCharsSet = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');
        int numOfNumbers = 0;
        int numOfLowerCases = 0;
        int numOfUpperCases = 0;
        int numOfSpecials = 0;

        for (int i = 0; i < password.length(); i++) {
            char currChar = password.charAt(i);
            numOfNumbers += numbersSet.contains(currChar) ? 1 : 0;
            numOfLowerCases += lowerCaseSet.contains(currChar) ? 1 : 0;
            numOfUpperCases += upperCaseSet.contains(currChar) ? 1 : 0;
            numOfSpecials += specialCharsSet.contains(currChar) ? 1 : 0;
        }

        int charsRequired = 0;
        charsRequired += (numOfNumbers == 0) ? 1 : 0;
        charsRequired += (numOfLowerCases == 0) ? 1 : 0;
        charsRequired += (numOfUpperCases == 0) ? 1 : 0;
        charsRequired += (numOfSpecials == 0) ? 1 : 0;

        int charsRequiredByNumber = 6 - n;

        if ((charsRequiredByNumber) > 0) {
            return (charsRequiredByNumber > charsRequired) ? charsRequiredByNumber : charsRequired;
        } else {
            return charsRequired;
        }
    }

    //HackerRank Big Sorting problem solution
    public static List<String> bigSorting(List<String> unsorted) {
        unsorted.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o2.length() > o1.length()) {
                return -1;
            }
            return o1.compareTo(o2);
        });
        return unsorted;
    }


    //HackerRank The Time in Words problem solution
    static String timeInWords(int h, int m) {
        StringBuilder builder = new StringBuilder();

        String[] hours = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve"};
        String[] minutes = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine", "thirty"};

        if (m > 30) {
            h++;
        }
        builder.append(hours[h - 1]);

        if (m == 0)
            builder.append(" o' clock");
        else if (m == 1)
            builder.insert(0, minutes[m - 1] + " minute past ");
        else if (m == 15)
            builder.insert(0, "quarter past ");
        else if (m < 30)
            builder.insert(0, minutes[m - 1] + " minutes past ");
        else if (m == 30)
            builder.insert(0, "half past ");
        else if (m == 45)
            builder.insert(0, "quarter to ");
        else if (m > 30 && m < 59)
            builder.insert(0, minutes[60 - m - 1] + " minutes to ");
        else
            builder.insert(0, minutes[60 - m - 1] + " minute to ");

        return builder.toString();
    }

    //HackerRank Two Characters problem solution
    public static int alternate(String s) {

        //count the characters, and store the values in an array
        int[] charCounts = new int[('z' - 'a') + 1];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        //create possible char combinations
        ArrayList<String> charCombinations = new ArrayList<>();
        for (int i = 0; i < charCounts.length - 1; i++) {
            for (int j = i + 1; j < charCounts.length; j++) {
                if (charCounts[i] > 0 && charCounts[j] > 0 && Math.abs(charCounts[i] - charCounts[j]) <= 1) {
                    charCombinations.add(Character.toString('a' + i) + Character.toString('a' + j));
                }
            }
        }

        //removing all unnecessary chars from testString
        int maxLength = 0;

        for (String charCombination : charCombinations) {
            String testString = s;

            for (int i = 0; i < charCounts.length; i++) {
                if ((charCounts[i] > 0) && charCombination.indexOf((char) ('a' + i)) == -1) {
                    testString = testString.replaceAll(String.valueOf((char) ('a' + i)), "");
                }
            }

            if (checkAlternation(charCombination, testString)) {
                maxLength = Math.max(maxLength, testString.length());
            }
        }
        return maxLength;
    }

    public static boolean checkAlternation(String charCombination, String testString) {
        char curChar = testString.charAt(0);
        for (int i = 1; i < testString.length(); i++) {
            if (curChar == testString.charAt(i)) {
                return false;
            }
            curChar = testString.charAt(i);
        }
        return true;
    }

    //HackerRank HackerRank in a String! problem solution
    public static String hackerrankInString(String s) {
        String hackerrankString = "hackerrank";
        int curPos = 0;
        boolean found = false;
        for (int i = 0; i < hackerrankString.length() - 1; i++) {
            char curChar = hackerrankString.charAt(i);
            found = false;
            while (!found && curPos < s.length()) {
                if (s.charAt(curPos) == curChar) {
                    found = true;
                }
                curPos++;
            }
        }
        return found ? "YES" : "NO";
    }


    //HackerRank "Weighted Uniform Strings" problem solution
    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        Map<Character, Integer> charWeights = new HashMap<>();
        Set<Integer> substringWeights = new HashSet<>();
        List<String> results = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            charWeights.put(c, c - 'a' + 1);
        }

        int i = 0;
        int substringWeight = 0;
        while (i < s.length()) {
            substringWeight += charWeights.get(s.charAt(i));
            substringWeights.add(substringWeight);
            if ((i + 1 < s.length()) && (s.charAt(i) !=  s.charAt(i + 1))) {
                substringWeight = 0;
            }
            i++;
        }

        for (int i1 = 0; i1 < queries.size(); i1++) {
            results.add(substringWeights.contains(queries.get(i1)) ? "Yes" : "No");
        }

        return results;
    }

    //HackerRank "Pangrams" problem solution
    public static String pangrams(String s) {

        String lowerCaseS = s.toLowerCase();
        for (char c = 'a'; c <= 'z'; c++) {
            if (! lowerCaseS.contains(String.valueOf(c))){
                return "not panagram";
            }
        }

        return "panagram";

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
//        int[][] inputArray = {{78, 72}, {67, 74}, {65, 57}, {65, 52}, {70, 55}, {74, 70}, {58, 51}, {70, 76},
//                {69, 55}, {64, 78}, {67, 72}, {69, 63}, {77, 59}, {69, 64}, {70, 80}, {66, 67},
//                {71, 52}, {60, 77}, {80, 66}, {70, 61}};
//        int[] result = maxCircle2(inputArray);
//        for (int i : result) {
//            System.out.println(i);
//        }

//        System.out.println(happyLadybugs("AABBC"));
//        System.out.println(happyLadybugs("AABBC_C"));
//        System.out.println(happyLadybugs("_"));
//        System.out.println(happyLadybugs("DD__FQ_QQF"));
//        System.out.println(happyLadybugs("AABCBC"));
//        System.out.println(happyLadybugs("AABBCC"));

//        System.out.println(strangeCounter(1));


//        System.out.println(superReducedString("baab"));

//        System.out.println(encryption("have a nice day"));
//        System.out.println(encryption("feed the dog"));
//        System.out.println(encryption("chillout"));


//        System.out.println(powerSum(10, 2));
//        System.out.println(powerSum(25, 2));
//        System.out.println(powerSum(100, 3));
//        System.out.println(powerSum(400, 2));


//        iterateBinary(31, 0, "");

//        System.out.println(powerSum2(10, 2));
//        System.out.println(powerSum2(25, 2));
//        System.out.println(powerSum(100, 3));
//        System.out.println(powerSum(400, 2));

//        System.out.println(camelcase("saveChangesInTheEditor"));


//        System.out.println(minimumNumber(11, "#HackerRank"));
//        System.out.println(minimumNumber(3, "Ab1"));
//        System.out.println(minimumNumber(5, "2bbbb"));
//        System.out.println(minimumNumber(5, "2bb#A"));


//        String[] numstringArray1 = {"6", "31415926535897932384626433832795", "1", "3", "10", "3", "5"};
//        for (String s : bigSorting(Arrays.asList(numstringArray1))) {
//            System.out.println(s);
//        }
//
//        String[] numstringArray2 = {"1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"};
//        for (String s : bigSorting(Arrays.asList(numstringArray2))) {
//            System.out.println(s);
//        }
//
//        System.out.println(timeInWords(3, 0));
//        System.out.println(timeInWords(3, 15));
//        System.out.println(timeInWords(3, 45));
//        System.out.println(timeInWords(3, 1));
//        System.out.println(timeInWords(3, 59));
//        System.out.println(timeInWords(3, 10));
//
//        System.out.println(timeInWords(3, 22));
//        System.out.println(timeInWords(3, 55));
//        System.out.println(timeInWords(3, 38));
//        System.out.println(timeInWords(3, 47));
//        System.out.println(timeInWords(3, 59));
//        System.out.println(timeInWords(7, 29));


//        System.out.println(alternate("beabeefeab"));
//
//
//        System.out.println(alternate("uyetuppelecblwipdsqabzsvyfaezeqhpnalahnpkdbhzjglcuqfjnzpmbwprelbayyzovkhacgrglrdpmvaexkgertilnfooeazvulykxypsxicofnbyivkthovpjzhpohdhuebazlukfhaavfsssuupbyjqdxwwqlicbjirirspqhxomjdzswtsogugmbnslcalcfaxqmionsxdgpkotffycphsewyqvhqcwlufekxwoiudxjixchfqlavjwhaennkmfsdhigyeifnoskjbzgzggsmshdhzagpznkbahixqgrdnmlzogprctjggsujmqzqknvcuvdinesbwpirfasnvfjqceyrkknyvdritcfyowsgfrevzon"));

//        System.out.println(hackerrankInString("hhaacckkekraraannk"));
//        System.out.println(hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"));


//        Integer[] queries = {9, 7, 8, 12, 5};
//        String input = "aaabbbbcccddd";
//        for (String s : weightedUniformStrings(input, Arrays.asList(queries))) {
//            System.out.println(s);
//        }

//        Integer[] queries = {1, 3, 12, 5, 9, 10};
//        String input = "abccddde";
//        for (String s : weightedUniformStrings(input, Arrays.asList(queries))) {
//            System.out.println(s);
//        }

//        Integer[] queries = {1, 7, 5, 4, 15};
//        String input = "abbcccdddd";
//        for (String s : weightedUniformStrings(input, Arrays.asList(queries))) {
//            System.out.println(s);
//        }


        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));

    }
}
