//Problem link :https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

//union-find class 
class DSU{
    public:
    vector<int> parents;// to store parents of ith node
    vector<int> groupSize; // to store group size of ith parent node
    DSU(int n){
        for(int i=0;i<n;i++){
            parents.push_back(i);
            groupSize.push_back(1);
        }
    }
    //find parent function
    int find(int node){
        if(parents[node]==node)
        return node;
        return parents[node]=find(parents[node]);
    }
    // union function based on group size
    void unify(int node1,int node2){
        int parent1=find(node1);
        int parent2=find(node2);
        if(parent1!=parent2){
            if(groupSize[parent1]>=groupSize[parent2]){
                parents[parent2]=parent1;
                groupSize[parent1]+=groupSize[parent2];
                groupSize[parent2]=0;
            }else{
                parents[parent1]=parent2;
                groupSize[parent2]+=groupSize[parent1];
                groupSize[parent1]=0;
            }
        }
    }
};
class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        int result=0;
        int n=stones.size();
        DSU graph(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //if row or col is same , we can unify the two groups
                if(stones[j][0]==stones[i][0] || stones[j][1]==stones[i][1]){
                if(graph.find(i)!=graph.find(j)){
                    graph.unify(i,j);
                }
                }
            }
        } 
        for(int i=0;i<n;i++){
            result+=max(0,graph.groupSize[i]-1);//adding all groups size-1 for most stones removed
        }
        return result;
    }
};

/*
TC: O(N^2)
SC: O(N)*/