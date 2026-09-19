class Solution {
    static class Card{
        int card ; 
        int count;
        Card(int card , int count){
            this.card = card;
            this.count = count;
        }
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        if(groupSize == 1) return true;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<hand.length ; i++){
            map.put(hand[i] , map.getOrDefault(hand[i] , 0)+1);
        }
        PriorityQueue<Card> pq = new PriorityQueue<>(new Comparator<Card>(){
            public int compare(Card c1 , Card c2){
                return Integer.compare(c1.card , c2.card);
            }
        });
        for(int key : map.keySet()){
            pq.add(new Card (key , map.get(key)));
        }
        while(!pq.isEmpty()){
            Card c = pq.remove();

            Queue<Card> q = new LinkedList<>();
            c.count--;
            for(int i = 1; i < groupSize; i++){

            if(pq.isEmpty() || c.card + i != pq.peek().card){
          return false;
    }

    Card curr = pq.remove();
    curr.count--;

    if(curr.count > 0){
        q.add(curr);
    }
}
            while(!q.isEmpty()){
                pq.add(q.remove());
            }
            if(c.count >=1) {
                pq.add(c);
            }
        }
        return true;
    }
}