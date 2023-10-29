# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
		Time Complexity: O(n)
        Space Complexity: O(n)
        Did this code successfully run on Leetcode: Yes
    """
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def helper(left, right):
            if left > right:
                return None
            
            # pick up last element as root 
            val = postorder.pop()
            root = TreeNode(val)

            # root splits inorder list into left and right subtrees
            index = inorder_map[val]
      
            # build right subtree 
            root.right = helper(index + 1, right)
            # build left subtree
            root.left = helper(left, index -1)

            return root

        # build a hashmap to store value -> its index relations
        # inorder_map = {}
        # for index, value in enumerate(inorder):
        #     inorder_map[value] = index

        # return helper(0, len(inorder)-1)
        # build a hashmap value -> its index
        inorder_map = {val:idx for idx, val in enumerate(inorder)} 
        return helper(0, len(inorder) - 1)

        
