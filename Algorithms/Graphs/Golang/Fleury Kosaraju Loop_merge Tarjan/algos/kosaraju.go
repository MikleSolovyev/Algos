package algos

import "fmt"

func (g *DirectedGraph[T]) Kosaraju() {
	fmt.Println("================================")
	fmt.Println("Kosaraju:")

	visited := make(map[T]bool, len(g.graph))
	stack := make([]T, 0, len(g.graph))
	graphReversed := NewDirectedGraph[T]()

	for srcNode := range g.graph {
		for destNode := range g.graph[srcNode] {
			graphReversed.AddEdge(destNode, srcNode)
		}
	}

	for srcNode := range graphReversed.graph {
		if !visited[srcNode] {
			graphReversed.dfsInverted(visited, srcNode, &stack)
		}
	}

	visited = make(map[T]bool, len(g.graph))
	resultStack := make([]T, 0, len(g.graph))
	for i := len(stack) - 1; i >= 0; i-- {
		if !visited[stack[i]] {
			g.dfs(visited, stack[i], &resultStack)
		}
	}

	fmt.Println(resultStack)
	fmt.Println("================================")
}

func (g *DirectedGraph[T]) dfs(visited map[T]bool, srcNode T, stack *[]T) {
	*stack = append(*stack, srcNode)
	visited[srcNode] = true
	for destNode := range g.graph[srcNode] {
		if !visited[destNode] {
			g.dfs(visited, destNode, stack)
		}
	}
}
