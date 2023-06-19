# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Here we use create a hashmap that helps point to the index of a given element in the inorder array.
#  We know that as we go along the postorder array (in reverse), if we are able to find the element in the inorder array, we can split the inorder array into left and right subtrees at that node.
#  We use this property to move an iterator along the postOrder array, and construct the nodes and recurse properly into the left and right subtrees using the inorder array.
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        postIdx = len(postorder)-1
        mp = {}
        for idx, i in enumerate(inorder):
            mp[i] = idx
        
        def helper(preorder, inorder, instart, inend):
            nonlocal mp, postIdx
            if instart > inend:
                return None
            inIdx = mp[postorder[postIdx]]
            root = TreeNode(postorder[postIdx])
            postIdx -= 1
            root.right = helper(postorder, inorder, inIdx+1, inend)
            root.left = helper(postorder, inorder, instart, inIdx-1)
            return root

        return helper(postorder, inorder, 0, len(inorder)-1)    