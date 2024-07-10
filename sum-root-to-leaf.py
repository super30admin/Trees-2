class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

#time = O(n)
#space = O(h)

def sum_numbers_recursive(root):
    def dfs(node, current_number):
        if not node:
            return 0
        current_number = current_number * 10 + node.value
        if not node.left and not node.right:
            return current_number
        return dfs(node.left, current_number) + dfs(node.right, current_number)
    
    return dfs(root, 0)

# Example usage:
# Constructing the tree:
#     1
#    / \
#   2   3
tree = TreeNode(1)
tree.left = TreeNode(2)
tree.right = TreeNode(3)

print(sum_numbers_recursive(tree))  # Output: 25 (12 + 13)