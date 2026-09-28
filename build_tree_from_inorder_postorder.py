'''
106 Construct Binary Tree from Inorder and Postorder traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Note: You may assume that duplicates do not exist in the tree.

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
For explanation, refer the doc string in 105 Construct Binary Tree From Preorder And Inorder Traversal
Time: O(N^2), Space: O(N^2)

Note: The order of attending to right subtree first and left subtree second matters. This is because postorder traversal is left-right-root. If we are starting from root and going left, we process the nodes in root -> right -> left sequence.


2. Hashing + Two pointer:
For explanation, refer the doc string in 105 Construct Binary Tree From Preorder And Inorder Traversal
Time: O(N), Space: O(N)

https://youtu.be/TfnvkPC4UrI?t=5202
'''

from binary_tree import *

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

def build_tree_1(postorder, inorder):
    '''
        Brute Force
    '''
    def get_root_id_from_inorder(val, inorder):
        '''
        Linear search O(N)
        Assumption: No duplicates in array since this is given in the constraint
        of the problem
        '''
        N = len(inorder)
        for i in range(N):
            if inorder[i] == val:
                return i
        return -1

    def recurse(postorder, inorder):
        M, N = len(postorder), len(inorder)
        assert M == N, f"lengths of postorder and inorder arrays are not equal"
        if M == 0 or N == 0:
            return None

        root_val = postorder[M-1]
        root = TreeNode(root_val)
        root_idx = get_root_id_from_inorder(root_val, inorder)

        in_left = inorder[0:root_idx]
        in_right = inorder[1+root_idx:]

        post_right = postorder[M-1-len(in_right):M-1]
        post_left = postorder[0:M-1-len(in_right)]

        if in_right:
            root.right = recurse(post_right, in_right)

        if in_left:
            root.left = recurse(post_left, in_left)

        return root

    N = len(postorder)
    if N == 0:
        return []
    assert N == len(inorder), f"Lengths of Inorder and Preorder must be the same"
    root = recurse(postorder, inorder)
    return root


def build_tree_2(postorder, inorder):
    '''
    Hash map + Two-pointer
    '''
    def recurse(start, end):
        '''
        start: starting index of inorder array
        end: ending index of inorder array
        '''
        nonlocal pre_root_idx
        if start > end:
            return
        if pre_root_idx > N-1:
            return

        root_val = postorder[pre_root_idx]
        # root id in inorder using hash map O(1)
        in_root_idx = h[root_val]
        pre_root_idx -= 1
        root = TreeNode(root_val)
        root.right = recurse(in_root_idx + 1, end)
        root.left = recurse(start, in_root_idx - 1)
        return root

    N = len(postorder)
    if N == 0:
        return []
    assert N == len(inorder), f"Lengths of Inorder and Preorder must be the same"
    h = {}
    for i in range(N):
        h[inorder[i]] = i

    pre_root_idx = -1
    root = recurse(0, N-1)
    return root

def run_tests():
    tests = [([9,15,7,20,3],[9,3,15,20,7],[3,9,20,15,7]),
            ([3,2,1], [1,2,3], [1,2,3]),
            ([-4,-1,3,-10,11,-8,2,7], [-4,-10,3,-1,7,11,-8,2], [7,-10,2,-4,3,-8,-1,11]),
            ([-1],[-1],[-1]),
            ([],[],[])]
    for test in tests:
        postorder, inorder, ans = test[0], test[1], test[2]
        ans_tree = build_tree_level_order(ans)
        ans_tree.display()

        tree1 = build_tree_1(postorder, inorder)
        res1 = levelOrderTraversal(tree1)
        tree2 = build_tree_2(postorder, inorder)
        res2 = levelOrderTraversal(tree2)
        print(f"\npost = {postorder}")
        print(f"in = {inorder}")
        print(f"1. Brute Force = {res1}")
        print(f"2. Hashing + Two pointer  = {res2}")
        passed = (ans == res1 == res2)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()