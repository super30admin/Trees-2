# Approach 1 : Iterative Solution 
# For the iterative solution we need to make use of an auxilary stack

def sumNumbers(self, root: TreeNode) -> int:
    
    if root == None:
        return 0

    result = 0
    currentSum = 0
    stack = []

    while root != None or stack != []:

        while root != None:

            currentSum = (currentSum * 10) + root.val
            stack.append((root, currentSum))
            root = root.Left

        
        root, currentSum = stack.pop()

        if root.left is None and root.right is None:
            result += currentSum

        root = root.right

    return result 




# Approach 2: Recursive Solution 
# Same Time and space complexity, just that we need not use a stack explicitly


    def sumNumbers(self, root: TreeNode) -> int:

        if root == None:
            return 0

        self.result = 0

        self.helper(root, currentSum=0)
        return self.result

    def helper(self, root, currentSum):

        if root = None:
            return

        currentSum = currentSum * 10 + root.value

        if root.left is None and root.right is None:
            self.result += currentSum

        self.helper(root.left, currentSum)
        self.helper(root.right, currentSum)





    