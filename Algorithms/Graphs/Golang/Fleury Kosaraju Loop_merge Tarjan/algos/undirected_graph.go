package algos

import (
	"fmt"
	"strings"
)

type UndirectedGraph[T comparable] struct {
	graph map[T]map[T]*int
}

func NewUndirectedGraph[T comparable]() *UndirectedGraph[T] {
	return &UndirectedGraph[T]{
		graph: make(map[T]map[T]*int),
	}
}

func (g *UndirectedGraph[T]) AddEdge(src T, dest T) {
	if g.graph[src] == nil {
		g.graph[src] = make(map[T]*int)
	}

	if g.graph[dest] == nil {
		g.graph[dest] = make(map[T]*int)
	}

	g.graph[src][dest] = nil
	g.graph[dest][src] = nil
}

func (g *UndirectedGraph[T]) String() string {
	var sb strings.Builder

	sb.WriteString("================================\n")
	sb.WriteString("Undirected graph:\n")
	for src, destNodes := range g.graph {
		for destNode, weight := range destNodes {
			if weight != nil {
				sb.WriteString(fmt.Sprintf("%v -> %v (%d)\n", src, destNode, *weight))
			} else {
				sb.WriteString(fmt.Sprintf("%v -> %v (nil)\n", src, destNode))
			}
		}
	}
	sb.WriteString("================================")

	return sb.String()
}
