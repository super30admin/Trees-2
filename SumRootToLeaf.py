'''
Solution:
1.  The main idea is to add each node's value based on its parents' values and also based on its place value
2.  These can be done recursively or iteratively using a stack (DFS) or a queue (BFS)
3.  Return total sum if any of the nodes hits the leaf node.

-- Passed all test cases on Leetcode successfully for all 3 Recursive, Iterative (Stack / Queue) approaches.

Time Complexity:    Recursive -- O(nodes), Iterative (Stack-DFS) -- O(nodes) and Iterative (Queue-BFS)-- O(nodes)
Space Complexity:   Recursive -- O(height), Iterative (Stack-DFS) -- O(height) and Iterative (Queue-BFS)-- O(nodes)

'''


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class SumRootToLeaf_Recursive(object):
    def __init__(self):
        self.totalSum = 0               # this needs to be updated and returned finally

    def __sumNumbers(self, root, value):
        #   base cases
        if (root == None):
            return
        if (root.left == None and root.right == None):
            self.totalSum += (value * 10 + root.val)
            return

        #   recursive calls by passing updated values using place value to the recursion calls.
        self.__sumNumbers(root.left, value * 10 + root.val)
        self.__sumNumbers(root.right, value * 10 + root.val)

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #   call helper function
        self.__sumNumbers(root, 0)
        return self.totalSum


class SumRootToLeaf_Stack(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #   edge case check
        totalSum = 0
        if (root == None):
            return totalSum

        #   initialize stack
        #   each element in stack contains a node, count (0, 1 or 2 based on no. of children visited), current value
        stack = [[root, 0, 0]]

        while (len(stack) > 0):

            topNode = stack[-1][0]
            topValue = stack[-1][1]
            topCount = stack[-1][2]

            if (topCount == 0):             # if none of the children is visted => count is 0
                stack[-1][2] += 1
                if (topNode.left != None):
                    stack.append([topNode.left, topValue * 10 + topNode.val, 0])    #   add left element to stack
                continue

            elif (topCount == 1):           # if one of the children is visted => count is 1
                stack[-1][2] += 1
                if (topNode.right != None):
                    stack.append([topNode.right, topValue * 10 + topNode.val, 0])   #   add right element to stack
                continue

            elif (topCount == 2):           # if both of the children is visted => count is 2
                if (topNode.left == None and topNode.right == None):    # check for leaf node
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
        queue = deque([[root, 0]])      #   initialize queue with node and current value till that node

        while (len(queue) > 0):

            front = queue.popleft()
            frontNode = front[0]
            frontValue = front[1]

            if frontNode.left == None and frontNode.right == None:  # if leaf node, add it to the total sum
                totalSum += (frontValue * 10 + frontNode.val)

            if frontNode.left != None:                              # if left node not none, append it to the queue
                queue.append([frontNode.left, frontValue * 10 + frontNode.val])

            if frontNode.right != None:                             # if right node not none, append it to the queue
                queue.append([frontNode.right, frontValue * 10 + frontNode.val])

        return totalSum