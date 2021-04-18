 /**
     * @author cuilihuan
     * @data 2021/4/8 14:59
     */
    public  class Problem_0654_最大二叉树 {

        class TreeNode {
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


        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0)
                return null;

            return process(nums, 0, nums.length - 1);
        }

        private TreeNode process(int[] nums, int left, int right) {
            if(left > right)
                return null;
            int sum = nums[left];
            int pos = left;
            for (int i = left + 1; i <= right; i++) {
                if(nums[i] > sum){
                    sum = nums[i];
                    pos = i;
                }
            }

            TreeNode node = new TreeNode(sum);
            node.left = process(nums, left, pos - 1);
            node.right = process(nums, pos + 1, right);

            return node;
        }
    }