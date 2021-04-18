 /**
     * @author cuilihuan
     * @data 2021/3/20 20:51
     */
    public  class Problem_0572_另一个树的子树 {


        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(2);
            root.left.left.left = new TreeNode(0);


            TreeNode s = new TreeNode(4);
            s.left = new TreeNode(1);
            s.right = new TreeNode(2);
            System.out.println(new Problem_0572_另一个树的子树().isSubtree(root, s));
        }
        static class TreeNode {
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

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (t == null)
                return true;

            if(s == null)
                return false;

            boolean flag = isSame(s, t);

            if (flag)
                return true;

            return isSubtree(s.left, t) || isSubtree(s.right, t);

        }

        private boolean isSame(TreeNode s, TreeNode t) {
            if (t == null && s== null)
                return true;
            if (s == null)
                return false;
            if(t== null)
                return false;
            if (s.val == t.val) {
                return isSame(s.left, t.left) && isSame(s.right, t.right);
            }
            return false;
        }
    }