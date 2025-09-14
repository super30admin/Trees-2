# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
(Own Note: Check problem 105. Construct Binary Tree from Preorder and Inorder Traversal
Caveat: Build right sub-tree first and then left-subtree here, as post-order is
left->right->root and we start root_idx from end in order to catch roots in postOrder)

Pointers/Variables:
    - root_node_idx : Global, iterates over the post-order list
        - Catches the root node to be constructed
    - root_idx_in_inorder: Local, not parameter of recursion
        - to identify the length of right sub-tree with the current root node 
          and subsequently left sub-tree.
        - We use the inOrder_Map to find the index of curr_root_node in inOrder List
    - start_inOrder: Local, parameter of recursion. 
        - determines start of inOrder list for the sub-problem.
            - For left-subtree: retains value of root
            - For right-subtree: root_idx_in_inorder+1
    - end_inOrder: Local, parameter of recursion. 
        - determines end of inOrder list for the sub-problem.
            - For left-subtree: root_idx_in_inorder-1
            - For right-subtree: retains value of root
            
Cases at each root_node :
    - Left sub-tree:
        - New InOrder: [start_inOrder, root_idx_in_inorder-1]
    - Right sub-tree:
        - New InOrder: [root_idx_in_inorder+1, Eend_inOrdernd]
Time Complexity: O(N)
Space Complexity: O(H), H = height of tree, worst O(N), best O(log N) 
'''
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inOrderMap = {} # Node value: idx in inorder
        for i in range(len(inorder)):
            inOrderMap[inorder[i]] = i
        
        self.root_node_idx = len(postorder)-1 # this pointer iterates over the postorder list
        
        return self.helper(0,len(inorder)-1,postorder,inOrderMap) # start_inOrder, end_inOrder, postorder_list, inOrderMap 
        
    # Return type: TreeNode
    def helper(self,start_inOrder, end_inOrder, postorder_list, inOrderMap):
        # base
        if start_inOrder>end_inOrder: # hit the leaf node
            return None

        # logic
        # Make a new node with the curr root node
        curr_root_node = TreeNode(val = postorder_list[self.root_node_idx])
        root_idx_in_inorder = inOrderMap[curr_root_node.val] # this determines left/right subtree in inorder_list
        self.root_node_idx-=1 # move to the next root node from postorder
    
        # build the sub-tree on right side of curr root node
        curr_root_node.right = self.helper(root_idx_in_inorder+1,end_inOrder,postorder_list, inOrderMap) # for right subtree, nodes from the curr_root_node upto end in InOrder list
        
        # build the sub-tree on left side of curr root node
        curr_root_node.left = self.helper(start_inOrder,root_idx_in_inorder-1,postorder_list, inOrderMap) # for left subtree, nodes from start upto the curr_root_node in InOrder list
        
        # return curr_root_node, left and right subtree built
        return curr_root_node        