# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def sumNumbers(self, root: TreeNode) -> int:
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        
        self.result = 0
        self.helper(root, 0)
        return self.result
        
    def helper(self, root, currSum):
        #base
        if not root:
            return
        
        #logic
        currSum = currSum * 10 + root.val
        self.helper(root.left, currSum)
        #st.pop()
        if not (root.left or root.right):
            self.result += currSum
        self.helper(root.right, currSum)
    
    #Solution 2
    """
    def sumNumbers(self, root: TreeNode) -> int:
        #Approach: Iterative
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        
        result = 0
        currSum = 0
        st = []
        
        while root or st:
            while root:
                currSum = 10 * currSum + root.val
                st.append((root, currSum))
                root = root.left
            root, currSum = st.pop()
            
            if not (root.left or root.right):
                result += currSum
            
            root = root.right
            
        return result
    """