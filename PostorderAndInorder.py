# Time Complexity : O(n), where n is the number of nodes in the tree. The hashmap allows O(1) time for finding the index of the root in the inorder list, and each node is visited once.
# Space Complexity : O(n) for the recursion stack (in the worst case of a skewed tree) and the hashmap, which stores the indices of all elements in the inorder list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree
 
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.HashMap=dict()
        self.idx=len(postorder)-1
        for i in range(0,len(inorder)):
            self.HashMap[inorder[i]]=i
        return self.helper(postorder, 0, len(inorder)-1)
    def helper(self,postorder,start,end):
        if(start>end):
            return None
        rootVal = postorder[self.idx]
        self.idx-=1
        root = TreeNode(rootVal)
        rootIdx = self.HashMap.get(rootVal)
        root.right = self.helper(postorder,rootIdx+1,end)
        root.left = self.helper(postorder,start,rootIdx-1)
        return root