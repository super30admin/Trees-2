#include <bits/stdc++.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

void recurse(TreeNode* root,int& ans,int accumulate){
    bool isLeaf = !root->left&&!root->right;
    if(isLeaf) ans += (10*accumulate+root->val);
    if(root->left) recurse(root->left,ans,10*accumulate+root->val);
    if(root->right) recurse(root->right,ans,10*accumulate+root->val);
}
int sumNumbers(TreeNode* root) {
    int ans = 0;
    recurse(root,ans,0);
    return ans;
}
int main(){
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    cout<<sumNumbers(root);
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(h)
// Input: [1,2,3]
// Output: 25
// Explanation: The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13. The sum of the numbers is 12+13=25.