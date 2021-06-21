# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    """
    Iterative solution
    """
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None:
            return 0
        RL_value=0
        curr_sum=0
        st=[] #will have a pair of node and current sum at that node
        #inorder traversal
        while(root!=None or len(st)!=0):
            while(root!=None):
                curr_sum=(curr_sum*10)+ root.val
                st.append((root,curr_sum))
                root=root.left

            pair=st.pop() #popping of root and curr sum at that root
            root=pair[0]
            curr_sum=pair[1]
            if root.left==None and root.right==None:
                RL_value+=curr_sum
            root=root.right

        return RL_value
