"""
Iterative solution
TC=O(N)
SC= Stack O(Height) ie O(N)


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_iterSumnumbers:
    def sumNumbers(self, root: TreeNode) -> int:
        st=[]
        currsum=0
        result=0
        while(root or st):
            while(root):
                currsum=currsum*10+root.val
                st.append([root,currsum])
                root=root.left
            list1=st.pop()
            root=list1[0]
            currsum=list1[1]
            if(root.left is None and root.right is None):
                result+=currsum
            root=root.right
        return result
                
        