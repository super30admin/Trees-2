'''

Solution:
1.  The main idea is that the last element in postorder would be the root and so find that element's location in inorder
    array. Later, the subarray before this index and subarray after this index are sub trees with inorder ordering.
2.  Use either recursion or a stack (DFS) approach to build the subtrees recursively or iteratively.
3.  Return the main root node which was initialized in the beginning.

--- All Testcases successfully passed on Leetcode for both Recursive and Iterative Approaches.

Time Complexity:    Recursive -- O(n) and Iterative -- O(n)
Space Complexity:   Recursive -- O(n) and Iterative -- O(n)

'''


from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class BuildTreeInPost_Recursive(object):

    def __init__(self):
        # initialize these globally so that they won't be repeated
        self.postorder = []
        self.inorder = []
        self.indices = {}
        self.index = 0

    def __buildTree(self, inS, inE):
        # base case -- only variables which change throughout recursion are start and end pointers in inorder subarrays
        if (inS > inE) or self.index < 0:
            return None

        # main computation before calling recursion
        inIdx = self.indices[self.postorder[self.index]]
        currentRoot = TreeNode(self.postorder[self.index])

        self.index -= 1                                         # decrement index of postorder before calling recursion
        currentRoot.right = self.__buildTree(inIdx + 1, inE)    # recursion on right subarray first
        currentRoot.left = self.__buildTree(inS, inIdx - 1)     # recursion on left subarray next

        return currentRoot                                      # return main tree node

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # edge case check
        if (postorder == None or len(postorder) == 0):
            return None

        # store a HashMap along with given arrays as global variables or attributes of the current class
        self.postorder = postorder
        self.inorder = inorder
        self.index = len(postorder) - 1

        for i in range(len(self.inorder)):
            self.indices[self.inorder[i]] = i

        # call helper function
        return self.__buildTree(0, len(self.inorder) - 1)


class BuildTreeInPost_Stack(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # edge case check
        if (postorder == None or len(postorder) == 0):
            return None

        # store a HashMap containing indices of elements in inorder
        indices = {}
        for i in range(len(inorder)):
            indices[inorder[i]] = i

        # initialize the stack
        # each element in stack contain -- node, count (0, 1, or 2 to check whether its children has been traversed or not),
        #                                  minimum index in inorder array, maximum index in inorder array
        rootNode = TreeNode(postorder[-1])
        stack = deque([[rootNode, 0, 0, len(postorder) - 1]])
        index = len(postorder) - 2         # appropriate location of main index in postorder to start with

        while (len(stack) > 0):
            top = stack[-1]                # top element in the stack
            topNode = top[0]
            topCount = top[1]
            topMin = top[2]
            topMax = top[3]

            if topCount == 0:              # if none of the children is visted => count is 0
                stack[-1][1] += 1
                if (index >= 0 and index < len(postorder)):     #   edge case check for node creation
                    if (topMax < indices[topNode.val] + 1):     #   push new node only if the condition satisifies
                        continue
                    topNode.right = TreeNode(postorder[index])  #   attach new node to the right
                    stack.append([topNode.right, 0, indices[topNode.val] + 1, topMax])
                index -= 1                                      # reduce index by 1 of postorder index

            elif topCount == 1:             # if one of the children is visted => count is 1
                stack[-1][1] += 1
                if (index >= 0 and index < len(postorder)):     #   edge case check for node creation
                    if (topMin > indices[topNode.val] - 1):     #   push new node only if the condition satisifies
                        continue
                    topNode.left = TreeNode(postorder[index])   #   attach new node to the left
                    stack.append([topNode.left, 0, topMin, indices[topNode.val] - 1])
                index -= 1                                      # reduce index by 1 of postorder index

            elif topCount == 2:             # if both of the children is visted => count is 2 => just pop the element
                stack.pop()

        return rootNode