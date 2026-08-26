class Solution {
    public boolean lemonadeChange(int[] bills) {
       int five = 0, ten = 0, twenty = 0;
       for(int i=0 ; i<bills.length ; i++){
        if(bills[i] == 5){
            five += 1;
        }
        else if(bills[i] == 10){
            if(five != 0){
                ten += 1;
                five -= 1;
            }
            else{
                return false;
            }
        }
        else{
            if(five !=0 && ten !=0){
               ten -= 1;
               five -= 1;
               twenty += 1;
            }
            else if(five >= 3){
                five -= 3;
                twenty += 1;
            }
            else {
                return false;
            }
        }
       } 
       return true;
    }
}