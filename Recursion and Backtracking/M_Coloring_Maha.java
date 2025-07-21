class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        for(int i = 0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int ve=edge[1];
            graph.get(u).add(ve);
            graph.get(ve).add(u);
        }
        int colour[]=new int[v];
        for(int i=0;i<v;i++) colour[i]=0;
        return solve(v,colour,0,graph,m);
    }
    public static boolean solve(int v,int[] colour,int node,List<List<Integer>> graph,int m){
        if(node==v) return true;
        for(int c=1;c<=m;c++){
            if(canColor(c,graph,node,colour)){
                colour[node]=c;
                if(solve(v,colour,node+1,graph,m)) return true;
                colour[node]=0;
            }
        }
        return false;
    }
    public static boolean canColor(int c,List<List<Integer>> graph,int node,int[] colour){
        for(int adj:graph.get(node)){
            if(colour[adj]==c) return false;
        }
        return true; 
    }
}