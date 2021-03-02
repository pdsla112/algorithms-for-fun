package BreadthFirstSearchAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTree {
    private int numVertices;
    private ArrayList<Boolean> visitedList = new ArrayList<>();
    private LinkedList<LinkedList<Integer>> adjacent = new LinkedList<>();

    public BreadthFirstSearchTree(int numVertices) {
        this.numVertices = numVertices;

        for (int i = 0; i < numVertices; i++) {
            visitedList.add(false);
        }

        for (int i = 0; i < numVertices; i++) {
            adjacent.add(new LinkedList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacent.get(vertex1).add(vertex2);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public ArrayList<Integer> getVertices() {
        ArrayList<Integer> vertices = new ArrayList<>();
        if (numVertices == 0)
            return vertices;
        for (int i = 0; i < numVertices; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    public boolean isVisited(int vertex) {
        if (visitedList.get(vertex))
            return true;
        return false;
    }

    public void changeVisitation(int vertex) {
        if (!isVisited(vertex))
            visitedList.set(vertex, true);
    }

    public ArrayList<Integer> BFS(int startVertex) {
        for (int i = 0; i < numVertices; i++) {
            visitedList.set(i, false);
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        result.add(startVertex);
        int i = startVertex;
        changeVisitation(i);
        while (queue.size() != 0) {
            LinkedList<Integer> children = adjacent.get(i);
            for (Integer child : children) {
                if (!isVisited(child)) {
                    changeVisitation(child);
                    queue.add(child);
                    result.add(child);
                }
            }
            queue.poll();
            if (!queue.isEmpty()) {
                i = queue.element();
            } else {
                break;
            }
        }
        return result;
    }
}
