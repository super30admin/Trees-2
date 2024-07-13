#I used a recursive method to build the tree. First, I handle the base case where either the inorder or postorder list is empty. Then, I take the last element from the postorder list as the root of the current subtree, since in postorder traversal, the root is always the last element. I find this root's position in the inorder list, which tells me how many elements are in the left and right subtrees. Using this information, I recursively build the right subtree first (because we're working backwards from the end of the postorder list), then the left subtree. For the right subtree, I use the elements after the root in the inorder list, and for the left subtree, I use the elements before the root. This process continues until we've used all elements to construct the entire tree.

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder or not postorder:
            return None
        # val will be root
        val=postorder.pop()
        # finding index in root
        index=inorder.index(val)
        root=TreeNode(val)
        #first we need to create right then left
        root.right=self.buildTree(inorder[index+1:],postorder)
        root.left=self.buildTree(inorder[:index],postorder)
        return root
