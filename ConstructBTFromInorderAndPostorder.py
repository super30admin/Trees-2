#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n in the number of nodes in the tree

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Since in postorder root is the last element preceesed by right and left children. Maintaining an index, starting from the end, I get the "root" from postorder, making that the root of the tree, then finding that element in inorder (where we know the order is left, root, right), and that ensures that elements to the left of the the root element in inorder is the left subtree and the elements to the right are of the right subtree. This way I way make node.left and node.right of each node and recursively calling the function again and again till elements remain in the inorder array. This will form the entire tree.

#Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        mapping = {}
        for i in range(len(inorder)):
            mapping[inorder[i]] = i
        self.ind = len(postorder)-1

        def build(inorder, postorder, start, end):
            if start > end:
                return None

            nodeVal = postorder[self.ind]
            self.ind -= 1

            nodeInd = mapping[nodeVal]

            node = TreeNode(nodeVal)
            node.right = build(inorder, postorder, nodeInd+1, end)
            node.left = build(inorder, postorder, start, nodeInd-1)

            return node

        return build(inorder, postorder, 0, len(inorder)-1)
