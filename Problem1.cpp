//
// Created by shazm on 7/23/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution{
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()==0){
            return NULL;
        }
        TreeNode* Node = new TreeNode(postorder.back());

        recurr(inorder,postorder,Node);

        return Node;
    }

    TreeNode* recurr(vector<int>& inorder, vector<int>& postorder, TreeNode* root){
        if(inorder.size()==1){
            return root;
        }
//in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
//post[] = {8, 4, 5, 2, 6, 7, 3, 1}
        vector<int>::iterator it = find(inorder.begin(),inorder.end(),root->val);
        vector<int> leftInorder{inorder.begin(),it}; //9
        vector<int> rightInorder{it+1,inorder.end()}; //15,20,7
        int maxLeft = INT_MIN; int maxRight = INT_MIN; int maxSizePost = INT_MIN;  int maxSizePostL = INT_MIN; int post;
        for(int x = 0; x<leftInorder.size(); x++){
            post = find(postorder.begin(),postorder.end(),leftInorder[x])-postorder.begin();
            if(post > maxSizePostL){
                maxSizePostL = post;
                maxLeft = x;
            }
        }
        for(int x = 0; x<rightInorder.size(); x++){
            post = find(postorder.begin(),postorder.end(),rightInorder[x])-postorder.begin();
            if(post > maxSizePost){
                maxSizePost = post;
                maxRight = x;
            }
        }

        TreeNode* leftNode;
        TreeNode* rightNode;
        if(leftInorder.size()==0){
            leftNode = NULL;
        }else{
            leftNode = new TreeNode(leftInorder[maxLeft]);
            root->left = recurr(leftInorder,postorder,leftNode);
        }

        if(rightInorder.size()==0){
            rightNode = NULL;
        }else{
            rightNode = new TreeNode(rightInorder[maxRight]);
            root->right = recurr(rightInorder,postorder,rightNode);
        }

        return root;
    }
};

int main(){
    Solution s;
    vector<int> inorder{4, 8, 2, 5, 1, 6, 3, 7};
    vector<int> postorder{8, 4, 5, 2, 6, 7, 3, 1};
    TreeNode* Node = s.buildTree(inorder,postorder);
    cout<<Node->left->val<<endl;
    return 0;
}