class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> x=new Stack<>();
        for(int i : asteroids){
            if(i>0) x.push(i);
            else{
                while(!x.isEmpty() && x.peek()>0 && x.peek()<Math.abs(i)){
                    x.pop();
                }
                if(x.isEmpty() || x.peek()<0) x.push(i);
                else if(x.peek()==Math.abs(i)) x.pop();
            }
        }
        int[] ans=new int[x.size()];
        for(int i=x.size()-1;i>=0;i--) ans[i] = x.pop();
        return ans;
    }
}