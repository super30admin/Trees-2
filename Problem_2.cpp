/* 
Time Complexity:
O(n) as we are going through each node
*/

/*
Space Complexity:
O(H) where H is the height of the tree. We are creating a stack of this
height for our recursion to take place.
*/

/*
Approach:
Recursive approach as it is easier in this case as compared to the iterative approach.
Although in both the cases the time and space complexity will be same.

At every node we have to maintain a variable that stores the value of the number
formed so far. So when we start from the root node, we store 0 with the the root
node in the stack as the number formed till that point is zero as there is no node
before it. So when we move to the left or the right child, we multiply the number formed
till then with 10 and add the value of the current node. We keep on doing this until
we reach the null on both right and left where we add that number to the final sum.
*/


// The code ran perfectly on the leetcode.

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        helper(root, 0, sum);
        return sum;
    }
    
    private:
    void 
        helper(TreeNode * root, int num, int &sum){
        //base
        if (root == NULL) {
             return;
        }
        //logic
        helper(root->left, num*10 + root->val, sum);
        helper(root->right, num*10 + root->val, sum);
        if(root->left == NULL && root-> right == NULL){
            sum += num*10 + root->val;
        }
        
    }
    
};