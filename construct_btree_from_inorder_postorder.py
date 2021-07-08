"""
// Time Complexity : O(n)
// Space Complexity :
    Without recursive stack - O(n) (Use of map)
    With recursive stack - O(maxdepth + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
Following from the preorder explanation, we approach this problem in simlar
way with only difference being fetching the root from the last element in postorder
post_left & in_left remain same ie till elements index of root in inorder
post_right - index+1 till one but last(root)
in_right - index+1 till end

@Space optimal solution
- We only consider boundary for inorder with 2 pointers start_idx and end_idx
- left -> [start_idx,index-1]
- right -> [index+1,end_idx]
- Also we use map to store the inorder value-index map, so as to get the index in O(1)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        inorder_dict = dict((v,i) for i,v in enumerate(inorder))
        def helper(inorder,postorder):
            if not inorder:
                return None
            root = TreeNode(postorder[-1])
            index = inorder.index(root.val)
            root.left = helper(inorder[:index],postorder[:index])
            root.right = helper(inorder[index+1:],postorder[index:-1])
            return root
        
        return helper(inorder,postorder)

        #Method2- Space optimal
        def helper(inorder,postorder,start_idx,end_idx):
            if start_idx > end_idx or not postorder:
                return None
            root = TreeNode(postorder.pop())
            #index = inorder.index(root.val)
            index = inorder_dict[root.val]
            
            root.right = helper(inorder,postorder,index+1,end_idx)
            root.left = helper(inorder,postorder,start_idx,index-1)
            return root
        
        return helper(inorder,postorder,0,len(inorder)-1)
