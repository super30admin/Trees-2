/* 
Time Complexity:
O(n)
*/

/*
Space Complexity:
O(n) as we are creating extra space for the map
and we are storing the entire tree too. So the space
complexity 
*/

/*
Approach:
Using recursive approach with hash map to optimize the 
solution. Otherwise the time complexity would have been
O(n^2). 

We cannot create a tree with only inorder or postorder.
We need both of them. In postorder we know that root of the
tree will be stored last, so we start from the end of the
given postorder vector. Then we look for the same value in
the inorder vector which helps in getting left and right
values of the tree by dividing it into two parts as left
and right subtrees. 

To get the right value we start from the next index 
where the root value was found in inorder vector and go till the end
recursively.

Similarly to get the left value we start from the 0th index
and go till the index just before the root value in the inorder
vector.
*/


// The code ran perfectly on the leetcode.



class Solution {
    unordered_map<int, int> store;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for(int i = 0; i<inorder.size(); i++){
            store[inorder[i]] = i;
        }
        int poIdx = inorder.size() -1;
        return helper(inorder, postorder, 0, inorder.size() -1, poIdx);
    }
    
    private:
    TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int start, int end, int &poIdx){
        //base
        if(start > end){
            return nullptr;
        }
        //logic
        int rootVal = postorder[poIdx--];
        int rootIdx = store[rootVal];
        TreeNode *root = new TreeNode(rootVal);
        root->right = helper(inorder, postorder, rootIdx+1, end, poIdx);
        root->left = helper(inorder, postorder, start, rootIdx - 1, poIdx);
        
        return root;
    }
};