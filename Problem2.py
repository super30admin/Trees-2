# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # 1) Iterative : Time = O(n) time | O(n) Space, n for auxiliary stack.
    # def sumNumbers(self, root):
    #     if not root:
    #         return 0 
    #     stack = []
    #     currSum = 0 
    #     result = 0 
    #     while root or stack :
    #         while root:
    #             currSum = currSum * 10 + root.val 
    #             stack.append((currSum,root))
    #             root = root.left 
    #         node = stack.pop()
    #         root = node[1] 
    #         currSum = node[0]
    #         if not root.left and not root.right: # Leaf node 
    #             result += currSum 
    #         root = root.right 
    #     return result

    #2) Recursive : O(n) time | O(n) Space
    def sumNumbers(self, root):
        if not root:
            return 0 
        return self.helper(root,0)
    
    def helper(self,root,currSum):
        # base 
        if not root:
            return 0 
        if not root.left and not root.right:
            return currSum*10 + root.val 
        return self.helper(root.left,currSum*10+root.val) + self.helper(root.right,currSum*10+root.val)


if __name__ =="__main__":
    s = Solution()
    # n = TreeNode(1)
    # n.left = TreeNode(2)
    # n.right = TreeNode(3)
    n = TreeNode(4)
    n.left = TreeNode(9)
    n.right = TreeNode(0)
    n.left.left = TreeNode(5)
    n.left.right = TreeNode(1)
    res = s.sumNumbers(n)
    print(res)
    