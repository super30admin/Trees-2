#time complexity: O(n) n- no of nodes
#postordering process takes O(n), inorder index as we are using hash map it takes O(1) on an average. so overall O(n)
#space complexity:O(n) n- number of nodes, Cresating hashmap O(n), creating n-tree nodes - .O(n). overall O(n)

#post order is left right root
#inorder is left root right
#so the last element of the postorder array is the root.
#we are just constructing the binary tree.

from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self,  inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #lets use hashmap for storing the indices of the inorder array 
        #otherwise we need to travel the whole array for each recursive call which may take O(n^2) in worst case
        #to avoid it we are using the hash map
        #by doing this it will take  O(1) lookup to find the root's position

        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        #lets build a helper function that constructs the tree
        #postorder_left, postorder_right --> current segment of the postorder array
        #inorder_left, inorder_right --> current sgmant of the inorder array

        def build(inorder_left: int, inorder_right: int, postorder_left: int, postorder_right: int) -> Optional[TreeNode]:

            #base case: If the range is invalid (empty or reversed) 
            # this is the base condition for indices.
            if  inorder_left > inorder_right or postorder_left > postorder_right:
                return None #this applies for every iteration
            
            #The last element of the postorder array is the root of the current subtree
            root_val = postorder[postorder_right]
            #construct a tree with that root
            root = TreeNode(root_val)

            #now we know what value is the root from postorder array . we need to find the index corresponding to that value in inorder array
            inorder_root_index = inorder_map[root_val]

            #calculate the number of elements in the left subtree from the inorder array 
            #that is the number of elements left side of root.val in the inorder array

            left_subtree_size =  inorder_root_index - inorder_left
            #now lets build left and right subtree recursively

            #left subtree 
            #for postorder; the left subtree elements will be from start to leftsubtree no of elements
            #For inorder: It is the segment from inorder_left to inorder_root_index(excluding it)

            
            
            #building left subtree
            root.left = build(inorder_left, inorder_root_index -1, postorder_left, postorder_left+left_subtree_size - 1)

            #right subtree 
            #for postorder: The right subtree elements will be after left_subtree elements to the end 
            #For Inorder: It is the segment from inorder_root_index + 1 to inorder end means right sidde after root index 

            #build right subtree
            root.right = build(inorder_root_index+1, inorder_right, postorder_left + left_subtree_size , postorder_right - 1)



            return root
        
        #now lets take the initial call to the recursive function
        #initially full inorder amnd postorder in initialized
        n = len(inorder)
        return build(0, n-1, 0, n-1)



        
