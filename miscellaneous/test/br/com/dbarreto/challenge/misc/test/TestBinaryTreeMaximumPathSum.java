package br.com.dbarreto.challenge.misc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.BinaryTreeMaximumPathSum;
import br.com.dbarreto.challenge.misc.util.Node;

public class TestBinaryTreeMaximumPathSum {

	private BinaryTreeMaximumPathSum problem = new BinaryTreeMaximumPathSum();
	
	@Test
	public void testCase001() {
		
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(-5);
		root.left.right = new Node(1);
		root.right = new Node(-10);
		root.right.left = new Node(50);
		root.right.right = new Node(20);
		
		assertEquals(60, problem.maxPathSum(root));
	}
}
