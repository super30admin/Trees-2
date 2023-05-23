class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque

class Solution(object):
    def __init__(self):
        self.totalSum = 0              

    def __sumNumbers(self, root, value):
        #   base cases
        if (root == None):
            return
        if (root.left == None and root.right == None):
            self.totalSum += (value * 10 + root.val)
            return

        self.__sumNumbers(root.left, value * 10 + root.val)
        self.__sumNumbers(root.right, value * 10 + root.val)

    def sumNumbers(self, root):

        self.__sumNumbers(root, 0)
        return self.totalSum


class SumRootToLeaf_Stack(object):
    def sumNumbers(self, root):
        
        totalSum = 0
        if (root == None):
            return totalSum

        stack = [[root, 0, 0]]

        while (len(stack) > 0):

            topNode = stack[-1][0]
            topValue = stack[-1][1]
            topCount = stack[-1][2]

            if (topCount == 0):           
                stack[-1][2] += 1
                if (topNode.left != None):
                    stack.append([topNode.left, topValue * 10 + topNode.val, 0])
                continue

            elif (topCount == 1):         
                stack[-1][2] += 1
                if (topNode.right != None):
                    stack.append([topNode.right, topValue * 10 + topNode.val, 0])   
                continue

            elif (topCount == 2):           
                if (topNode.left == None and topNode.right == None):  
                    totalSum += (topValue * 10 + topNode.val)
                stack.pop()

        return totalSum


class SumRootToLeaf_Queue(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # edge case check
        if (root == None):
            return 0

        totalSum = 0
        queue = deque([[root, 0]])  

        while (len(queue) > 0):

            front = queue.popleft()
            frontNode = front[0]
            frontValue = front[1]

            if frontNode.left == None and frontNode.right == None:  
                totalSum += (frontValue * 10 + frontNode.val)

            if frontNode.left != None:                         
                queue.append([frontNode.left, frontValue * 10 + frontNode.val])

            if frontNode.right != None:                           
                queue.append([frontNode.right, frontValue * 10 + frontNode.val])

        return totalSum