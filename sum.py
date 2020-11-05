#The simple way to do this is to check for root and left right array from inorder and preeorder reespectiveely.
#Time Complexity: O(n)
#Space Complexity: O(h)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = 0
    def getTree(self,root):
        if root is None:
            return
        self.helper(root,0)
        return self.result

    def helper(self,root,currSum):
        if root is None:
            return
        currSum = currSum*10 + root.val
        if (root.left is None or root.right is None):
            self.result = self.result + currSum
        
        self.helper(root.left,currSum)
        self.helper(root.right,currSum)


n1 = TreeNode(5)
n2 = TreeNode(3)
n3 = TreeNode(6)
n1.left = n2
n1.right = n3
s = Solution()
s = s.getTree(n1)
print(s)