# // Time Complexity :O(N) we have to process all nodes
# // Space Complexity : O(N) in the recursive stack if it is skewed we would have to store all
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach    
## This is very similar to building tree with preorder and inorder. in this  we get root from end of postorder
## so we start our global index from the last element. And we first calculate the right subtree and then we do the left subtree.
## we recursively find the left and right and return the root.

class solution:
    postOrderIdx = -1
    inorderHashmap = {}

    def build (self, inorder, postorder):

        for idx, val in enumerate(inorder):
            self.inorderHashmap[val]= idx
        
        return self.helper(postorder, inorder, 0, len(postorder)-1)
    
    def helper(self, postorder, inorder, start, end):
        if start > end:
            return
        
        root_val = postorder[self.postOrderIdx]
        root = TreeNode(root_val)
        self.postOrderIdx-=1

        root.right = self.helper(postorder, inorder, self.inorderHashmap[root_val]+1, end)
        root.left = self.helper(postorder, inorder, start, self.inorderHashmap[root_val]-1)

        return root


