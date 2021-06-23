# Time Complexity: O(n)
# Space Complexity: O(h)

class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    out_arr = []

    def buildTree(self, inorder, postorder):
        # initialize current value as 0
        curr_val = 0

        if len(postorder) == 0:
            return None
        # take current root of the tree/subtree as last element in postorder array
        curr_val = postorder[len(postorder) - 1]
        # Create root node of tree with current value
        root = TreeNode(curr_val)

        # Initialize the index of head in inorder array  to 0
        index = 0

        # find the current head in postorder in inorder array and update the index and add it to output array
        for i in range(len(inorder)):
            if inorder[i] == curr_val:
                index = i
                self.out_arr.append(inorder[i])
        # print(inorder[0:index])

        # call the function recursively and assign left and
        # right child of the root  accordingly considering the range in given array
        root.left = self.buildTree(inorder[0:index], postorder[0:index])
        root.right = self.buildTree(inorder[index + 1:len(inorder)], postorder[index:len(postorder) - 1])

        # return tree node
        return root
