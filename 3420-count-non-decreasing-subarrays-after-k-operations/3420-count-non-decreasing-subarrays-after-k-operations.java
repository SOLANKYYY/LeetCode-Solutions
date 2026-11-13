
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        Deque<int[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] p = dq.removeLast();

                count += p[1];
                cost += (long) (num - p[0]) * p[1];
            }

            dq.addLast(new int[]{num, count});

            while (cost > k) {
                int[] p = dq.removeFirst();

                cost -= (long) (p[0] - nums[j]);
                j--;

                if (p[1] > 1) {
                    dq.addFirst(new int[]{p[0], p[1] - 1});
                }
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
