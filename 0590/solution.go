package main

type Node struct {
	Val      int
	Children []*Node
}

func postorder(root *Node) []int {
	if root == nil {
		return []int{}
	}

	post := []int{}
	stack := []*Node{root}

	for len(stack) > 0 {
		curr := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		post = append(post, curr.Val)
		for _, node := range curr.Children {
			stack = append(stack, node)
		}
	}

	for i, j := 0, len(post)-1; i < j; i, j = i+1, j-1 {
		post[i], post[j] = post[j], post[i]
	}
	return post
}
