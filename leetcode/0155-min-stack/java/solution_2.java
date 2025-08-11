class MinStack {

    private List<Integer> stack;
    private Map<Integer, Integer> minimumMap;
    private int stackPointer;
    private int min;
    
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minimumMap = new HashMap<>();
        this.stackPointer = -1;
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        this.stackPointer++;
        if (this.stack.size() > this.stackPointer) {
            this.stack.set(this.stackPointer, val);
        } else {
            this.stack.add(val);
        }

        if (this.stackPointer == 0 || val <= this.min) {
            this.min = val;
        }

        this.minimumMap.put(stackPointer, min);
        //System.out.println("push: sp: " + this.stackPointer + ". list: " + this.stack + ". map: " + this.minimumMap);
    }
    
    public void pop() {
        this.minimumMap.remove(this.stackPointer);
        this.stackPointer--;
        if (this.stackPointer < 0) {
            this.min = Integer.MAX_VALUE;
        } else {
            this.min = minimumMap.get(this.stackPointer);
        }
        
        //System.out.println("pop: sp: " + this.stackPointer + ". list: " + this.stack + ". map: " + this.minimumMap);
    }
    
    public int top() {
        if (this.stackPointer < 0 || this.stack.isEmpty()) {
            throw new RuntimeException("Stack empty");
        }

        //System.out.println("top: sp: " + this.stackPointer + ". list: " + this.stack + ". map: " + this.minimumMap);
        return this.stack.get(this.stackPointer);
    }
    
    public int getMin() {
        //System.out.println("getMin: sp: " + this.stackPointer + ". list: " + this.stack + ". map: " + this.minimumMap);
        return minimumMap.get(this.stackPointer);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */