#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;
class Solution {
    // Time Complexity --> O(n)
    // Space Complexity --> O(n) // recursivestack
public:
    int sum = 0;
    int sumNumbers(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        dfs(root,0);
        return sum;
    }
    void dfs(TreeNode * root, int currSum){
        if(root == NULL){
            return;
        }
        if(root->left == NULL && root->right == NULL){
            sum = sum + currSum * 10 + root->val;
            return;
        }
        dfs(root->left,currSum * 10 + root->val);
        dfs(root->right,currSum * 10 + root->val);
    }

};

/*int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}*/
