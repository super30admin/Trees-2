#https://leetcode.com/problems/sum-root-to-leaf-numbers/
#iterative preorder traversal
#time: O(n)
#space: O(h)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        st =[]
        numStack =[]
        currNum = 0
        result =0

        while root!= None or st != []:
            #print("inside while")
            while root !=None:
                
                currNum = currNum*10 + root.val
                #print(currNum)
                st.append(root)
                numStack.append(currNum)
                root=root.left
            #print(st)
            root = st.pop()
            #st.pop()
            currNum=numStack.pop()  
            #print("root after pop", root)      
           # print("nu after pop", currNum)
            if root.left == None and root.right == None:
                result += currNum
               #print("result", result)
            
            #print(st)
           
            root = root.right 
            #print(root)
        
        return result