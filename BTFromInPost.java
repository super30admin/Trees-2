package trees;

public class BTFromInPost {

	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        int N= inorder.length;
	        if(N==0) return null;
	        return buildTree(inorder,postorder,0,N-1,0,N-1);
	    }
	    public TreeNode buildTree(int[] i,int[] p,int iStart,int iEnd,int pStart,int pEnd){
//	         creating node with last element of postorder(firstNode)
	        TreeNode root= new TreeNode(p[pEnd]);
	        int rootIndex = getRootIndex(i,p[pEnd],iStart,iEnd);
	        int LSS=rootIndex-iStart;
	        int RSS=iEnd-rootIndex;
	        if(LSS==0) root.left=null;
	        else if(LSS==1) root.left= new TreeNode(i[iStart]);
	        else root.left=buildTree(i,p,iStart,rootIndex-1,pStart,pStart+LSS-1);
	         if(RSS==0) root.right=null;
	        else if(RSS==1) root.right= new TreeNode(i[iEnd]);
	        else root.right=buildTree(i,p,rootIndex+1,iEnd,pStart+LSS,pEnd-1);
	        return root;
	    }
//	     method to get root index from inorder array.
	    public int getRootIndex(int[] i, int rootval, int iStart, int iEnd) {
	    for (int j = iStart; j <= iEnd; j++) {
	        if (i[j] == rootval) return j;
	    }
	    return -1;
	}
}
