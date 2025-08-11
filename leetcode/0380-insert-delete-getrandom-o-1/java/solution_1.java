class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int end;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {

        //System.out.println("insert: list before: " + list);
        if (this.map.containsKey(val)) {
            return false;
        }

        this.map.put(val, list.size());
        this.list.add(val);
        
        //System.out.println("insert: list after: " + list);

        return true;
    }
    
    public boolean remove(int val) {

        if (!this.map.containsKey(val)) {
            return false;
        }

        //System.out.println("remove: list before: " + list);

        int valIndex = this.map.get(val);

        if (valIndex < (list.size() - 1)) {
            int lastElement = this.list.get(list.size() - 1);
            this.list.set(valIndex, lastElement);
            map.put(lastElement, valIndex);
        }
        
        map.remove(val);
        list.remove(list.size() - 1);

        //System.out.println("remove: list after: " + list);

        return true;
    }
    
    public int getRandom() {

        //System.out.println("getRandom: list: " + list);

        int randomIndex = random.nextInt(list.size());
        int val = list.get(randomIndex);
        
        //System.out.println("[" + randomIndex + "]: " + val);

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