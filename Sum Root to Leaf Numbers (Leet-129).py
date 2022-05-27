# Time Complexity: O(N)
# Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        st = list()
        numst = list()
        num = 0
        total_sum = 0
        print(num)
        while root != None or len(st) != 0:
            while root != None:
                num = num*10 + root.val
                st.append(root)
                numst.append(num)
                root = root.left

            root = st.pop()
            num = numst.pop()
            if root.left is None and root.right is None:
                total_sum += num
            root = root.right
        return total_sum


######################################################################

# Time Complexity: O(N)
# Space Complexity: O(H), where H is the height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    total_sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return self.total_sum
        self.helper(root, 0)
        return self.total_sum
    
    def helper(self, root, num):
        if root is None:    
            return
        if root.left is None and root.right is None:
            self.total_sum += num*10 + root.val
            return
        
        self.helper(root.left, num*10+root.val)
        self.helper(root.right, num*10+root.val)

######################################################################

# Time Complexity: O(N)
# Space Complexity: O(H), where H is the height


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    total_sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)
    
    def helper(self, root, num):
        if root is None:    
            return 0
        
        if root.left is None and root.right is None:
            return num*10 + root.val
    
                
        return self.helper(root.left, num*10+root.val) + self.helper(root.right, num*10+root.val)