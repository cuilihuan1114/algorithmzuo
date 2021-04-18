import java.util.LinkedList;

/**
     * @author cuilihuan
     * @data 2021/3/20 16:58
     */
    public  class Problem_0513_找树左下角的值 {

        public static void main(String[] args) {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(6);
            root.right.left.right = new TreeNode(7);
            System.out.println(new Problem_0513_找树左下角的值().findBottomLeftValue(root));
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


        public int findBottomLeftValue(TreeNode root) {
            if(root == null)
                return 0;
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            int leftNum = root.val;
            int count = 1;
            int curLevel = 0;
            int pre = count;
            while (!stack.isEmpty()){
                TreeNode cur = stack.pollFirst();

                if(cur.left != null){
                    stack.addLast(cur.left);
                    curLevel++;
                }
                if(cur.right != null){
                    stack.addLast(cur.right);
                    curLevel++;
                }
                if(count == pre)
                    leftNum = cur.val;

                count--;
                if(count == 0){
                    pre = curLevel;
                    count = curLevel;
                    curLevel = 0;
                }
            }
            return leftNum;
        }
    }