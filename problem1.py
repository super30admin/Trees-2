"""
Time: O(n^2)
Space: O(n) ???? <Not sure>
Leet: Accept
Problems: Space complexity

"""


class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder) == 0:
            return None
        value = postorder[-1]
        index = inorder.index(value)
        root = TreeNode(value)

        leftin = inorder[:index]
        rightin = inorder[index+1:]
        leftpost = postorder[:len(leftin)]
        rightpost = postorder[len(leftin):len(postorder)-1]



        root.left = self.buildTree(leftin,leftpost)
        root.right = self.buildTree(rightin,rightpost)

        return root
