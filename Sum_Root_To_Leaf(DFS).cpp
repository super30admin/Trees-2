Time Complexity-O(n)
Space Complexity-O(h)
Did the code run on Leetcode? Yes

class Solution {
public:
	int result=0;
	void dfs(TreeNode* root,int temp){
		if(not root) return;
		temp=10*tem+root->val;
		if(root->left==NULL && root->right==NULL){
			res+=tem;
			return;
		} 
        dfs(root->left,tem);
		dfs(root->right,tem);
	}
	int sumNumbers(TreeNode* root) {
		dfs(root,0);
		return res;
	}
};