// Time Complexity : O(n) n is array size(# of nodes).
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Perform inorder traversal and for each new visit to node concatenate like string that digit in root to a number 'n'.
// 2. n=10*n+(root->val) .
// 3. Whenever we reach leaf add that number to total sum & after right subtree visit divide by 10.


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int sum=0;
    void findtr(TreeNode* t,int &curr){
        if(t==nullptr) {
            return;
        }
        curr=((10*curr)+(t->val));
        if((t->left)==nullptr && (t->right)==nullptr) {
            sum=sum+curr;
            cout<<sum<<' '<<'\n';
        }
        cout<<curr<<'\n';
            findtr(t->left,curr);
        //curr=curr/10;
            findtr(t->right,curr);
        curr=curr/10;
    }
    int sumNumbers(TreeNode* root) {
        int curr=0;
        findtr(root,curr);
        return sum;
    }
};