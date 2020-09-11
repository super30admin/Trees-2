//Binary Tree
//Using HashMap soln
// Time Complexity : O(N) becuase we are using hash map to store all inorder elements iterating n times
// Space Complexity :O(N) because we are using Hash Map to store all inorder elements iterating n times
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
root.left = helper(preorder, inorder, start, idx-1);
root.right = helper(preorder, inorder, idx + 1, end); 

I interchanged the above I got the wrong output
// Your code here along with comments explaining your approach