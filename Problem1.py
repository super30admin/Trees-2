#Did it run on Leetcode?:Yes
#Time Complexity:O(n2) for every node we have to find index
#Space Complexity:O(1)
#From postorder's last we get root of the tree. we split the list of inorder by this root to get left and right subtree at every node.
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(inorder)==0:
            return None
        root=TreeNode(postorder.pop())
        middle=inorder.index(root.val)
        root.right=self.buildTree(inorder[middle+1:],postorder)
        root.left=self.buildTree(inorder[:middle],postorder)
        return root