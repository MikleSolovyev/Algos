package algos

import "fmt"

func (g *UndirectedGraph[T]) BFS(node T) {
	fmt.Println("================================")
	fmt.Println("BFS:")

	visited := make(map[T]bool)
	queue := []T{node}
	visited[node] = true

	for len(queue) != 0 {
		for destNode := range g.graph[queue[0]] {
			if !visited[destNode] {
				fmt.Printf("%v -> %v\n", queue[0], destNode)

				queue = append(queue, destNode)
				visited[destNode] = true
			}
		}
		queue = queue[1:]
	}

	fmt.Println("================================")
}
