
//date-5-jul-2025
// problem link-https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1

// This is only better approach Best approach have to be done

class Solution {
    public static class pair{
        double first;
        int second;
        
        pair(double first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        PriorityQueue<pair> pq=new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        int n=stations.length;
        int[] gas_stns_count=new int[n-1];
        for(int i=0;i<n-1;i++){
            pq.add(new pair(stations[i+1]-stations[i],i));
        }
        
        for(int i=0;i<k;i++){
            pair top_ele=pq.poll();
            int section_ind=top_ele.second;
            
            gas_stns_count[section_ind]++;
            double initial_len=stations[section_ind+1]-stations[section_ind];
            double new_sec_len=initial_len/(gas_stns_count[section_ind]+1);
            pq.add(new pair(new_sec_len,section_ind));
        }
        return pq.peek().first;
    }
}
