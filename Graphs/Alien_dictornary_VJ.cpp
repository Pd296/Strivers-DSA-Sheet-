//Problem link https://www.geeksforgeeks.org/problems/alien-dictionary/1?

class Solution {
  public:
    string findOrder(vector<string> &words) {
        // code here
        vector<int> inDeg(27,-1); // to store indegree for kahn's algo
        //0=> word in dict and indegree 0
        //-1=> word not in dict not need to evaluate
        // other(x) => word in dict and indegree x

        int dis=0;// total distinct elements
        map<char,vector<char>> adjList; // graph adjacant list for Kahn's Algo
        
        //checking for distinct letters and intialize it to 0 for consideration in futher process
        for(int i=0;i<words.size();i++){
            for(int j=0;j<words[i].length();j++){
                if(inDeg[words[i][j]-'a']==-1){
                inDeg[words[i][j]-'a']=0;
                dis++;
                }
            }
        }
        //buliding graph for futher process
        //since words list is sorted lexiograpically, we should check adjacant pair of words
        //for graph
        for(int i=1;i<words.size();i++){
            for(int j=0;j< min(words[i].length(),words[i-1].length());j++){
                //first word differ in adjacant pair is used to build edges
                if(words[i-1][j]!=words[i][j]){
                    adjList[words[i-1][j]].push_back(words[i][j]);
                    break;
                }
            }
            //if first word length is greater than second word and second word is suffix of first word,
            //it creates invaild condition , so answer is empty string
            if(words[i-1].length()>words[i].length()){
                string pref=words[i-1].substr(0,words[i].length());
                if(pref==words[i])
                return "";
            }
        }
        //builds indegree for nodes in edges
        for(auto& adj: adjList){
            for(auto& ch: adj.second){
                inDeg[ch-'a']++;
            }
        }
        queue<char> topo;
        
        string result="";
        //inserts nodes in queue for indegree 0
        for(int i=0;i<27;i++){
            if(inDeg[i]==0)
            topo.push('a'+i);
        }
        //Kahn's algo
        while(!topo.empty()){
            char ch=topo.front();
            topo.pop();
            result+=ch;
            for(auto& letter: adjList[ch]){
                inDeg[letter-'a']--;
                if(inDeg[letter-'a']==0)
                topo.push(letter);
            }
            if(result.size()==dis){
            //cout<<result<<" ";
            return result;
            }
        }
        //cout<<result<<" ";
        //if all distinct character are available in answer ,graph doesn't have cycle 
        //if not, cycle exist and no result available.
        if(result.size()==dis)
        return result;
        return "";
    }
};

/*Time complexity:
O(n*m)
Space Complexity:
worst case O(n*m)
average case O(1)
*/