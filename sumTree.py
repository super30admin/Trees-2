#Time Complexity: O(n)
#Space Complexity: O(1)

class Root:
    def __init__(self, value):
        self.val = value
        self.left = None
        self.right = None

class Solution:
    def sumNumbers(self, root):
        
        #dfs solution
       
        res = 0

        def dfs(root, path):

            nonlocal res

            path+= str(root.val)

            if root.left == None and root.right == None:
                res+= int(path)

            if root.left is not None:
                dfs(root.left, path)

            if root.right is not None:
                dfs(root.right, path)

        dfs(root, '')
        return res


root = Root(1)
root.left = Root(2)
root.right = Root(3)

result = Solution()
op = result.sumNumbers(root)
print(op)