#time complexity: O(n) i.e. number of nodes of the tree
#space complexity : O(h) i.e. size of the stack would be not more than the height of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#by irrative solution
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #Initialising two stack
        stack1 = []
        stack2 = []
        #initialising the global variable for storing result and currentNumber 
        result =0
        currentNumber=0
        #while loop will work till stack become empty or till root is not null 
        while root!= None or stack1!=[]:
            #while loop will work for each path till it reach the leaf node
            while root!= None:
                #adding the present root element 
                currentNumber = currentNumber*10 + root.val
                #appending the present root element with the root and the current Number
                stack1.append(root)
                stack2.append(currentNumber)
                #calling for the left side of the root
                root =root.left
            #removing the element from the stack one after the other once we reach the leaf node 
            root = stack1.pop()
            currentNumber = stack2.pop()
            #if the leaf node is reached then summing up all the results
            if root.left == None and root.right == None:
                result += currentNumber
            #calling for the right side of the root   
            root =root.right
        return result
