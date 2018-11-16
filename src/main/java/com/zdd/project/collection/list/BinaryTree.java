package com.zdd.project.collection.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author <a href="zdd109067@alibaba-inc.com">zhoudongdong</a>
 * @version create on 2017/9/6 下午10:43
 */
public class BinaryTree {
  static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
      this.value = value;
    }
  }

  static TreeNode root;

  public BinaryTree(int[] array) {
    root = makeBinaryTreeByArray(array, 1);
  }

  public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
    if (index < array.length) {
      int value = array[index];
      if (value != 0) {
        TreeNode t = new TreeNode(value);
        array[index] = 0;
        t.left = makeBinaryTreeByArray(array, index * 2);
        t.right = makeBinaryTreeByArray(array, index * 2 + 1);
        return t;
      }
    }
    return null;
  }


  public static void preVisit(TreeNode p) {
    if (p != null) {
      System.out.println(p.value);
      preVisit(p.left);
      preVisit(p.right);
    }
  }

  public List<String> depthOrderTraversal() {
    if (root == null) {
      System.out.println("empty tree");
      return new ArrayList<>();
    }

    StringBuilder stringBuilder = new StringBuilder();
    List<String> paths = new ArrayList<>();

    ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    stack.push(root);
    while (stack.isEmpty() == false) {
      TreeNode node = stack.pop();
      //System.out.print(node.value + "    ");
      stringBuilder.append(node.value).append(',');

      if (node.right != null) {
        stack.push(node.right);
      } else {
        String path = stringBuilder.toString();
        paths.add(path.substring(0, path.length() - 1));

        stringBuilder = new StringBuilder();
      }

      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return paths;
  }

  //public void levelOrderTraversal() {
  //  if (root == null) {
  //    System.out.println("empty tree");
  //    return;
  //  }
  //  ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
  //  queue.add(root);
  //  while (queue.isEmpty() == false) {
  //    TreeNode node = queue.remove();
  //    System.out.print(node.value + "    ");
  //    if (node.left != null) {
  //      queue.add(node.left);
  //    }
  //    if (node.right != null) {
  //      queue.add(node.right);
  //    }
  //  }
  //  System.out.print("\n");
  //}

  public static void main(String[] args) {
    int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
    //int[] arr={0,1,2,3,4,5,6,7};
    BinaryTree tree = new BinaryTree(arr);
    //List<String> paths = tree.depthOrderTraversal();
    //System.out.println(paths);
    //tree.levelOrderTraversal();

    preVisit(root);
  }
}
