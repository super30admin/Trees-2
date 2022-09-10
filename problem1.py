'''
105. Construct Binary Tree from Preorder and Inorder Traversal

TIME COMPLEXITY:
    Approach 1 : O(n*n)
    Approach 2: O(n)
SPACE COMPLEXITY
    Approach 1: O(n)
    Approach 2: O(n)
LEETCODE: Yes
DIFFICULTY: A bit, but could solve it.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        global root_idx, mmap
        root_idx = -1
        mmap = {}
        for i in range(0, len(inorder)):
            mmap[inorder[i]] = i
        
        
        def approach1(preorder, inorder):
            global root_idx
        
            # base
            if len(inorder) == 0 or root_idx >= len(preorder):
                return None
            
            # logic
            root_idx += 1
            root_val = preorder[root_idx]
            # get index of root in inorder
            idx = inorder.index(preorder[root_idx])
                        
            inorder_left = inorder[0:idx]
            inorder_right = inorder[idx+1:len(inorder)]
            
            left_root = approach1(preorder, inorder_left)
            right_root = approach1(preorder, inorder_right)
            
            return TreeNode(root_val, left_root, right_root)
            
        def approach2(preorder, sstart, eend):
            global root_idx, mmap
            # base
            if sstart > eend or root_idx >= len(preorder):
                return None
            
            # logic
            root_idx += 1
            root_val = preorder[root_idx]
            idx = mmap[root_val]
            
            lr = approach2(preorder, sstart, idx-1)
            rr = approach2(preorder, idx+1, eend)
                        
            return TreeNode(root_val, lr, rr)
        
        return approach1(preorder, inorder)
        # return approach2(preorder, 0, len(inorder)-1)
        
