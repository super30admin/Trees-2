class P{
    TreeNode treeNode;
    int pn;
    P(TreeNode treeNode, int pn){
        this.pn=pn;
        this.treeNode=treeNode;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<P> s = new Stack<>();
        s.push(new P(root,0));
        int ps =0;
        while(!s.isEmpty()){
            P p = s.pop();
            TreeNode n = p.treeNode;
            int pn = p.pn;
            pn = pn*10 + n.val;
            if(n.left==null && n.right==null){
                ps += pn;
            }else{
                if(n.right!=null){
                    s.push(new P(n.right,pn));
                }
                if(n.left!=null){
                    s.push(new P(n.left,pn));
                }
            }
        }
    return ps;}
}
//tc=O(n)
  //sc=O(n)
