class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> x;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.x = new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        if(!x.containsKey(key)) return -1;
        return x.get(key);   
    }
    
    public void put(int key, int value) {
        if(x.containsKey(key)) x.put(key,value);
        else{
            if(x.size()==this.capacity){
                int fkey=x.keySet().iterator().next();
                x.remove(fkey);
            }
            x.put(key,value);
        }
    }
}