package br.com.dbarreto.challenge.misc;

import br.com.dbarreto.challenge.misc.util.Node;

/**
 * A path in a binary tree is a sequence of nodes where each
 * pair of adjacent nodes in the sequence has an edge connecting them. 
 * A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(Node root) {
		Holder holder = new Holder();
		explore(root, holder);
		return holder.max;
	}
	
	private int explore(Node root, Holder holder) {
		if (root == null) {
			return 0;
		}
		
		int left = Math.max(explore(root.left, holder), 0);
		int right = Math.max(explore(root.right, holder), 0);
		int curr = root.val;
		
		holder.max = Math.max(holder.max, left + right + curr);
		return Math.max(left, right) + curr;
	}
}

class Holder {
	int max = Integer.MIN_VALUE;
}