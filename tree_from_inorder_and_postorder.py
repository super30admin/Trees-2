"""
TC:O(n)
SC:O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def arr_to_tree(left,right):
            if left > right:
                return None
            nonlocal pre_order_index
            root_value=preorder[pre_order_index]
            root = TreeNode(root_value)
            pre_order_index+=1
            root.left=arr_to_tree(left,inorder_dict[root_value]-1)
            root.right=arr_to_tree(inorder_dict[root_value]+1,right)
            return root
        pre_order_index=0
        inorder_dict={}
        for i in range(len(inorder)):
            inorder_dict[inorder[i]]=i
        return arr_to_tree(0,len(preorder)-1)