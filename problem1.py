#Time Complexity: O(n)
#Space Complexity: O(n)
#submit on leetcode: yes

from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import List

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> [TreeNode]:
        if not inorder or not postorder:
            return None
        length = len(inorder)
        return self.helper(inorder, postorder, 0, length - 1, 0, length - 1)

    def helper(self, inorder, postorder, inStart, inEnd, postStart, postEnd):
        if inStart > inEnd:
            return None

        root_val = postorder[postEnd]
        root = TreeNode(root_val)
        root_idx = inorder.index(root_val)

        while root_idx <= inEnd:
            if inorder[root_idx] == root_val:
                break
            root_idx += 1

        leftTreeSize = root_idx - inStart
        rightTreeSize = inEnd - root_idx

        root.left = self.helper(inorder, postorder, inStart, root_idx - 1, postStart, postStart + leftTreeSize - 1)
        root.right = self.helper(inorder, postorder, root_idx + 1, inEnd, postEnd - rightTreeSize, postEnd - 1)
        return root


def printTreeInorder(root):
    if root:
        printTreeInorder(root.left)
        print(root.val, end=" ")
        printTreeInorder(root.right)

sol = Solution()
inorder = [9, 3, 15, 20, 7]
postorder = [9, 15, 7, 20, 3]

tree_root = sol.buildTree(inorder, postorder)

# Print the inorder traversal of the constructed tree
print("Inorder Traversal:")
printTreeInorder(tree_root)