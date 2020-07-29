class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        Hashmap=collections.defaultdict(int)
        index=len(postorder)-1
        def helper(self,inorder,postorder,start,end):
            nonlocal index
            if index<0 or start>end:
                return None
            
            rootindex=Hashmap.get(postorder[index])
            root=TreeNode(postorder[index])
            
            index-=1
            root.right=helper(self,inorder,postorder,rootindex+1,end)
            root.left=helper(self,inorder,postorder,start,rootindex-1)
            return root
        if len(postorder)==0 or len(inorder)==0:
            return None
        for i in range(len(inorder)):
            Hashmap[inorder[i]]=i
        return helper(self,inorder,postorder,0,len(inorder)-1)
#Time-Complexity: O(N)
#Space-Complexity: O(N)