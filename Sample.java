//Sum Root To Leaf

// Time Complexity : O(h) i.e height of the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Traversed till the height of the tree, maintained sum and tree node in the same stack
//atlast  returned the result

//Binary Tree from Inorder and Pre-order using for loop

// Time Complexity : O(n^2) i.e. because of for loops
// Space Complexity : O(n^2) because at every point in stack the arrays will be keep dividing into two Arrays left and right
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//First value in pre-order will be the root and search that root value in inorder array then
//divide the arrays in 4 arrays inleft, inright, preLeft, preRight
// so again repeat the whole procedure untill root hits null



//Binary Tree from Inorder and Pre-order using HashMap

// Time Complexity : O(n) 
// Space Complexity : O(n)  storing in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No