# Time: O(n*h)
# Space : O(n)
class Solution:
    postorder_idx = -1
    inorder_map = {}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.postorder_idx = len(postorder)-1
        for i in range(len(inorder)):
            self.inorder_map[inorder[i]] = i

        return self.helper(postorder, 0, len(postorder) - 1)
    
    def helper(self, postorder: List[int], left: int, right: int) -> Optional[TreeNode]:

        if left > right: return None

        root_val = postorder[self.postorder_idx]
        root = TreeNode(root_val)
        self.postorder_idx -= 1

        root.right = self.helper(postorder, self.inorder_map[root_val] + 1, right)
        root.left = self.helper(postorder, left, self.inorder_map[root_val] - 1)
        

        return root
        
        