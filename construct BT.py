class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0:
            return

        root = postorder[-1]
        rin = inorder.index(root)
        root = TreeNode(root)
        
        leftin = inorder[:rin]
        rightin = inorder[rin+1:]

        leftpos = postorder[:len(leftin)]
        rightpos = postorder[len(leftin):-1]

        root.left = self.buildTree(leftin,leftpos)
        root.right = self.buildTree(rightin,rightpos)

        return root

# Time complexity : O(N)
# Space complexity : 0(N)
