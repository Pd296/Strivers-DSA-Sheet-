//Problem link: https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1


// User function Template for C++

class Solution {
  public:
    int minimumMultiplications(vector<int>& arr, int start, int end) {
        // code here
        //queue to maintain all states
        queue<int>pq;
        const int mod=100000;
        vector<int> steps(100000,INT_MAX); //array to manitain min steps required to reach index number
        pq.emplace(start);
        steps[start]=0;
        while(!pq.empty()){
            auto num=pq.front();
           //cout<<num<<" "<<count<<"\n";
            pq.pop();
            //if num is found return minsteps required 
            if(num==end){
                return steps[num];
            }
            // loop throught arr and check all different states
            for(auto& i: arr){
                int newNum=(i*num)%mod;
                newNum=newNum%mod;
                //cout<<newNum<<" ";
                if(steps[num]+1<steps[newNum]){
                    steps[newNum]=steps[num]+1;
                    pq.emplace(newNum);
                }
            }
        }
        //if num is not found ,return -1;
        return -1;
    }
};
