#time:  O(n)
#space: O(n)
#approach: 1. find the leaf nodes
#          2. add the leaf nodes to the current path
#          3. return the sum of the leaf nodes
#edge case: if the root is empty, return 0


class Solution:
    def sumNumbers(self, root):
        def findLeafNodes(node, currentPath):
            if not node:
                return 0
            
            currentPath = currentPath * 10 + node.val

            if not node.left and not node.right:
                return currentPath

            return findLeafNodes(node.left, currentPath) + findLeafNodes(node.right, currentPath)

        return findLeafNodes(root, 0)
