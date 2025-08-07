// Problem Link : https://leetcode.com/problems/word-ladder/description/

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        queue<pair<string, int>> q;
        unordered_set<string> st(wordList.begin(), wordList.end());
        q.push({beginWord,1});
        st.erase(beginWord);
        while(!q.empty()) {
            string word = q.front().first;
            int cnt = q.front().second;
            q.pop();
            if(word == endWord) return cnt;
            for(int i = 0;i < word.size();i++) {
                //for all characters in the word
                char originalChar = word[i];
                for(char ch = 'a'; ch <= 'z';ch++) {
                    word[i] = ch;
                    if(st.find(word) != st.end()) {
                        q.push({word, cnt+1});
                        st.erase(word);
                    }
                }
                word[i] = originalChar;
            }
        }
        return 0;
        
    }
};

// O(size of wordList*length of word*26)
