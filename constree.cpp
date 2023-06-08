
//  TC:O(N)
//  SC:O(N)

// Approach recursive approach by using the post order to know the root,
// And then finding root in in order traversal array and from that getting the estimates of left and right node

class Solution {
public:
    unordered_map<int ,int> Imap;

TreeNode* Constree(vector<int>&p,vector<int>&in,int ps,int pe,int is,int ie)
{
    if(is>ie)
    return NULL;

    TreeNode* root=new TreeNode(p[pe]);
    int i=Imap[p[pe]];
    //cout<<ps<<pe<<is<<ie<<endl;
    root->left=Constree(p,in,ps,ps-is+i-1,is,i-1);
    root->right=Constree(p,in,ps-is+i,pe-1,i+1,ie);
     //cout<<ps<<pe<<is<<ie<<endl;
    return root;

}

TreeNode* buildTree(vector<int> &A, vector<int> &B) 
{
  Imap.clear();
  for(int i=0;i<A.size();i++)
  {
      Imap.insert({A[i],i});
  }

  TreeNode* root=Constree(B,A,0,B.size()-1,0,A.size()-1);  

  return root;
}
};