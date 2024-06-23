# Time Complexity :
# O(N)

# Space Complexity :  
# O(H)  ,  H = height of tree, recursion creates a stack where all nodes upto the left most child will be stored at max. 



# Approach:
# DFS Traversal of the tree. Create a global class variable to store "totalSum".
# ===> Start DFS call with root and 0 as starting values. ) corresponds to currSum=0 when we start the DFS call.
# ===> Keep track of currSum at each node, i.e update currSum
# ===> Check if the node is the leaf node, if so, update "totalSum" by adding "currSum" to "totalSum".
# ===> Perform Left and right recursive calls with left child / right child and updated currSum.



class Solution(object):
    def __init__(self):
        self.totalSum = 0

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        
        # second parameter corresponds to currSum = number created by all nodes in root-to-leaf path
        self.calcSum(root, 0)

        return self.totalSum
    

    def calcSum(self, root, currSum):
        if not root:
            return 0
        
        # update currSum here
        currSum = currSum*10 + root.val

        if not root.left and not root.right:
            self.totalSum = self.totalSum + currSum
            
        
        self.calcSum(root.left, currSum)
        
        self.calcSum(root.right, currSum)