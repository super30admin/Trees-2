
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(in_left, in_right):

            if in_left > in_right:
                return None


            val = postorder.pop()
            root = TreeNode(val)


            index = hash_map[val]


            root.right = helper(index + 1, in_right)

            root.left = helper(in_left, index - 1)
            return root


        hash_map = {val:idx for idx, val in enumerate(inorder)}
        return helper(0, len(inorder) - 1)



# O(n^2)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        if postorder is None or len(postorder)==0:
            return None
        m = len(postorder)
        n = len(inorder)
        rootVal = postorder[m-1]
        root = TreeNode(rootVal)
        rootIdx =-1
        for i in range(n):
            if inorder[i]==rootVal:
                rootIdx = i

        # not getting the split up properly
        post_right = postorder[rootIdx+1:m-1]
        post_left = postorder[0:rootIdx]

        in_left = inorder[0:rootIdx]
        in_right = inorder[rootIdx+1:n]

        root.left = self.buildTree(post_left,in_left)
        root.right = self.buildTree(post_right,in_right)

        return root
