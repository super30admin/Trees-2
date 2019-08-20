/*
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 *
 * Did it run on LeetCode : No.
 *
 * Faced problem writing the recursive code. Tried the inorder and preorder method for inorder and postorder.
 */


#include<iostream>
#include<vector>

using namespace std;

class TreeNode
{
public:

        int data;
        TreeNode * left;
        TreeNode * right;
TreeNode(int data)
{
    this->data=data;
    TreeNode * left=NULL;
    TreeNode * right= NULL;

}

    TreeNode buildTree(vector<int> & inorder, vector<int>& postorder)
    {
        if(postorder.size() == 0)
            return NULL;

        int postorderEnd = postorder.size()-1;

        TreeNode * root = new TreeNode(postorder[postorderEnd]); // Set the last element as root.
        int index = 0;  // Get index for Element position in Inorder Array.

        for(int i=0; i<inorder.size()-1; i++) {
            if(inorder[i] == root.data) {
                index = i;
            }
        }


        /*
         *
         * Recursively build the tree. The function I wrote wasn't working.
         */
    }

};

int main()
{
    vector<int> inorder{9,3,15,20,7};
    vector<int> postorder = {9,15,7,20,3};

    TreeNode node1;
    node1.buildTree(inorder,postorder);
}