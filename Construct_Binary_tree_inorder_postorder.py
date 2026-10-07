# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Recursive Approach. Since postorder traversal is left, right, root, every recursion we get the last element from postorder so going backwards is root right left
# Then get the index of root from inorder so everything before the index is left subtree and everything after the index is right subtree


class Solution:
    def buildTree(self, inorder:List[int], postorder: List[int]) -> TreeNode | None:
        if not postorder:
            return None
        root = TreeNode(postorder[-1])
        mid = inorder.index(postorder[-1])
        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:], postorder[mid:-1])

        return root

#Time - O(N2)
#Space - O(N2)

class Solution:
    def buildTree(self, inorder:List[int], postorder: List[int]) -> TreeNode | None:
        if not postorder:
            return None
        inorder_map = {}
        self.idx = len(postorder)-1
        for i in range(len(inorder)):
            inorder_map[inorder[i]] = i
        def helper(start, end):
            if start > end:
                return None
            root_val = postorder[self.idx]
            self.idx -= 1
            index = inorder_map[root_val]
            root = TreeNode(root_val)
            root.right = helper(index+1, end)
            root.left = helper(start, index-1)
            return root
        return helper(0, len(inorder)-1)

