class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int ans = 0;
        for(int num : set){
            if(!set.contains(num - 1)){

                int curr = num;
                int length = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    length++;
                }

                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}
