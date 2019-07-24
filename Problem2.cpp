//
// Created by shazm on 7/23/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

//   4
//  / \
//
// 9   0
//
// / \
//
// 5 1 Output: 1026 Explanation:
//
//The root-to-leaf path 4->9->5 represents the number 495.
//
//The root-to-leaf path 4->9->1 represents the number 491.
//
//The root-to-leaf path 4->0 represents the number 40.
//
//Therefore, sum = 495 + 491 + 40 = 1026.
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        if(root==NULL){return sum;}
        for(string x : recurr(root)){
            sum += stoi(x);
        }
        return sum;
    }
private:
    vector<string> recurr(TreeNode* Node){
        vector<string> vec;
        if(Node == NULL){
            vec.push_back(to_string(-1)); return vec;
        }
        if(Node->left == NULL && Node->right== NULL){
            vec.push_back(to_string(Node->val));
            return vec;
        }

        string Left = to_string(Node->val);
        for(string x : recurr(Node->left)){
            if(x!="-1"){vec.push_back(Left+x);}
        }

        string Right = to_string(Node->val);
        for(string y : recurr(Node->right)){
            if(y!="-1"){vec.push_back(Right+y);}
        }

        return vec;

    }
};
int main(){
    Solution s;
    TreeNode* Node = new TreeNode(4);
    TreeNode* l = new TreeNode(9);
    TreeNode* r = new TreeNode(0); Node->left = l; Node->right = r;
    TreeNode* ll = new TreeNode(5);
    TreeNode* lr = new TreeNode(1); l->left = ll; l->right = lr;

    cout<<s.prob(Node)<<endl;

    return 0;
}