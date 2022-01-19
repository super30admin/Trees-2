"""
// Time Complexity : O(n)
// Space Complexity : O(h) in the worst case it is  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

"""

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # use a hash map to record the relation val to index in order. (we want to find the root position in constant time)
        self.map = {}
        # post order traversal gives left, rright and root. Root is last so we have the index  ptr at the last index of postorde arr
        self.index = len(postorder) - 1
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(postorder, inorder, 0, len(inorder) - 1)

    def helper(self,postorder, inorder, start, end):
        if start > end:
            return None
        # We find the root in postorder  array using the index we created earlier
        rootval = postorder[self.index]
        # we have used up that index so next possible root will be to the left
        self.index -= 1
        # using that rootval we create a new tree node
        root = TreeNode(rootval)
        # we must now go and obtain the index of the root value from the inorder array.
        rootindex = self.map[rootval]
        # everything to the right of the index will be root.right
        root.right = self.helper(postorder, inorder, rootindex+1, end)
        # everything to the left of the index will be root.left
        root.left = self.helper(postorder, inorder, start, rootindex-1)

        return root