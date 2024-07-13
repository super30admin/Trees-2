#I used a depth-first search (DFS) approach with a helper function to traverse the binary tree. As I traverse, I build up a string representation of the number formed by the path from root to leaf. When I reach a leaf node (a node with no children), I add this string to a stack. The DFS function recursively explores all paths from root to leaf, accumulating the digits along the way. After exploring all paths, I convert each string in the stack to an integer, sum them up, and return the result. This method efficiently captures all root-to-leaf paths and calculates their sum without needing to store the entire tree structure in memory.

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        stack = []
        def dfs(node, s) :
            if not node :
                return
            if not (node.left or node.right) :
                stack.append(s+str(node.val))
                s = ""
                return
            dfs(node.left, s+str(node.val))
            dfs(node.right, s+str(node.val))
        dfs(root, "")
        return sum(list(map(int, stack)))