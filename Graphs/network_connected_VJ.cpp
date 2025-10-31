class DSU{
public:
    vector<int> nodes,rank;
    DSU(int n){
        for(int i=0;i<n;i++){
            nodes.push_back(i);
            rank.push_back(1);
        }
    }
    int find(int node){
        if(nodes[node]==node)
        return node;

        return nodes[node]=find(nodes[node]);
    }

    void unify(int node1,int node2){
        int parent1=find(node1);
        int parent2=find(node2);

        if(parent1!=parent2){
            if(rank[parent1]>=rank[parent2]){
                nodes[parent2]=parent1;
                rank[parent1]++;
            }else{
                nodes[parent1]=parent2;
                rank[parent2]++;
            }
        }
    }
    
};
class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        DSU graph(n);
        int connExtra=0; //to store extra connections
        for(auto i: connections){
            if(graph.find(i[0])!=graph.find(i[1])){
                graph.unify(i[0],i[1]);
            }else{
                connExtra++;
            }
        }
        int connRequ=0; // to store no.of connected components
        for(int i=0;i<n;i++){
            if(graph.nodes[i]==i)connRequ++;
        }
        //connection required to connect all components are connRequ-1(exculding main graph)
        //if connection required less than or equal to connExtra, then we need connRequ-1 new connection
        //else we are not able to connect the graph.
        return connRequ-1<=connExtra?connRequ-1:-1;
    }
};