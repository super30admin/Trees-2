# Trees-2

## Problem1 :https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]



postorder = [9,15,7,20,3]
Return the following binary tree:

   3



   / \



  9  20



    /  \



   15   7

## Problem2 : https://leetcode.com/problems/sum-root-to-leaf-numbers/

You are given a binary tree which has digits from 0-9 at each node and each root-to-leaf path could be represented by a number. we can understand it as we have root-to-leaf path as 1->2->3 then it represents a number 123. you have to give the total sum of all the root-to-leaf numbers. when i say i mean the node with no children.



Example 1:

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
   
