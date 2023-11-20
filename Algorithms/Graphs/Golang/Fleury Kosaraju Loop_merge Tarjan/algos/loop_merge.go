package algos

import "fmt"

func (g *UndirectedGraph[T]) LoopMerge(startNode T) {
	fmt.Println("================================")
	fmt.Println("Loop merge:")

	var result []T
	g.findEulerPath(&result, startNode)

	fmt.Println(result)
	fmt.Println("================================")
}

func (g *UndirectedGraph[T]) findEulerPath(result *[]T, srcNode T) {
	for destNode := range g.graph[srcNode] {
		delete(g.graph[srcNode], destNode)
		delete(g.graph[destNode], srcNode)
		g.findEulerPath(result, destNode)
	}
	*result = append(*result, srcNode)
}
