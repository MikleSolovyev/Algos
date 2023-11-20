package algos

import (
	"fmt"
	"math"
)

func (g *UndirectedGraph[T]) FloydWarshall() {
	fmt.Println("================================")
	fmt.Println("FloydWarshall:")

	var i float64 = 0
	indicesOfNodes := make(map[float64]T)
	for srcNode := range g.graph {
		indicesOfNodes[i] = srcNode
		i++
	}

	V := len(g.graph)

	D := make([][]float64, V)
	for x := 0; x < V; x++ {
		D[x] = make([]float64, V)
		for y := 0; y < V; y++ {
			if x == y {
				D[x][y] = 0
			} else {
				srcNode := indicesOfNodes[float64(x)]
				destNode := indicesOfNodes[float64(y)]
				if weight, ok := g.graph[srcNode][destNode]; ok {
					D[x][y] = float64(*weight)
				} else {
					D[x][y] = math.Inf(1)
				}
			}
		}
	}

	for k := 0; k < V; k++ {
		for x := 0; x < V; x++ {
			for y := 0; y < V; y++ {
				if D[x][y] > D[x][k]+D[k][y] {
					D[x][y] = D[x][k] + D[k][y]
				}
			}
		}
	}

	for i, line := range D {
		fmt.Println(indicesOfNodes[float64(i)], line)
	}
	fmt.Println("================================")
}
