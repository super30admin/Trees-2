'''
1. Since it is a postorder traversal, the last element in the postorder array will be the root of the tree. Maintain an index pointer for the postorder array.
2. Initialize a root node with the last element in the postorder array. Find the index of the root in the inorder array. The nodes to the left of the root in the inorder array will form the left subtree and the nodes to the right of the root in the inorder array will form the right subtree.
3. Call the function recursively with the left and right modified according to above logic.

TC: O(N)
SC: O(N+H) where N is the number of nodes in the tree and H is the height of the tree as we are using hashmap and recursion stack.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if inorder == None:
            return None
        
        inorder_index = {}
        for index,node in enumerate(inorder):
            inorder_index[node] = index
        
        postorderIndex = len(postorder)-1
    
        def arraytoTree(left,right) -> Optional[TreeNode]:
            nonlocal postorderIndex
            if left > right:
                return None

            root_value = postorder[postorderIndex]
            postorderIndex -= 1
            root = TreeNode(root_value)
            root.right = arraytoTree(inorder_index[root_value]+1, right)            
            root.left = arraytoTree(left,inorder_index[root_value] - 1)
            return root
            
        return arraytoTree(0,len(inorder)-1)
        