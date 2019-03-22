/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        int a=0,b=0;
        if(root.left!=null){
            a=maxDepth(root.left)+1;
        }
        else a++;
        if(root.right!=null){
            b=maxDepth(root.right)+1;
        }
        else b++;
        return (Math.max(a,b));
    }
}
