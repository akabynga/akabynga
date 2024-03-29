package com.akabynga.faang.structure;


import java.util.*;
import java.util.function.Consumer;

public class Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacentVertices;

    public Graph() {
        this.adjacentVertices = new HashMap<>();
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<T>, List<Vertex<T>>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addVertex(T label) {
        adjacentVertices.putIfAbsent(new Vertex<>(label), new ArrayList<>());
    }

    public void removeVertex(T label) {
        Vertex<T> v = new Vertex<>(label);
        adjacentVertices.values().forEach(e -> e.remove(v));
        adjacentVertices.remove(new Vertex<>(label));
    }

    public void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<>(label1);
        Vertex<T> v2 = new Vertex<>(label2);
        adjacentVertices.get(v1).add(v2);
        adjacentVertices.get(v2).add(v1);
    }

    public void removeEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<>(label1);
        Vertex<T> v2 = new Vertex<>(label2);
        List<Vertex<T>> eV1 = adjacentVertices.get(v1);
        List<Vertex<T>> eV2 = adjacentVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    public List<Vertex<T>> getAdjacentVertices(T label) {
        return adjacentVertices.get(new Vertex<>(label));
    }

    public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        return adjacentVertices.get(vertex);
    }

    public static <P> void breadthFirstTraversal(Graph<P> graph, P root, Consumer<P> consumer) {
        graph.breadthFirstTraversal(root, consumer, false);
    }

    public void breadthFirstTraversal(T root, Consumer<T> consumer) {
        breadthFirstTraversal(root, consumer, false);
    }

    public void breadthFirstTraversal(T root, Consumer<T> consumer, boolean debugMode) {

        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new LinkedHashSet<>();

        queue.add(new Vertex<>(root));
        visited.add(new Vertex<>(root));

        while (!queue.isEmpty()) {
            Vertex<T> element = queue.poll();

            if (consumer != null) {
                consumer.accept(element.getLabel());
            }
            if (debugMode) {
                System.out.print(element.getLabel() + " ");
            }

            for (Vertex<T> adj : getAdjacentVertices(element)) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
    }

    public static <P> void depthFirstTraversal(Graph<P> graph, P root, Consumer<P> consumer) {
        graph.depthFirstTraversal(root, consumer, false);
    }

    public void depthFirstTraversal(T root, Consumer<T> consumer) {
        depthFirstTraversal(root, consumer, false);
    }

    public void depthFirstTraversal(T root, Consumer<T> consumer, boolean debugMode) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        Set<Vertex<T>> visited = new LinkedHashSet<>();

        stack.add(new Vertex<>(root));
        visited.add(new Vertex<>(root));

        while (!stack.isEmpty()) {
            Vertex<T> element = stack.removeFirst();

            if (consumer != null) {
                consumer.accept(element.getLabel());
            }
            if (debugMode) {
                System.out.print(element.getLabel() + " ");
            }
            for (Vertex<T> adj : getAdjacentVertices(element)) {
                if (!visited.contains(adj)) {
                    stack.addFirst(adj);
                    visited.add(adj);
                }
            }
        }
    }

    public void depthFirstTraversalRecursive(T root, Consumer<T> consumer, boolean debugMode) {
        Vertex<T> rootVertex = new Vertex<>(root);
        Set<Vertex<T>> visited = new LinkedHashSet<>();
        visited.add(rootVertex);

        _depthFirstTraversalRecursive(visited, rootVertex, consumer, debugMode);
    }

    private void _depthFirstTraversalRecursive(Set<Vertex<T>> visited, Vertex<T> vertex, Consumer<T> consumer, boolean debugMode) {

        visited.add(vertex);

        if (consumer != null) {
            consumer.accept(vertex.getLabel());
        }
        if (debugMode) {
            System.out.print(vertex.getLabel() + " ");
        }

        for (Vertex<T> adj : getAdjacentVertices(vertex)) {
            if (!visited.contains(adj)) {
                _depthFirstTraversalRecursive(visited, adj, consumer, debugMode);
            }
        }
    }


    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        graph.breadthFirstTraversal("Bob", null, true);
        System.out.println();
        graph.depthFirstTraversal("Bob", null, true);
        System.out.println();
        graph.depthFirstTraversalRecursive("Bob", null, true);
    }
}