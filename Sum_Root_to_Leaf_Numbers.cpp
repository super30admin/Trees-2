// {Approach 1, 2}
// Time Complexity : O(N) ...... N is toltal number of elements in tree
// Space Complexity : O(1) ... if we consider stack used for recursion --> O(hight of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.
 Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.
*/


/*
Approach 1 : Using global variable sum
*/

class Solution {
    int sum = 0;
public:
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode* root, int current){
        if(root == nullptr) return;

        current = (current * 10) + root->val;
        if(root->left == nullptr && root->right == nullptr){
            sum += current;
            return;
        }
        helper(root->left, current);
        helper(root->right, current);
    }
};



/*
Approach 2 : Without using global variable sum
*/


class Solution {

public:
    int sumNumbers(TreeNode* root) {    
        return helper(root, 0);
    }

    int helper(TreeNode* root, int current){
        if(root == nullptr) return 0;

        current = (current * 10) + root->val;
        if(root->left == nullptr && root->right == nullptr){
            return current;
        }
        int left = helper(root->left, current);
        int right = helper(root->right, current);

        return left + right;
    }
};