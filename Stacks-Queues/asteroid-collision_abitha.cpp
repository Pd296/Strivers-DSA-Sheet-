Problem Link : https://leetcode.com/problems/asteroid-collision/description/
class Solution {
  public:
    vector<int> asteroidCollision(vector<int> &asteroids) {
        // code here
        vector<int> s;
        int N = asteroids.size();
        for(int i = 0;i < N;i++) {
            int ele = asteroids[i];
            if(ele >= 0) {
                s.push_back(ele);
            }
            else {
                while(s.size() > 0 && s.back() >= 0 && s.back() < abs(ele)) {
                    s.pop_back();
                }
                
                if(s.size() > 0 && s.back() >= 0 && abs(ele) == s.back()) {
                    s.pop_back();
                }
                else if(s.size() == 0 || s.back() < 0) {
                    s.push_back(ele);
                }
             }
        }
        return s;
    }
};
