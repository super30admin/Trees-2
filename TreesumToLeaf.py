# TC: O(N)
# SC: O(H)
# We visit each node and extend currSum. When leaf node is reached- we add the existing currSum to result. Repeat for all root to leaf. We store currSum locally at each node to retrieve when required. 
# Iterative
class Solution1:
    res = 0
    def sumNumbers(self, root):
        if root == None: return 0
        stack = []
        currSum, ans = 0, 0
        while root != None or stack:
            while root != None:
                currSum = currSum * 10 + root.val
                stack.append((root, currSum))
                root = root.left
            root, currSum = stack.pop()
            # leaf node
            if root.left == None and root.right == None:
                ans += currSum
            root = root.right
        return ans

# Recursion
class Solution2:
    res = 0
    def sumNumbers(self, root):
        if root == None: return 0
        self.helper(root, 0)
        return self.res
    
    def helper(self, root, currSum):
        # base
        if root == None: return 
        # logic
        currSum = currSum * 10 + root.val
        self.helper(root.left, currSum)
        if root.left == None and root.right == None:
            self.res += currSum
        self.helper(root.right, currSum)

# Recursion: check if next node is the leef node in the prev step.  Pre order traversal. We check for leaf node at one step prior. No significant difference in complexities.
class Solution3:
    res = 0
    def sumNumbers(self, root):
        if root == None: return 0
        self.helper(root, 0)
        return self.res
    
    def helper(self, root, currSum):
        # base
        if root == None: return 
        if root.left == None and root.right == None:
            self.res += currSum * 10 + root.val
        # logic
        currSum = currSum * 10 + root.val
        self.helper(root.left, currSum)
        
        self.helper(root.right, currSum)