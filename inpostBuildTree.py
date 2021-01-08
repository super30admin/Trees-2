class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        '''
        Time Comlexity : O(logn)
        inorder : left root right
        postorder :  left right root
        
        1 : last elem of postorder is root
        2 : find the index of root in inorder
        3 : extract left subtree and right subtree from inorder by dividing it in 3 parts  
                    [ left subtree root right subtree]
        4 : from postorder get the post order of letf subtree and right subtree by getting its length from inorder
        5 : recall the function for bulding the left and right and left subtree
        '''
        
        if len(postorder) == 0 : return None
        root = TreeNode(postorder[-1])
        index = inorder.index(root.val)
        left_inorder = inorder[:index]
        right_inorder = inorder[index+1:]
        left_postorder = postorder[:index]
        right_postorder = postorder[index:-1]
        root.left = self.buildTree(left_inorder,left_postorder)
        root.right = self.buildTree(right_inorder,right_postorder)
        return root