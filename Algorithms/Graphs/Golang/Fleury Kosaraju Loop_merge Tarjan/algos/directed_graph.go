package algos

import (
	"fmt"
	"strings"
)

type DirectedGraph[T comparable] struct {
	graph map[T]map[T]*int
}

func NewDirectedGraph[T comparable]() *DirectedGraph[T] {
	return &DirectedGraph[T]{
		graph: make(map[T]map[T]*int),
	}
}

func (g *DirectedGraph[T]) AddEdge(src T, dest T) {
	if g.graph[src] == nil {
		g.graph[src] = make(map[T]*int)
	}

	g.graph[src][dest] = nil
}

func (g *DirectedGraph[T]) String() string {
	var sb strings.Builder

	sb.WriteString("================================\n")
	sb.WriteString("Directed graph:\n")
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
