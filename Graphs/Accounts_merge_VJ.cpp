//problem link: https://leetcode.com/problems/accounts-merge/

class DSU{

    vector<int> rep; //representative for each vertices
    vector<int> rank; //rank of each vertices
    public:
      DSU(int v){
        for(int i=0;i<v;i++){
            rep.push_back(i);
            rank.push_back(1);
        }
      }
      int find(int node){
        if(rep[node]==node) //if rep of node is itself , then return node.
        return node; 
        return rep[node]=find(rep[node]); // find rep of node and assign to other vertices and return it.
      }

      void unify(int node1,int node2){
        int rep1=find(node1);
        int rep2=find(node2);
        if(rep1!=rep2){// if representative of two nodes are not equal , then we need to merge two reprensatives 
            //higher rank representative will have higer priority. lower rank representative will be merged to higher rank.
            if(rank[rep1]>=rank[rep2]){ 
                rep[rep2]=rep1;
                rank[rep1]++;
            }else{
                rep[rep1]=rep2;
                rank[rep2]++;
            }
        }
      }
};
class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int v=accounts.size();
        DSU dsu(v);
        map<int,string> repToName; //hash table representative to name of peron 
        map<string,int> mailToRep; //hash table mails to representative
        for(int i=0;i<v;i++){
            repToName[i]=accounts[i][0];
            for(int j=1;j<accounts[i].size();j++){
                //if mail is already available in hash table, then unify previous rep and current rep .
                //else while add mail to hash table with current rep.
                if(mailToRep.find(accounts[i][j])!=mailToRep.end()){
                    dsu.unify(mailToRep[accounts[i][j]],i);
                }else{
                    mailToRep[accounts[i][j]]=i;
                }
            }
        }
        map<int,vector<string>> nameToMail;
        //combining all mails linked to same rep
        for(auto [mail,rep]:mailToRep){
            int grouprep=dsu.find(rep);
            nameToMail[grouprep].push_back(mail);
        }
        vector<vector<string>> result;
        // combining all mails with rep name as result;
        for(auto [rep,mails]: nameToMail){
            string name=repToName[rep];
            result.push_back({name});
            int i=result.size()-1;
            result[i].insert(result[i].begin()+1,(mails).begin(),(mails).end());

        }
        return result;
    }
};

// Time Complexity:
// - Initialization of DSU: O(V), where V is the number of accounts.
// - Loop through each account (V accounts):
//   - For each account, processing its emails involves inserting into maps and union operations.
//   - Each union/find operation is almost O(1) amortized due to path compression and union by rank.
//   - Mapping emails to representatives involves inserting into a hash map, which is O(1) average.
// - Overall, the main loop runs V times, and each union/find operation is nearly O(1), so total complexity is approximately O(V * α(V)), where α(V) is the inverse Ackermann function, very slow-growing and practically constant.
// - Additional operations like mapping names and emails are also O(V * M), where M is the average number of emails per account.

// Space Complexity:
// - DSU structures: O(V) for representative and rank vectors.
// - Maps:
//   - repToName: O(V), storing one name per account.
//   - mailToRep: O(T), where T is total number of emails across all accounts.
// - Overall, space complexity is O(V + T).

// In summary:
// Time complexity is approximately O(V * α(V) + T), which is effectively linear for practical input sizes.
// Space complexity is O(V + T).