//problem: https://leetcode.com/problems/word-ladder/description/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.add(new Pair(1,beginWord));
        visited.add(beginWord);
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            if(p.word.equals(endWord)) return p.step;
            Set<String> n=neighbours(p.word,wordList);
            for(String s:n){
                if(!visited.contains(s)){
                    queue.add(new Pair(p.step+1,s));
                    visited.add(s);
                }
            }
        }
        return 0;
    }
    public Set<String> neighbours(String word,List<String> dict){
        Set<String> result=new HashSet<>();
        for(String w:dict){
            int diff=0;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)!=w.charAt(j)) diff++;
                if(diff>1) break;
            }
            if(diff==1) result.add(w);
        }
        return result;
    }
}
class Pair{
    int step;
    String word;
    Pair(int step,String word){
        this.step=step;
        this.word=word;
    }
}