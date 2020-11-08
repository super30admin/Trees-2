"""
The apporach here is same. first find the root element from the postorder. it would be the last element
in the postorder array. now find for that element in the inorder, the left elements towards the root element
found would be the elements towards the left of the main-tree and the elements towards the right will
be the right nodes of the tree. now create new inorder sub-arrays for each left and right sub trees by passing
appropriate indices mentioned. call the function recursively to build the entire tree.
Leetcode - running
Time complexity - O(N)
Space complexity - O(N)
"""
def buildTree(self, inorder, postorder):
        if len(inorder) ==0 or len(postorder) ==0:
            return None
        val = postorder.pop(-1)
        root = TreeNode(val)
        mid = inorder.index(val)
        root.right = self.buildTree(inorder[mid+1:len(inorder)],postorder)
        root.left = self.buildTree(inorder[0:mid],postorder)
        return root

        