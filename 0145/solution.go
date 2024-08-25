package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func postorderTraversal(root *TreeNode) []int {
	var res []int
	traverse(root, &res)
	return res
}

func traverse(node *TreeNode, post *[]int) {
	if node == nil {
		return
	}

	traverse(node.Left, post)
	traverse(node.Right, post)
	*post = append(*post, node.Val)
}
