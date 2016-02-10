/*
mirror tree
*/
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public TreeNode MirrorTree(TreeNode root){
    //return a mirror tree of the input;
    if(root==null)return root;
    if(root.left==null && root.right==null) return root;
    TreeNode left = MirrorTree(root.left);
    TreeNode right = MirrorTree(root.right);
    root.left=right;
    root.right=left;
    return root;
}