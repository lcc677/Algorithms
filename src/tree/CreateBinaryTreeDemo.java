package tree;

import java.util.*;

public class CreateBinaryTreeDemo {
    /**
     * 层序遍历
     * @param rootNode 根节点
     * @return 层序遍历的数组
     */
    public ArrayList<ArrayList<Integer>> printLevel(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        if (rootNode != null) queue.add(rootNode);

        while (!queue.isEmpty()) {
            ArrayList<Integer> subal = new ArrayList<>();
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {
                TreeNode currentNode = queue.poll();
                subal.add(currentNode.val);
//                al.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            al.add(subal);
        }

        System.out.println(Arrays.deepToString(al.toArray()));


        return al;

    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);

        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }


    public List<Integer> preorderTraversalStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        stack.push(root);
        while (!stack.empty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            if(current.right!=null) stack.push(current.right);
            if (current.left!=null) stack.push(current.left);
        }
        return result;


    }

    /**
     * 中序和后序创建二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreePostorder(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        ArrayList<Integer> leftInorderTreeNodeVal = new ArrayList<>();
        ArrayList<Integer> rightInorderTreeNodeVal = new ArrayList<>();
        boolean revert = false;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                revert = true;
                continue;
            }
            if (!revert) {
                leftInorderTreeNodeVal.add(inorder[i]);
            } else {
                rightInorderTreeNodeVal.add(inorder[i]);
            }

        }
        ArrayList<Integer> leftPostOrderTreeNodeVal = new ArrayList<>();
        ArrayList<Integer> rightPostOrderTreeNodeVal = new ArrayList<>();
        for (int i = 0; i < postorder.length - 1; i++) {
            if (leftPostOrderTreeNodeVal.size() != leftInorderTreeNodeVal.size()) {
                leftPostOrderTreeNodeVal.add(postorder[i]);
            } else {
                rightPostOrderTreeNodeVal.add(postorder[i]);
            }
        }

        TreeNode leftNode = buildTreePostorder(leftInorderTreeNodeVal.stream().mapToInt(i -> i).toArray(), leftPostOrderTreeNodeVal.stream().mapToInt(i -> i).toArray());
        TreeNode rightNode = buildTreePostorder(rightInorderTreeNodeVal.stream().mapToInt(i -> i).toArray(), rightPostOrderTreeNodeVal.stream().mapToInt(i -> i).toArray());

        TreeNode rootNode = new TreeNode(rootVal, leftNode, rightNode);
        return rootNode;

    }

    /**
     * 前序创建二叉树
     *
     * @param inorder
     * @param preorder
     * @return
     */
    public TreeNode buildTreePreorder(int[] inorder, int[] preorder) {
        return buildTreePreorderHelper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode buildTreePreorderHelper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (inorder[i] != root.val) i++;

        TreeNode leftNode = buildTreePreorderHelper(inorder, preorder, inStart, i - 1, preStart + 1, preStart + 1 + i - inStart);
        TreeNode rightNode = buildTreePreorderHelper(inorder, preorder, i + 1, inEnd, preStart + 1 + i - inStart, preEnd);

        root.left = leftNode;
        root.right = rightNode;
        return root;

    }

    public static void main(String[] args) {
        CreateBinaryTreeDemo cbt = new CreateBinaryTreeDemo();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

//        int[] inorder = {9,3,15,};
//        int[] postorder = {9,15,3};
        TreeNode rootNode = cbt.buildTreePostorder(inorder, postorder);
        cbt.printLevel(rootNode);

        // 先序+中序 创建二叉树

        int[] inorder2 = {5, 8, 9, 2, 3, 15, 20, 7};
        int[] preorder = {3, 9, 8, 5, 2, 20, 15, 7};
        TreeNode preRoot = cbt.buildTreePreorder(inorder2, preorder);
        cbt.printLevel(preRoot);

        System.out.println("前序遍历：" + cbt.preorderTraversal(preRoot));
        System.out.println("前序遍历(通过栈)：" + cbt.preorderTraversalStack(preRoot));
        System.out.println("后续遍历" + cbt.postorderTraversal(preRoot));
        System.out.println("中序遍历" + cbt.inorderTraversal(preRoot));

    }
}
