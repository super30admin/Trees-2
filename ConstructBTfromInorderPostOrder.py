
#Time Complexity: O(N)
#Space Complexity: O(N)



class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # Step 1: Build a hashmap for quick index lookup in inorder
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        
        # Step 2: Use a variable to keep track of the current index in postorder
        self.post_idx = len(postorder) - 1

        def helper(left, right):
            if left > right:
                return None

            # Step 3: Pick root from postorder using pre_idx and move index
            root_val = postorder[self.post_idx]
            self.post_idx -= 1
            root = TreeNode(root_val)

            # Step 4: Get inorder index of the root from map
            index = inorder_index_map[root_val]

            # Step 5: Recursively build left and right subtrees
            root.right = helper(index + 1, right)
            root.left = helper(left, index - 1)
            
            return root

        return helper(0, len(inorder) - 1)