package algos

import (
	"fmt"
	"sort"
)

func (g *UndirectedGraph[T]) Kruskal() {
	fmt.Println("================================")
	fmt.Println("Kruskal:")

	D := make(map[T]T)
	var E, result [][]T

	for srcNode := range g.graph {
		D[srcNode] = srcNode
		for destNode := range g.graph[srcNode] {
			E = append(E, []T{srcNode, destNode})
		}
	}

	sort.Slice(E, func(i, j int) bool {
		return *g.graph[E[i][0]][E[i][1]] < *g.graph[E[j][0]][E[j][1]]
	})

	for _, edge := range E {
		if D[edge[0]] != D[edge[1]] {
			result = append(result, []T{edge[0], edge[1]})
			temp := D[edge[0]]
			for node := range D {
				if D[node] == temp {
					D[node] = D[edge[1]]
				}
			}
		}
	}

	for _, edge := range result {
		fmt.Printf("%v -> %v\n", edge[0], edge[1])
	}
	fmt.Println("================================")
}
