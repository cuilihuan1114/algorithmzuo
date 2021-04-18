
    /**
     * @author cuilihuan
     * @data 2021/4/11 9:51
     */
    public  class Problem_0701_二叉搜索树中的插入操作 {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }


        public TreeNode insertIntoBST(TreeNode root, int val) {

           if(root == null)
               return new TreeNode(val);
            process(root, val);
            return root;

        }

        private void process(TreeNode root, int val) {
            int cur = root.val;
            if(val < cur){
                TreeNode left = root.left;
                if(left == null){
                    left = new TreeNode(val);
                    root.left = left;
                }else{
                    process(left, val);
                }
            }else if(val > cur){
                TreeNode right = root.right;
                if(right == null){
                    right = new TreeNode(val);
                    root.right = right;
                }else{
                    process(right, val);
                }
            }
        }
    }