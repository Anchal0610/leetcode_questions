/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        solve(root);
        return maxsum;        
    }
    public int solve(TreeNode root){
        if(root ==  null){
            return 0;
        }
        int l = solve(root.left);
        int r = solve(root.right);
        int neeche_hi_ans_milgaya = l + r + root.val;
        int koi_ek_achha = Math.max(l,r) + root.val;
        int only_root_achha = root.val;
        maxsum = Math.max(maxsum , Math.max(neeche_hi_ans_milgaya , Math.max(koi_ek_achha , only_root_achha)));

        return Math.max(koi_ek_achha , only_root_achha);
    }
}