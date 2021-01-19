# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# This is same as construct binary tree with inorder and preorder except I decrease index
# in postorder from length to 1 and go towards right subtree first

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.mapping = defaultdict(lambda:0)
        self.idx = len(inorder)-1
        for i in range(len(inorder)):
            self.mapping[inorder[i]] = i
          
        return self.helper(postorder, 0, len(postorder)-1)
    
    def helper(self, postorder, start, end):
        if start > end:
            return None
        
        
        root_element = postorder[self.idx]
        root_index = self.mapping[root_element]
        self.idx -= 1
        node = TreeNode(val=root_element)
        node.right = self.helper(postorder, root_index+1, end)
        node.left = self.helper(postorder, start, root_index-1)

        return node