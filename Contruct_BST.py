"""
    Constructs a binary tree from inorder and postorder traversal arrays.

    Methods
    -------
    buildTree(postorder: List[int], inorder: List[int]) -> TreeNode:
        Reconstructs the binary tree using recursive helper logic.
        
    helper(postorder: List[int], inorder: List[int]) -> TreeNode:
        Recursively builds the tree using last element of postorder as root,
        locating it in inorder to divide left and right subtrees.

    Time Complexity:
        O(n^2) in worst case due to list slicing and linear search for root index.

    Space Complexity:
        O(n) for recursion stack and sliced sublists.

    Assumptions:
        - All node values are unique.
        - Both traversals are valid and represent the same tree.
"""
class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def buildTree(self, postorder, inorder):
        return self.helper(postorder, inorder)
    
    def helper(self, postorder, inorder):
        if len(postorder) == 0 or len(inorder) == 0:
            return
        
        rootVal = postorder.pop()
        rootIdx = 0
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                rootIdx = i
        root = TreeNode(rootVal)
        leftIn = inorder[:rootIdx]
        rightIn = inorder[rootIdx+1:]
        leftPost = postorder[: len(leftIn)]
        rightPost= postorder[len(leftIn):]
        root.left = self.helper(leftPost, leftIn)
        root.right = self.helper(rightPost, rightIn)
        return root

# Helper to print tree level order
from collections import deque

def printLevelOrder(root):
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        result.append(node.val if node else None)
        if node:
            queue.append(node.left)
            queue.append(node.right)
    # Remove trailing None values for clean output
    while result and result[-1] is None:
        result.pop()
    print(result)

# ---------- MAIN FUNCTION ----------
if __name__ == "__main__":
    # Test Case 1
    inorder1 = [9, 3, 15, 20, 7]
    postorder1 = [9, 15, 7, 20, 3]
    sol1 = Solution()
    treeRoot1 = sol1.buildTree(postorder1[:], inorder1)  # Use postorder[:] to avoid mutation
    print("Level order traversal of constructed tree (Test Case 1):")
    printLevelOrder(treeRoot1)  # Expected: [3, 9, 20, None, None, 15, 7]

    # Test Case 2
    inorder2 = [-1]
    postorder2 = [-1]
    sol2 = Solution()
    treeRoot2 = sol2.buildTree(postorder2[:], inorder2)
    print("Level order traversal of constructed tree (Test Case 2):")
    printLevelOrder(treeRoot2)  # Expected: [-1]
