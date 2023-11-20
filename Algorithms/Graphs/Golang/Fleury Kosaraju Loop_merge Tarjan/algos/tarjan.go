package algos

import "fmt"

func (g *DirectedGraph[T]) Tarjan() {
	fmt.Println("================================")
	fmt.Println("Tarjan:")

	visited := make(map[T]bool, len(g.graph))
	stack := make([]T, 0, len(g.graph))

	for srcNode := range g.graph {
		if !visited[srcNode] {
			g.dfsInverted(visited, srcNode, &stack)
		}
	}

	fmt.Println(stack)
	fmt.Println("================================")
}

func (g *DirectedGraph[T]) dfsInverted(visited map[T]bool, srcNode T, stack *[]T) {
	visited[srcNode] = true
	for destNode := range g.graph[srcNode] {
		if !visited[destNode] {
			g.dfsInverted(visited, destNode, stack)
		}
	}

	*stack = append(*stack, srcNode)
}
