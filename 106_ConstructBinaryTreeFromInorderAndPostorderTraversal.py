"""
Leetcode - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ (submitted)
TC- O(N) - number of elements in tree, SC- O(1) hashmap
Lecture- https://www.youtube.com/watch?v=M_YPbb6vlNY, https://youtu.be/JW2KxAHFqv8?t=3718 (variation of preorder inorder)
FAQ-
Why do you need two traversals? Can you do with a single traversal?
There can be multiple possible trees from just one traversal. That's why we need at least two traversals.


Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is
the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Ideation - Brute force recursion O(N^2) - number of elements * [finding root index + creating sub [postOrder] and
    inorder]

    last element in the postorder will be our root.
    Find the root in inorder
    Inorder - left subsequence to the inorder will be our left subtree and right index to the inorder will be our right
    subtree.
    postorder - from previous element to the root to length of right subsequence in inorder will be our postorder for
    right subtree, and similarly we will have our left subtree postorder before our right subtree postorder.

    This gives us a repeated subproblem so we call our recursion on it.
    """

    def buildTree1(self, inorder, postorder):
        n = len(postorder)
        if n == 0:
            return None
        self.rootIdx = - 1

        root = TreeNode(postorder[n - 1])
        # find root in inorder - unique values - O(N)
        for i in range(n):
            if inorder[i] == root.val:
                self.rootIdx = i
                break
        # creating left tree (subsequence) and right tree (subsequence) of both inorder and postorder - O(N)
        inLeft = inorder[: self.rootIdx]
        inRight = inorder[self.rootIdx + 1:]
        postLeft = postorder[:len(inLeft)]
        postRight = postorder[len(postLeft):n - 1]

        # call recursion on left and right
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)

        return root

    """
    Ideation - Using Hashmap O(N)
    
    We can reduce the time of finding the root in Inorder for each element in the tree by adding it to hashmap.
    To make the TC O(N), we need to also reduce generating sub arrays for inorder and postorder.
    So what we can do is, once you know the index of the root, you can make recursive call for left and right by sending
    the index, start and end, in the recursion. 
    Also decrement postorder index by 1 after each node is processed. Doing so in postorder, we keep going to right 
    child, right then left, which is what postorder does. Refer lecture if it doesn't make sense.
    """

    def buildTree(self, inorder, postorder):
        n = len(postorder)
        self.postIdx = n-1
        if n == 0:
            return None

        # create hashmap to store inorder elements
        map = {}
        for i in range(n):
            if inorder[i] not in map:
                map[inorder[i]] = i
        return self.helper(postorder, map, 0, n - 1)

    # start and end for inorder
    def helper(self, postorder, map, startI, endI):
        if startI > endI:
            return None

        curr = postorder[self.postIdx]
        root = TreeNode(curr)
        self.postIdx -= 1

        rootIdx = map[curr]

        # flipping the right and left because we are going from right to left and postorder so after root right is
        # processed.
        root.right = self.helper(postorder, map, rootIdx + 1, endI)
        root.left = self.helper(postorder, map, startI, rootIdx - 1)

        return root