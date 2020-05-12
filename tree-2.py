# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Problem 1:Construct Binary Tree from inorder and Poster order Traversal
#Time Complexity O(n)
#space complexity O(n)
#Worked on leetcode?: YES
'''
Posterorder follows this logic: store the furthest element left , then if it's terminated, go to
the element that is directly on the right (not children) of this element. Then store as if you
restarted the postorder traversal. So the rule, furthest left, if terminated, store, go right,
if terminated, store, else traverse postorder, if left and right were terminated, store the
root node.

So reversed postorder is like preorder but right first, then left.
'''
'''
Main idea: Given the symmetry of postorder and preorder explained above, it's the same as for inorder and postorder,
but this time, the last element represents the head of the present tree and we go right first, then left.
'''
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:

        h={value:i for i,value in enumerate(inorder)}

        def helper(left,right):
            if left>right:
                #it means there are no element to construct the tree
                return None
            present_head_value=postorder.pop()
            to_split=h[present_head_value]

            root=TreeNode(present_head_value)

            root.right=helper(to_split+1,right)
            root.left=helper(left,to_split-1)
            return root
        return helper(0,len(inorder)-1)


#Problem 2: Sum Root to Leaf Numbers
#time complexity: O(n)
#space complexity: O(h), h height of the tree
#did it work on leetcode:yes
'''
brute force: Traverse each branch , by starting from the root each time
'''

'''
Main idea : As it traverses the tree, preorder,Keep the present string in the local memory (call stack) , when the branch is terminated,add the string to the total sum.
'''

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        res=0
        def helper(root,str_number):
            nonlocal res
            #base case
            #if empty root, we dont'care about it
            if not root:
                return

            str_number+=str(root.val)
            #we can't have the base case just with if not root,
            #because it will be counted two times (will check left, then right, null two times)
            # if it's the last element in the branch
            if not root.left and not root.right:
                res+=int(str_number)
                return

            #recursion
            helper(root.left,str_number)
            helper(root.right,str_number)


        helper(root,"")
        return res
