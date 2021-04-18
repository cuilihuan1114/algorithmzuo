import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
     * @author cuilihuan
     * @data 2021/3/20 20:26
     */
    public  class Problem_0515_在每个树行中找最大值 {
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

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(9);
            System.out.println(new Problem_0515_在每个树行中找最大值().largestValues(root).size());
        }


        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root == null)
                return list;
            LinkedList<TreeNode> quque = new LinkedList<>();
            quque.add(root);

            int curNum = 0;
            int count = 1;
            int max = Integer.MIN_VALUE;
            while (!quque.isEmpty()) {
                TreeNode curNode = quque.pollFirst();
                count--;
                max = Math.max(max, curNode.val);

                if(curNode.left != null){
                    quque.addLast(curNode.left);
                    curNum++;
                }
                if(curNode.right != null){
                    quque.addLast(curNode.right);
                    curNum++;
                }

                if(count == 0){
                    list.add(max);
                    max = Integer.MIN_VALUE;
                    count = curNum;
                    curNum = 0;
                }


            }

            return list;

        }
    }
