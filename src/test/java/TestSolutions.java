import com.richnachos.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TestSolutions {
    @Test
    public void testEvaluateExpression() {
        Assert.assertEquals(22, Main.evaluateExpression("5+20-8+5"));
        Assert.assertEquals(25, Main.evaluateExpression("5+20"));
        Assert.assertEquals(0, Main.evaluateExpression("3-3+3-3+3-3"));
        Assert.assertEquals(1000, Main.evaluateExpression("1000"));
        Assert.assertEquals(0, Main.evaluateExpression("0"));
        Assert.assertEquals(0, Main.evaluateExpression("6-6"));
        Assert.assertEquals(0, Main.evaluateExpression(""));
        Assert.assertEquals(5000, Main.evaluateExpression("1000+1000+1000+1000+1000"));
        Assert.assertEquals(5, Main.evaluateExpression("1+2+3+4+5-10"));
    }

    @Test
    public void testNumberOfHappyStrings() {
        Assert.assertEquals(2, Main.numberOfHappyStrings(Arrays.asList("abbcc", "abc", "abcabc", "cabcbb")));
        Assert.assertEquals(0, Main.numberOfHappyStrings(Arrays.asList("aa", "abbc", "abcc", "aabbcc")));
        Assert.assertEquals(4, Main.numberOfHappyStrings(Arrays.asList("abc", "a", "b", "c")));
        Assert.assertEquals(3, Main.numberOfHappyStrings(Arrays.asList("a", "", "bb", "cba")));
        Assert.assertEquals(1, Main.numberOfHappyStrings(Collections.singletonList("a")));
        Assert.assertEquals(1, Main.numberOfHappyStrings(Arrays.asList("aaaaa", "bbbbbbb", "ccccccccc", "abcbacbabcabacbac")));
        Assert.assertEquals(0, Main.numberOfHappyStrings(Collections.emptyList()));
    }

    @Test
    public void testReverseList() {
        Main.ListNode head = new Main.ListNode(0);
        Main.ListNode prev = head;
        for (int i = 1; i < 5; i++) {
            prev.next = new Main.ListNode(i);
            prev = prev.next;
        }
        // List is 0->1->2->3->4

        Main.ListNode reversed = Main.reverseList(head);
        // Reversed should be 4->3->2->1->0

        Main.ListNode curr = reversed;
        for (int i = 4; i >= 0; i--) {
            Assert.assertNotNull(curr);
            Assert.assertEquals(i, curr.value);
            curr = curr.next;
        }
        Assert.assertNull(curr);

        // Second test on size 1 linked list
        head = new Main.ListNode(10);
        reversed = Main.reverseList(head);

        Assert.assertNotNull(reversed);
        Assert.assertEquals(10, reversed.value);
        Assert.assertNull(reversed.next);


        // Third test on size 0 linked list (null)
        Assert.assertNull(Main.reverseList(null));
    }

    @Test
    public void testFindIntersection() {
        int[] nums1 = {1, 2, 3, 3, 4, 5};
        int[] nums2 = {3, 4, 4, 5, 6, 7};
        int[] result = {3, 4, 5};
        Assert.assertArrayEquals(result, Main.findIntersection(nums1, nums2));

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{3, 4, 5};
        result = new int[]{3};
        Assert.assertArrayEquals(result, Main.findIntersection(nums1, nums2));

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{4, 5, 6};
        result = new int[]{};
        Assert.assertArrayEquals(result, Main.findIntersection(nums1, nums2));

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{1, 2, 3};
        result = new int[]{1, 2, 3};
        Assert.assertArrayEquals(result, Main.findIntersection(nums1, nums2));

        nums1 = new int[]{1, 2, 3};
        nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
        result = new int[]{1, 2, 3};
        Assert.assertArrayEquals(result, Main.findIntersection(nums1, nums2));
    }

    @Test
    public void testLenOfLongSubarr() {
        Assert.assertEquals(4, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 8));
        Assert.assertEquals(6, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 18));
        Assert.assertEquals(2, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 3));
        Assert.assertEquals(2, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 4));
        Assert.assertEquals(3, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 5));
        Assert.assertEquals(3, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 6));
        Assert.assertEquals(3, Main.lenOfLongSubarr(new int[]{6,2,2,3,4,1}, 7));
    }

    @Test
    public void testIsValidSequence() {
        Assert.assertTrue(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{1,6,-1,10}));
        Assert.assertFalse(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{1,5,-1,10}));
        Assert.assertTrue(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{5,1,22,25,6,-1,8,10}));
        Assert.assertTrue(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{-1}));
        Assert.assertTrue(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{5,10}));
        Assert.assertTrue(Main.isValidSequence(new int[]{5,1,22,25,6,-1,8,10}, new int[]{}));
    }
}
