#Time Complexity: O(N)
#Space Complexity: O(N)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.idx = 0
        self.hashMap = {}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder or len(inorder)==0:
            return None
        self.idx = len(postorder)-1
        for i in range(len(inorder)):
            self.hashMap[inorder[i]]=i
        return self.recurse(inorder,postorder,0,len(inorder)-1)
    def recurse(self,inorder,postorder,start,end):
        if start>end:
            return None
        rootVal = postorder[self.idx]
        self.idx-=1
        rootIdx = self.hashMap[rootVal]
        root = TreeNode(rootVal)
        root.right = self.recurse(inorder,postorder,rootIdx+1,end)
        root.left = self.recurse(inorder,postorder,start,rootIdx-1)
        return root