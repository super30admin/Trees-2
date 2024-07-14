// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public:
        int dfs(TreeNode* node, int pathSum) {
            if (!node)
                return 0;
            
            pathSum = pathSum * 10 + node->val;
            
            if (!node->left && !node->right)
                return pathSum;
            
            return dfs(node->left, pathSum) + dfs(node->right, pathSum);
        }
        int sumNumbers(TreeNode* root) {
            return dfs(root, 0);
        }
    };
    
    class Solution {
        int res;
        private void helper(TreeNode root, int currSum){
            if (root == null)
                return;
            
            currSum = currSum * 10 + root.val;
            if (root.left == null && root.right == null)
                res += currSum;
            
            helper(root.left, currSum);
            helper(root.right, currSum);
        }
        public int sumNumbers(TreeNode root) {
            this.res = 0;
            helper(root, 0);
            return this.res;
        }
    }
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    struct TreeNode* newNode(int data)
{
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = data;
    node->left = node->right = NULL;
    return (node);
}
int search(int arr[], int strt, int end, int value)
{
    int i;
    for (i = strt; i <= end; i++) {
        if (arr[i] == value)
            break;
    }
    return i;
}
struct TreeNode* buildUtil(int in[], int post[], int inStrt,
                int inEnd, int* pIndex)
{
    // Base case
    if (inStrt > inEnd)
        return NULL;
 
    /* Pick current node from Postorder traversal using
       postIndex and decrement postIndex */
    struct TreeNode* node = newNode(post[*pIndex]);
    (*pIndex)--;
 
    /* If this node has no children then return */
    if (inStrt == inEnd)
        return node;
 
    /* Else find the index of this node in Inorder
       traversal */
    int iIndex = search(in, inStrt, inEnd, node->val);
 
    /* Using index in Inorder traversal, construct left and
       right subtress */
    node->right = buildUtil(in, post, iIndex + 1, inEnd, pIndex);
    node->left = buildUtil(in, post, inStrt, iIndex - 1, pIndex);
 
    return node;
}

struct TreeNode* buildTree(int* in, int inorderSize, int* post, int postorderSize){
    int p = postorderSize - 1;
    return buildUtil(in,post, 0, inorderSize-1, &p);
}