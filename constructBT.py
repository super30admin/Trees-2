class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):

        self.postorder = []
        self.inorder = []
        self.indices = {}
        self.index = 0

    def __buildTree(self, inS, inE):
        if (inS > inE) or self.index < 0:
            return None

        inIdx = self.indices[self.postorder[self.index]]
        currentRoot = TreeNode(self.postorder[self.index])

        self.index -= 1                                    
        currentRoot.right = self.__buildTree(inIdx + 1, inE)    
        currentRoot.left = self.__buildTree(inS, inIdx - 1)     

        return currentRoot                                  

    def buildTree(self, inorder, postorder):
        if (postorder == None or len(postorder) == 0):
            return None

        self.postorder = postorder
        self.inorder = inorder
        self.index = len(postorder) - 1

        for i in range(len(self.inorder)):
            self.indices[self.inorder[i]] = i

        return self.__buildTree(0, len(self.inorder) - 1)


class BuildTreeInPost_Stack(object):
    def buildTree(self, inorder, postorder):
    
        if (postorder == None or len(postorder) == 0):
            return None

        indices = {}
        for i in range(len(inorder)):
            indices[inorder[i]] = i
        rootNode = TreeNode(postorder[-1])
        stack = deque([[rootNode, 0, 0, len(postorder) - 1]])
        index = len(postorder) - 2
        while (len(stack) > 0):
            top = stack[-1]           
            topNode = top[0]
            topCount = top[1]
            topMin = top[2]
            topMax = top[3]

            if topCount == 0:           
                stack[-1][1] += 1
                if (index >= 0 and index < len(postorder)):  
                    if (topMax < indices[topNode.val] + 1):   
                        continue
                    topNode.right = TreeNode(postorder[index])  
                    stack.append([topNode.right, 0, indices[topNode.val] + 1, topMax])
                index -= 1                                  

            elif topCount == 1:           
                stack[-1][1] += 1
                if (index >= 0 and index < len(postorder)):   
                    if (topMin > indices[topNode.val] - 1):    
                        continue
                    topNode.left = TreeNode(postorder[index])   
                    stack.append([topNode.left, 0, topMin, indices[topNode.val] - 1])
                index -= 1                                     

            elif topCount == 2:    
                stack.pop()

        return rootNode
