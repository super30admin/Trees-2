"""

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
"""

#Approach - 1 
# TC: O(n2)
# SC: O(n2)


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #base condition
        if len(postorder) == 0: return
        #logic
        rootidx = -1
        root = TreeNode(postorder[-1])
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                rootidx = i
                break

        inl = inorder[0: rootidx]
        inr = inorder[rootidx + 1: len(inorder)]
        print("l",inr)
        postl = postorder[0: len(inl)]
        postr = postorder[len(postl): -1]
        print(postr)

        root.left = self.buildTree(inl, postl)
        root.right = self.buildTree(inr, postr)

        return root


# Appraoch - 2

# TC: O(n)
# SC: O(n)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        def helperTree(postorder, start, end):
            nonlocal idx
            nonlocal rootmap
            #base condition
            if start > end or idx < -len(postorder): return None

            #logic
            root = TreeNode(postorder[idx])
            idx -= 1
            rootidx = rootmap[root.val]
            root.right = helperTree(postorder, rootidx +1, end)
            root.left = helperTree(postorder, start, rootidx-1)
            

            return root

        idx = -1
        rootmap = {}
        for i in range(len(inorder)):
            rootmap[inorder[i]] = i

        return helperTree(postorder, 0, len(postorder)-1)

        


        