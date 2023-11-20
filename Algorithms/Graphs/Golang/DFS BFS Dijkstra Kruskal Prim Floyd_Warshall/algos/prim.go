package algos

import (
	"fmt"
	"math"
)

func (g *UndirectedGraph[T]) Prim() {
	fmt.Println("================================")
	fmt.Println("Prim:")

	parent := make(map[T]*T)
	D := make(map[T]float64)
	visited := make(map[T]bool)

	for srcNode := range g.graph {
		D[srcNode] = math.Inf(1)
		parent[srcNode] = nil
	}

	unvisitedAmount := len(g.graph)
	for unvisitedAmount > 0 {
		minNode := peekKeyFromMap(D)
		if unvisitedAmount == len(g.graph) {
			D[minNode] = 0
		}

		for srcNode := range D {
			if visited[minNode] && !visited[srcNode] {
				minNode = srcNode
			}

			if !visited[srcNode] && D[srcNode] < D[minNode] {
				minNode = srcNode
			}
		}

		visited[minNode] = true
		unvisitedAmount--

		for destNode := range g.graph[minNode] {
			if float64(*g.graph[destNode][minNode]) < D[destNode] && !visited[destNode] {
				D[destNode] = float64(*g.graph[destNode][minNode])
				parent[destNode] = &minNode
			}
		}
	}

	for srcNode := range g.graph {
		if parent[srcNode] != nil {
			fmt.Printf("%v -> %v\n", srcNode, *parent[srcNode])
		}
	}
	fmt.Println("================================")
}

func peekKeyFromMap[K comparable, V comparable](m map[K]V) K {
	var key K

	for key = range m {
		break
	}

	return key
}
