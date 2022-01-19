#Time Complexity O(N)
#Space Complexity O(H)-height of tree
class Solution:
    def sumNumbers(self, root: TreeNode):
        root_to_leaf = 0
        st = [(root, 0) ]
        
        while st:
            root, curr_number = st.pop()
            if root is not None:
                curr_number = curr_number * 10 + root.val
                if root.left is None and root.right is None:
                    root_to_leaf += curr_number
                else:
                    st.append((root.right, curr_number))
                    st.append((root.left, curr_number))
                        
        return root_to_leaf
