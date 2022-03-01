#Time Complexity:
#Space Complexity:
#Leetcode: 

class Node:
    def __init__(self, data):
        self.val=data
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root):
        self.helper(root, 0)
        return self.sum

    def helper(self, root, nums):
        if root == None:
            return
        
        self.helper(root.left, nums*10 + root.val)
        self.helper(root.right, nums*10 + root.val)

        if root.left  == None and root.right == None:
            #Stack Output = 5,49
            self.sum += nums*10 + root.val



if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    obj = Solution()
    print(obj.sumNumbers(root))