
# Optimized Solution
# Instead of having an array we can look up the values from a map instead
# Time Complexity: O(N) since for finding the root we only use map with constant lookups 
# Space Complexity: O(N) # aux map space + O(N) recursive calls made ~~ O(2N) ie O(N)

class Solution:

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        if len(postorder) == 0:
            return None
        
        self.idx = 0
        self.hashmap = {}

        for idx, val in enumerate(inorder): # unique values are only given to us
            hashmap[val] = idx

        return self.helper(inorder, postorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, startIdx, endIdx):

        # base case
        if (startIdx > endIdx):
            return None

        # logic

        root_val = postorder[self.idx]
        root = TreeNode(root_val)

        self.index -= 1 # to get the next root
        root_idx = self.hashmap[root_val]

        root.right = self.helper(preorder, inorder, root_idx + 1, endIdx)
        root.left = self.helper(preorder, inorder, start, root_idx - 1) 
        

        return root

