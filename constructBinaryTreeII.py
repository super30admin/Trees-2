# TC: O(n)
# SC: O(n)

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hmap={}
        for i,j in enumerate(inorder):
            hmap[j]=i
        
        n=len(inorder)
        idx=n-1
        start=0
        end=n-1
        def helper(postorder, inorder, hmap, start, end):
            #base condition
            if start>end:
                return None
            
            #logic
            nonlocal idx
            root_val=postorder[idx]
            idx-=1
            root=TreeNode(root_val)

            ridx=hmap[root_val]

            #right
            root.right=helper(postorder, inorder, hmap, ridx+1, end)
            #left
            root.left=helper(postorder, inorder, hmap, start, ridx-1)

            return root
            
        return helper(postorder, inorder, hmap, start, end)