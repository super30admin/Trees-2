"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
      
        hashmap = {val: idx for idx, val in enumerate(inorder)}
        self.idx = len(postorder) - 1  

        def helper(start, end):
            # Base case
            if start > end:
                return None
            
            rootVal = postorder[self.idx]
            self.idx -= 1
            root = TreeNode(rootVal)

            rootIdx = hashmap[rootVal]
            root.right = helper(rootIdx + 1, end)
            root.left = helper(start, rootIdx - 1)

            return root

        return helper(0, len(inorder) - 1)