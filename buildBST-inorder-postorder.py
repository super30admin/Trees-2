class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
#time = O(n^2)
#space = O(n)
def build_tree_recursive(inorder, postorder):
    if not inorder or not postorder:
        return None
    
    root_val = postorder.pop()
    root = TreeNode(root_val)
    inorder_index = inorder.index(root_val)
    
    # Build right subtree first, because the last element in postorder is the root of the right subtree
    root.right = build_tree_recursive(inorder[inorder_index + 1:], postorder)
    root.left = build_tree_recursive(inorder[:inorder_index], postorder)
    
    return root

# Example usage:
inorder = [9, 3, 15, 20, 7]
postorder = [9, 15, 7, 20, 3]
tree = build_tree_recursive(inorder, postorder)

def print_tree(node, indent=""):
    if node is not None:
        print(indent + str(node.value))
        print_tree(node.left, indent + "   ")
        print_tree(node.right, indent + "   ")

print_tree(tree)