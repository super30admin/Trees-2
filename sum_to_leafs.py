# Time Complexity : O(n)
# Space Complexity : O(h)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Add:
    def __init__(self):
        self.result = 0

    def add_to_leafs(self, root, sum1):
        if root == None:
            return
        sum1 = (sum1 * 10 + root.val) 
        if root.left == None and root.right == None:
            self.result += sum1
            print(self.result)
        self.add_to_leafs(root.left, sum1)
        self.add_to_leafs(root.right, sum1)

if __name__ == "__main__":
    root = TreeNode(4, TreeNode(9, TreeNode(5), TreeNode(1)), TreeNode(0))
    adder = Add()
    adder.add_to_leafs(root, 0)
    