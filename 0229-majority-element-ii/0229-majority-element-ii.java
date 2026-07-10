class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int count1 = 0 , count2 = 0;
        int ele1=0 , ele2=0;
        for(int i=0 ; i<n ; i++){
            
            if(nums[i] == ele1){
                count1++;
            }
            else if( nums[i] == ele2){
                count2++;
            }
            else if(count1 == 0 ){
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 ){
                count2 = 1;
                ele2 = nums[i];
            }

            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
       for(int num : nums){
        if(num == ele1){
            count1++;
        }
        else if(num == ele2){
            count2++;
        }
       }
       if(count1 > (n/3)){
        list.add(ele1);
       }
       if(count2 > (n/3)){
        list.add(ele2);
       }

        return list;
    }
}