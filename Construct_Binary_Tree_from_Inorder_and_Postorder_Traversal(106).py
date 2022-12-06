# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we use the fact that the last element in the postorder is the root element followed by its right and left
# children(next roots)
# we find the root in the inorder and the left to it is the left subtree and right is the right subtree
class Solution:
    def __init__(self):
        #here we would need to look for the element in the inorder everytime
        # so we instead use a hashmap with element as key and index as value
        self.map = dict()
        self.idx = 0

    def buildTree(self, inorder: List[int], postorder: List[int],) -> Optional[TreeNode]:
        if postorder==None or inorder==None or len(postorder)!=len(inorder):
            return None
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        self.idx = len(postorder)-1
        return self.recurse(postorder,0,len(inorder)-1)

    def recurse(self,postorder,left,right):
        #base case
        if right<left:
            return None
        #logic
        rootVal = postorder[self.idx]
        self.idx-=1
        root = TreeNode(rootVal) #at each iteration we take the root in postorder and create a node
        rootIdx = self.map[rootVal]

        # the right subtree would be from rootindex till end
        root.right = self.recurse(postorder,rootIdx+1,right)
        # the left subtree would be from start till rootindex
        root.left = self.recurse(postorder,left,rootIdx-1)

        return root