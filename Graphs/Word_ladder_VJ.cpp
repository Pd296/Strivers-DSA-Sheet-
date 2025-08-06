using pa=pair<string,int>;
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        queue<pa> q;
        unordered_set<string> words(wordList.begin(),wordList.end());
        q.push({beginWord,1});
        int result=INT_MAX;
        while(!q.empty()){
                string word=q.front().first;
                int len=q.front().second;
                q.pop();
                if(word==endWord){
                    result=min(result,len);
                    continue;
                }
                for(int k=0;k<word.length();k++){
                for(int j=0;j<27;j++){
                    if('a'+j == word[k])continue;
                    char c=word[k];
                    word[k]='a'+j;
                    if(words.count(word)!=0){
                        q.push({word,len+1});
                        words.erase(word);
                    }
                    word[k]=c;
                }
        }
    }
        return result==INT_MAX?0:result;
    }
};
