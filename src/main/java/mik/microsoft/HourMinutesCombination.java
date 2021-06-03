package mik.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/*
*
Given a generic digital clock, having h number of hours and m number of minutes, the task is to find how many times the clock shows identical time.
The parameters were 4 integers A,B,C,D. The valid time should be somewhere between 00:00 and 24:00.
If the integers don't fulfil the requirements the function should return 0.

Restrictions: A,B,C,D are integers between [0,9]

public static int solve(int A, int B, int C, int D) {
//return the count of how many variants are there to combine the four integers so its a valid hour
// from 00:00 to 24:00
}

Testcase#1 (1,0,0,2) => (00:12) (00:21) (01: 02) (01:20) (02:10) (02:01) (10:02) (10:20) (12:00) (20:01) (20:10) (21:00) => should return 12
Testcase#2 (2,1,2,1) => should return 6
Testcase#3 (1,4,8,2) => should return 5
Testcase#4 (4,4,4,4) => should return 0
* */
public class HourMinutesCombination {
    public static void main(String[] args) {
        System.out.println(possibleHoursVariations(8,0,0,2));
    }
    public static int possibleHoursVariations(int A, int B, int C, int D) {
        int[] arr = new int[]{A, B, C, D};
        HashMap<Integer, HashSet<Integer>> savedHours = new HashMap<Integer, HashSet<Integer>>();
        Arrays.sort(arr);
        int count = 0;

        if (arr[0] > 2 || arr[0] == 2 && arr[1] > 4) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                boolean[] taken = new boolean[4];
                boolean first = true;
                taken[i] = true;
                taken[j] = true;
                int firstDigitOfMins = 0, secondDigitOfMins = 0;

                for (int k = 0; k < 4; k++) {
                    if (!taken[k]) {
                        if (first) {
                            firstDigitOfMins = arr[k];
                            first = false;
                        } else {
                            secondDigitOfMins = arr[k];
                        }
                        taken[k] = true;
                    }
                }
                int minutes = getDecimalValue(firstDigitOfMins, secondDigitOfMins);
                int minutesReverse = getDecimalValue(secondDigitOfMins, firstDigitOfMins);
                int hours = getDecimalValue(arr[i], arr[j]);

                if (isValidTime(minutes, hours)) {
                    if (!savedHours.containsKey(hours)) {
                        savedHours.put(hours, new HashSet<Integer>() {
                            {
                                add(minutes);
                            }
                        });

                        count++;
                    }
                }
                if (isValidTime(minutesReverse, hours)) {
                    if (!savedHours.get(hours).contains(minutesReverse)
                            && savedHours.get(hours).contains(minutes)) {
                        count++;
                        savedHours.get(hours).add(minutesReverse);
                    }
                }
            }
        }
        return count;
    }

    private static int getDecimalValue(int firstDigitOfMins, int secondDigitOfMins) {
        return 10 * firstDigitOfMins + secondDigitOfMins;
    }

    private static boolean isValidTime(int minutesReverse, int hours) {
        return hours < 24 && minutesReverse < 60 || hours == 24 && minutesReverse == 0;
    }
}
