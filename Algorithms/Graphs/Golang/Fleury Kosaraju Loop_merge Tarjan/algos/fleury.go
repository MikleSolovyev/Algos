package algos

import (
	"fmt"
	"os"
)

func (g *UndirectedGraph[T]) Fleury(startNode T) {
	fmt.Println("================================")
	fmt.Println("Fleury:")

	srcNode := startNode
	for len(g.graph) > 0 {
		var destNode T
		for destNode = range g.graph[srcNode] {
			if !g.isBridge(srcNode, destNode) {
				break
			}
		}

		delete(g.graph[srcNode], destNode)
		if len(g.graph[srcNode]) == 0 {
			delete(g.graph, srcNode)
		}
		delete(g.graph[destNode], srcNode)
		if len(g.graph[destNode]) == 0 {
			delete(g.graph, destNode)
		}

		if srcNode == destNode {
			os.Exit(1)
		}
		fmt.Printf("%v -> %v\n", srcNode, destNode)
		srcNode = destNode
	}

	fmt.Println("================================")
}

func (g *UndirectedGraph[T]) isBridge(srcNode T, destNode T) bool {
	visited := make(map[T]bool)
	result := g.dfs(visited, srcNode, srcNode, destNode)

	return !result
}

func (g *UndirectedGraph[T]) dfs(visited map[T]bool, srcNode T, targetSrc T, targetDest T) bool {
	visited[srcNode] = true
	for destNode := range g.graph[srcNode] {
		if srcNode == targetSrc && destNode == targetDest || srcNode == targetDest && destNode == targetSrc {
			continue
		}

		if destNode == targetDest {
			return true
		}

		if !visited[destNode] {
			return g.dfs(visited, destNode, targetSrc, targetDest)
		}
	}

	return false
}
