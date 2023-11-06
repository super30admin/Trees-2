# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n), n is no of nodes in tree
#SC: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        def to_tree(left, right):
            nonlocal postorder_index
            # if there are no elements to construct the tree
            if left > right: return None

            # select the preorder_index element as the root and increment it
            root_value = postorder[postorder_index]
            root = TreeNode(root_value)


            postorder_index -= 1

            # build left and right subtree
            
            root.right = to_tree(inorder_map[root_value] + 1, right) #O(n)
            root.left = to_tree(left, inorder_map[root_value] - 1) #O(n)

            return root
        
        postorder_index = len(postorder) - 1
        # build a hashmap to store value -> its index relations
        inorder_map = {}
        for index, value in enumerate(inorder): #O(n)
            inorder_map[value] = index

        return to_tree(0, len(postorder) - 1)
    
