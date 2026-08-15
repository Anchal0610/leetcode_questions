class MinStack {
    ArrayDeque<Long> s;
    long min;

    public MinStack() {
        s = new ArrayDeque<>();
        min = Long.MAX_VALUE;
        
    }
    
    public void push(int value) {
        long val = value;
        if(s.isEmpty()){
            min = val;
            s.push(val);
        }
        else if(val > min){
            s.push(val);
        }
        else{
            s.push(2*val - min);
            min = val;
        }
    }
    
    public void pop() {
        if(s.isEmpty()){
            return;
        }
        long x = s.peek();
        s.pop();
        if(x < min){
        min = (2*min - x);
        }
    }
    
    public int top() {
        if(s.isEmpty()){
            return -1;
        }
        long x = s.peek();
        if(min < x){
            return (int)x;
        }
        return (int)min;
        
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */