// User function Template for Java

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> x=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        long sum1=n*(n+1L)/2;
        long sum2=0;
        for(int i=0;i<arr.length;i++) {
            if(i!=n-1 && arr[i]==arr[i+1]) {
                x.add(arr[i]);
                sum2=sum2+arr[i];
                i++;
            }
            else{
                sum2=sum2+arr[i];
            }
        }
        x.add((int)(sum1 - sum2));
        
        return x;
    }
}
