class Solution {
public:
     vector<vector<int>> adj;
     vector<int> result;
     vector<int> todo,comp;
     bool dfs(int node,int n){
        if(adj[node].empty())
        return true;
        if(comp[node]==1)
        return true;
        todo[node]=1;
        
        for(auto& i: adj[node]){
            if(todo[i]==1)return false;
            if(comp[i]==1)continue;
            if(!dfs(i,n)) return false;
            if(comp[i]==0){
                result.push_back(i);
                comp[i]=1;
            }
        }
        todo[node]=0;
       
        adj[node].clear();
        
        return true;
     }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        adj.resize(numCourses);
        todo.resize(numCourses,0);
        comp.resize(numCourses,0);
        for(auto i: prerequisites){
            adj[i[0]].push_back(i[1]);
        }
        // for(int i=0;i<numCourses;i++){
        //     cout<<i<<"\n";
        //     for(auto j: adj[i]){
        //         cout<<j<<" ";
        //     }
        //     cout<<"\n";
        // }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,numCourses))
            return {};
          
                if(comp[i]==0){
                    result.push_back(i);
                    comp[i]=1;
                }
            
        }
        return result;
    }
};
