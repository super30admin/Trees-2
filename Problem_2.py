'''
129 Sum root to leaf numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.


Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.

Let N = num of nodes, H = height of tree

Solution:
1. Perform inorder traversal initializing total sum, tot = 0.
Step 1: Then for each node encountered during the traversal, set
tot = tot* 10 + the value of the current node.
Step 2: If the left/right subtree is a child node, return the new total sum w/o traveling further.
Step 3: Compute the total sum of the left subtree by calling Step 1 with total sum set to tot
Step 4: Compute the total sum of the left subtree by calling Step 1 with total sum set to tot
Step 5: The tot sum of the tree = left tot sum + right tot sum. Return this sum.

Note: The total sum is independent of traversal order.
https://www.youtube.com/watch?v=oxZyTn72aEI&t=3843s

Time: O(N), Space: O(H)
'''
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def build_tree_level_order(values):
    N = len(values)
    if N == 0:
        return None
    q = deque()
    tree = TreeNode(values[0])
    q.append(tree)
    i=0
    while i < N and q:
        node = q.popleft()
        left_index = 2*i+1
        right_index = left_index + 1
        if left_index < N and values[left_index] is not None:
            node.left = TreeNode(values[left_index])
            q.append(node.left)
        if right_index < N and values[right_index] is not None:
            node.right = TreeNode(values[right_index])
            q.append(node.right)
        i += 1
    return tree

def helper_recursive(root, tot):
    if not root:
        return 0
    curr_sum = tot*10 + root.val
    if not root.left and not root.right: # child node
        return curr_sum
    left_tot = helper_recursive(root.left, curr_sum) # sum on left sub-tree
    right_tot = helper_recursive(root.right, curr_sum) # sum on right sub-tree
    return left_tot + right_tot

def helper_iterative(root):
    tot = 0
    stack =[]
    curr_sum = []
    curr_num  = 0
    while root or stack:
        while root:
            stack.append(root)
            curr_num = curr_num*10 + root.val
            curr_sum.append(curr_num)
            root = root.left
        root = stack.pop()
        curr_num = curr_sum.pop()
        if root.left is None and root.right is None:
            tot += curr_num
        root = root.right
    return tot

def sum_numbers(root, method='rec'):
    if not root:
        return 0
    if method == 'rec':
        return helper_recursive(root,0)
    elif method == 'iter':
        return helper_iterative(root)


def run_sum_numbers():
    tests = [([4,9,0,5,1], 1026), ([1,2,3], 25), ([1],1), ([1,2],12), ([],0)]
    for test in tests:
        root, ans = test[0], test[1]
        print(f"\ntree = {root}")
        root=build_tree_level_order(root)
        for method in ['rec', 'iter']:
            tot = sum_numbers(root, method)
            print(f"Method {method}: sum root-to-leaf = {tot}")
            print(f"Pass: {ans == tot}")

run_sum_numbers()