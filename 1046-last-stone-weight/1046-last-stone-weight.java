class Solution {
    public int lastStoneWeight(int[] stones) {
        int largest = 0;
        int secondlargest = 0;
        
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       for(int ele : stones){
            pq.add(ele);
        }
       while(pq.size() > 1){
        largest = pq.remove();
        secondlargest = pq.remove();
        int difference = largest - secondlargest;
        if(difference > 0){
            pq.add(difference);
        }
       }
       if(pq.size() == 0){
        return 0;
       }
       
        return pq.remove();

    }
}