Time Complexity-O(n) 
Space Complexity-O(n)
Did the code run on Leetcode? Yes
Problems faced while solving-I did find it difficult to figure out the solution which will take a parameter as 'post' which keeps decrementing
        each time and pass it on to next recursive call because this is necessary for implementing DFS in this question.
        Now I got to know that if i need the previously calculated recursive value (i.e After traversing all the nodes on the left or right)
        then I will have to pass it by reference. If i need the previously calculated value in the level above then we have to pass the parameter by 'value'.
        This intuition will help us in solving many DFS and BFS questions. 
        Thank You Jaspinder :) 


class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int,int>m;
        int post=postorder.size()-1;
        for(int i=0;i<inorder.size();i++)
        {
            m[inorder[i]]=i;
        }
        return building(inorder,post,0,inorder.size()-1,postorder,m);
    }
    TreeNode* building(vector<int>& inorder,int &post,int start,int end,vector<int>& postorder,unordered_map<int,int>&m)
    {
        if(start>end)
        {
            return NULL;
        }
        int current=postorder[post];
        post--;
        TreeNode *a=new TreeNode(current);
        if(start==end)
        {
            return a;
        }
        int x=m[current];
        a->right=building(inorder,post,x+1,end,postorder,m);
        a->left=building(inorder,post,start,x-1,postorder,m);
        return a;
    }
};