class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int end;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.end = 0;
        this.random = new Random();
    }
    
    public boolean insert(int val) {

        //System.out.println("insert: end: " + end + ", list: " + list);
        if (this.map.containsKey(val)) {
            return false;
        }

        if (this.end < list.size()) {
            this.list.set(this.end++, val);
        } else {
            this.list.add(val);
            this.end = list.size();
        }
        this.map.put(val, end-1);

        //System.out.println("insert: list: " + list);

        return true;
    }
    
    public boolean remove(int val) {

        if (!this.map.containsKey(val)) {
            return false;
        }

        int valIndex = this.map.get(val);
        int lastElement = this.list.get(end-1);

        //System.out.println("remove: valIndex: " + valIndex + ", lastElement: " + lastElement + ", list: " + list);

        this.list.set(valIndex, lastElement);
        this.list.set(end-1, val);
        end--;

        map.put(lastElement, valIndex);
        map.remove(val);

        //System.out.println("remove: list: " + list);

        return true;
    }
    
    public int getRandom() {

        //System.out.println("getRandom: list: " + list);

        int randomIndex = random.nextInt(end);
        int val = list.get(randomIndex);
        
        //System.out.println("rand: " + rand +",[" + randomIndex + "]: " + val);

        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */