package algos

import (
	"fmt"
	"math"
)

func (g *UndirectedGraph[T]) Dijkstra(node T) {
	fmt.Println("================================")
	fmt.Println("Dijkstra:")

	visited := make(map[T]bool)

	D := make(map[T]float64)
	for srcNode := range g.graph {
		D[srcNode] = math.Inf(1)
	}
	D[node] = 0

	unvisitedAmount := len(g.graph)
	for unvisitedAmount > 0 {
		minNode := node
		for srcNode := range g.graph {
			if visited[minNode] && !visited[srcNode] {
				minNode = srcNode
			}

			if !visited[srcNode] && D[srcNode] < D[minNode] {
				minNode = srcNode
			}
		}

		visited[minNode] = true
		unvisitedAmount--

		for destNode, weight := range g.graph[minNode] {
			if D[destNode] > D[minNode]+float64(*weight) {
				D[destNode] = D[minNode] + float64(*weight)
			}
		}
	}

	fmt.Println(D)
	fmt.Println("================================")
}
