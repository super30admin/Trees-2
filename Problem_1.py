'''
106 Construct Binary Tree from Inorder and Postorder traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

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

Let N = num of nodes, H = height of tree

Solution:
1. Brute Force:
Maintain an index (pidx) to retrieve the root node from preorder[] list.
Based on pidx, get the root node using preorder[pidx]. Set pidx = N-1 (last node of postorder[] is the root node of the tree)

Step 1: Find the corresponding index (call it 'mid') of the root node in inorder[] using linear search. Create root node.

Step 2: Nodes right of inorder[mid] constitute the right subtree. Build the right subtree by using a recurive call after setting pidx = pidx - 1.

Step 3: Nodes left of inorder[mid] constitute the left subtree. Build the left subtree by using a recurive call after setting pidx = pidx - 1

Note: The order of attending to right subtree first and left subtree second matters. This is because postorder traversal is left-right-root. If we are starting from root and going left, we process the nodes in root -> right -> left sequence.


Time complexity is based on traversing all nodes (O(N)) but for each node
we perform a linear search which is another O(N).
Time: O(N^2), Space: O(H)

2. Hashing: This is similar in logic as Brute force but uses a hash table
for finding the index ('mid') of the root node in inorder[]
Time is reduced to O(N) for traversing the nodes. Hash table lookup takes only O(1). Space is O(N) due to hash table and O(H) due to recursion stack
Time: O(N), Space: O(N + H) = O(N)
'''

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def levelOrderTraversal(tree):
    q = deque()
    array=[]
    if not tree:
        return []
    q.append(tree)
    while q:
        node = q.popleft()
        #print(node.val, end = " --> ")
        array.append(node.val)
        if node.left:
            q.append(node.left)
        if node.right:
            q.append(node.right)
    #print(f"None")
    return array


def build_tree(postorder, inorder):
    def helper(postorder, inorder, left, right):
        nonlocal pidx
        N = len(postorder)
        if N == 0:
            return []
        if pidx < 0 or pidx > N-1:
            return None

        # Build the root node
        root_val = postorder[pidx]
        root = TreeNode(root_val)
        mid = h[root_val]

        # Build the right subtree if it exists
        right_tree = inorder[mid+1:right+1]
        if len(right_tree) == 1:
            pidx -= 1
            root.right = TreeNode(right_tree[0])
        elif len(right_tree) > 1:
            pidx -= 1
            root.right = helper(postorder, inorder, mid+1, right)
        else: # len = 0 (doesn't exist)
            # root.right = None (by default)
            pass

        # Build the left subtree if it exists
        left_tree = inorder[left:mid]
        if len(left_tree) == 1:
            pidx -= 1
            root.left = TreeNode(left_tree[0])
        elif len(left_tree) > 1:
            pidx -= 1
            root.left = helper(postorder, inorder, left, mid-1)
        else: # len = 0 (doesn't exist)
            # root.left = None (by default)
            pass

        return root


    # index of root in postorder[]
    pidx = len(postorder) - 1

    # lookup table to retrieve indices of all nodes in inorder[]
    h = {value: index for index, value in enumerate(inorder)}

    # define the partitions of inorder[]
    # inorder = [(<-- left subtree -->), (root), (<--right subtree) -->]
    #         = [(left,...,mid-1), (mid), (mid+1,...,right)]

    # start index of inorder[] comprising of nodes in left subtree
    left = 0
    # end index of inorder[] comprising of nodes in right subtree
    right = len(inorder) - 1

    root = helper(postorder, inorder, left, right)
    return root

def run_build_tree():
    tests = [([9,15,7,20,3],[9,3,15,20,7],[3,9,20,15,7]),
            ([3,2,1], [1,2,3], [1,2,3]),
            ([-4,-1,3,-10,11,-8,2,7], [-4,-10,3,-1,7,11,-8,2], [7,-10,2,-4,3,-8,-1,11]),
            ([-1],[-1],[-1]),
            ([],[],[])]
    for test in tests:
        postorder, inorder, ans = test[0], test[1], test[2]
        tree = build_tree(postorder, inorder)
        levelorder = levelOrderTraversal(tree)
        print(f"\npre = {postorder}")
        print(f"in = {inorder}")
        print(f"level = {levelorder}")
        print(f"Pass: {ans == levelorder}")

run_build_tree()