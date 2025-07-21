
//date-16-jul-2025
//link-https://leetcode.com/problems/asteroid-collision/description/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
       /* for(int i=0;i<n;i++){
            int cur_asteroid=asteroids[i];
            while(!st.isEmpty() && st.peek()*cur_asteroid<0){
                if(st.peek()<0 && Math.abs(st.peek())>cur_asteroid) cur_asteroid=st.peek();
                else if(st.peek()>0 && st.peek()>Math.abs(cur_asteroid)) cur_asteroid=st.peek();
                else if(Math.abs(st.peek())==Math.abs(cur_asteroid)) cur_asteroid=0;
                st.pop();
            }
            if(cur_asteroid!=0) st.push(cur_asteroid);

        }*/
        for(int i=0;i<n;i++){
            int cur_asteroid=asteroids[i];
            while(!st.isEmpty() && cur_asteroid<0 && st.peek()>0){
                if(Math.abs(cur_asteroid)<st.peek()) cur_asteroid=st.peek();
                else if(Math.abs(cur_asteroid)==st.peek()) cur_asteroid=0;
                st.pop();
            }
            if(cur_asteroid!=0) st.push(cur_asteroid);
        }
        int[] ans=new int[st.size()];
        int i=ans.length-1;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return ans;
    }
}