
// 1-july-2025
//link-https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

class Solution {
  public:
  int findStudents(vector<int> arr, int mid) {
      int stud = 0;
      int sum = 0;
      for(int i = 0;i < arr.size();i++) {
          if(sum + arr[i] <= mid) {
              sum += arr[i];
          }
          else{
              stud++;
              sum = arr[i];
          }
      }
      if(sum > 0) {
          stud++;
      }
      return stud;
  }
    int findPages(vector<int> &arr, int k) {
        // code here
        int sum = 0;
        int maxEle = arr[0];
        int n = arr.size();
        if(k > arr.size()) {
            return -1;
        }
        for(int i = 0; i < n;i++) {
            if(maxEle <= arr[i]) {
                maxEle = arr[i];
            }
            sum += arr[i];
        } 
        if(k == 1) {
            return sum;
        }
        int lo, hi, mid;
        lo = maxEle;
        hi = sum;
        while(lo <= hi) {
            mid = (hi+lo)/2;
            // cout <<lo << " " << hi << " " <<  mid << "mid" << '\n';
            int res = findStudents(arr, mid);
            // if(mid == 25 && lo == 25){
            //     cout << res[0] << " " << res[1] << "\n"; 
            // }
            
            
            if(res > k) {
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return lo;
    }
};
