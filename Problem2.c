/* Problem Statement:
Verified on leetcode

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.


 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>


/**
 * Definition for a binary tree node.
 */
 struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };


int sumNumbers_helper(struct TreeNode* root, int val) {
    
    if (root == NULL) {
        return 0;
    }
    /* No left or right subtree, time to calculate and return */
    if (root->left == NULL && root->right == NULL) {
        return (((val * 10) + root->val));
    }
    /* check both sides of the tree */
    return sumNumbers_helper(root->left, (val * 10 + root->val)) + sumNumbers_helper(root->right, (val * 10 + root->val));
}

int sumNumbers(struct TreeNode* root){

    if(!root) {
        return 0;
    }
    return sumNumbers_helper(root, 0);
}


int main(int argc, char *argv[]) {

    struct TreeNode root;
    struct TreeNode left;
    struct TreeNode right;

    root.val = 1;
    root.left = &left;
    root.right = &right;

    left.val = 2;
    left.left = NULL;
    left.right = NULL;

    right.val = 3;
    right.left = NULL;
    right.right = NULL;

    printf("Total sum is : %d\n",sumNumbers(&root));
}


