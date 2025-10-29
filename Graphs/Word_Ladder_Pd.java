class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //convert to set for O(1) lookups
        Set<String> set = new HashSet<>(wordList);

        //return 0 if endWord is not in the set
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int distance = 1;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0 ){

                String currWord = queue.poll();
                //return distance if endWord is found
                if(currWord.equals(endWord))return distance;

                char[] charArrayWord = currWord.toCharArray();
                //try changing each letter
                for(int i=0;i<charArrayWord.length;i++){
                    char originalChar = charArrayWord[i];

                    for(char c='a';c<='z';c++){
                        charArrayWord[i]=c;
                        String formedString = new String(charArrayWord);

                        //check if the formed string is in the set
                        if(set.contains(formedString)){
                            queue.add(formedString);
                            //remove the formed string from the set
                            set.remove(formedString);
                        }
                    }
                    //reset the character back to original
                    charArrayWord[i]=originalChar;
                }
            }
            //increment the distance 
            distance += 1;
        }
        return 0;
    }
}