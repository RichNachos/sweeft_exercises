package com.richnachos;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static int evaluateExpression(String expression) {
        if (expression.isEmpty()) {
            return 0;
        }

        int ret = 0;
        // Note: I used regex here to not get rid of the delimiters, which I use to calculate the expression
        String[] tokens = expression.split("(?<=[+])|(?=[+])|(?<=-)|(?=-)");

        ret += Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length - 1; i += 2) {
            char delimiter = tokens[i].charAt(0);
            int number = Integer.parseInt(tokens[i+1]);

            switch (delimiter) {
                case '+':
                    ret += number;
                    break;
                case '-':
                    ret -= number;
                    break;
            }
        }

        return ret;
    }

    public static int numberOfHappyStrings(List<String> strings) {
        int happyStrings = strings.size();

        for (String str : strings) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    happyStrings--;
                    break;
                }
            }
        }

        return happyStrings;
    }

    public static ListNode reverseList(ListNode head) {
        // Simple linked list reversal algorithm
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        // Using sets is quicker for checking elements than an array. O(1) for sets, O(n) for arrays
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> intersection = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                continue;
            }
            intersection.add(num);
        }

        return intersection.stream().mapToInt(n->n).toArray();
    }

    public static int lenOfLongSubarr(int[] array, int k) {
        // Recursive approach to solving this problem
        // Note: this problem is possibly NP hard
        if (k <= 0 || array.length == 0) {
            return 0;
        }

        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 1, newArray, 0, newArray.length);

        return Math.max(
                lenOfLongSubarr(newArray, k),
                lenOfLongSubarr(newArray, k - array[0]) + 1
        );
    }

    public static boolean isValidSequence(int[] array, int[] sequence) {
        int j = 0;
        for (int i = 0; i < array.length && j < sequence.length; i++) {
            if (sequence[j] == array[i]) {
                j++;
            }
        }
        return j == sequence.length;
    }

    public static void main(String[] args) { }
}