class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int f = freq.get(num);

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }

            buckets[f].add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        for (int f = nums.length; f >= 1 && index < k; f--) {

            if (buckets[f] != null) {

                for (int num : buckets[f]) {
                    ans[index++] = num;

                    if (index == k) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}
