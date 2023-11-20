package algos

import (
	"fmt"
)

func (g *UndirectedGraph[T]) DFS(node T) {
	fmt.Println("================================")
	fmt.Println("DFS:")

	visited := make(map[T]bool)
	g.dfs(visited, node)

	for src := range g.graph {
		if !visited[src] {
			g.dfs(visited, src)
		}
	}

	fmt.Println("================================")
}

func (g *UndirectedGraph[T]) dfs(visited map[T]bool, srcNode T) {
	visited[srcNode] = true
	for destNode := range g.graph[srcNode] {
		if !visited[destNode] {
			fmt.Printf("%v -> %v\n", srcNode, destNode)
			g.dfs(visited, destNode)
		}
	}
}
