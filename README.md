# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

We will first create a hashmap to store the indices of the elements in the inorder array for quick access. Then we will use helper function to recursively construct the tree. Start from the last element of the postorder array as the root and then we will use the inorder array from hashmap to determine the subtree boundries. For each root node we will recursively construct its right and left subtrees by slicing the inorder array accordingly. 



## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
   
In this solution we can traverse the tree recursively where we will pass along the current calculated number formed by the path from the root to the current node. Then we will apply the leaf check where we can check if we have reached the leaf node or not. If we have reached a leaf node we can return the current calculated number. For non-leaf nodes we can recursively calculate the sum for left and right subtrees and return their sum.