problem link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1

#### Minimum Spanning Tree:
A minimum spanning tree (MST) is defined as a spanning tree that has the minimum weight among all the possible spanning trees.

The spanning tree holds the below-mentioned principles:

 - The number of vertices (V) in the graph and the spanning tree is the same.
 - There is a fixed number of edges in the spanning tree which is equal to one less than the total number of vertices ( E = V-1 ).
 - The spanning tree should not be disconnected, as in there should only be a single source of component, not more than that.
 - The spanning tree should be acyclic, which means there would not be any cycle in the tree.
 - The total cost (or weight) of the spanning tree is defined as the sum of the edge weights of all the edges of the spanning tree.
 - There can be many possible spanning trees for a graph.
 

#### kruskalsMST

This Algo uses Dis-joint subsets(DSU) to find minimum spanning tree. Intially, it sorts all edges based on weight. Starting from smaller weight, it unifies the edges(unifies in sense making parent node as same for both). It counts number of unified edges and if it reaches V-1 ,it will return back(Every spanning tree have property E(edges)=V(Vertices)-1). Whenever a edges is unified, it is guaranteed that edges will be lowest possible edge. 

find function :
    if parent of node is itself , it return node . otherwise it recurive calls and updates parent until it finds root or rep of group. 

Unify function :
     Intially, it gets parents of both nodes and it return back if parents are same. If parents are different , then lower rank group is merged to higher rank group(i.e parent or rep of higher group will now represent lower group as well).

```
// User function Template for C++
class Solution {
  public:
    vector<int> parent,rank;
    int find(int node){ //find parent of node 
        if(parent[node]==node)
        return node;
        parent[node]=find(parent[node]);
        return parent[node];
    }
    int unify(int node1,int node2){ //merge two different color groups into one by rank of group
        int pn1=find(node1);
        int pn2=find(node2);
        if(pn1!=pn2){
            if(rank[pn1]<rank[pn2]){
                parent[pn1]=pn2;
                rank[pn2]++;
            }else{
                parent[pn2]=pn1;
                rank[pn1]++;
            }
        }
        return 0;
    }
    static bool comp(vector<int>& n1,vector<int>& n2){
        return n1[2]<n2[2];
    }
    int kruskalsMST(int V, vector<vector<int>> &edges) {
        // code here
        int count=0;
        int result=0;
        for(int i=0;i<V;i++){
            parent.push_back(i); //initiaze nodes with himself as parent and
            rank.push_back(1); // rank with 1 .
        }
        sort(edges.begin(),edges.end(),comp);
        for(auto& i:edges){
            if(find(i[0])!=find(i[1])){
                unify(i[0],i[1]);
               result+=i[2];
               count++;
           if(count==V-1)
           break;
            }
            
        }
        // for(int i=0;i<V;i++){
        //     cout<<i<<" "<<parent[i]<<"\n";
        // }
        return result;
    }
};
```

Time Complexity:
- Initialization of parent and rank arrays takes O(V), where V is the number of vertices.
- Sorting the edges takes O(E log E), where E is the number of edges.
- For each edge, the find and union operations are performed. With path compression and union by rank, each operation is approximately O(α(V)), where α is the inverse Ackermann function, which is very slow-growing and considered almost constant.
- Overall, the dominant term is sorting, so the total time complexity is O(E log E).

Space Complexity:
- The parent and rank vectors each require O(V) space.
- The edges vector is given as input, so it doesn't add to auxiliary space.
- Additional variables use constant space.
- Total auxiliary space complexity is O(V).