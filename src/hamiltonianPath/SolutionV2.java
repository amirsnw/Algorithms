package hamiltonianPath;

import java.util.*;

public class SolutionV2 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = buildGraph(adjacentPairs);
        int[] result = new int[graph.size()];
        Set<Integer> visitedStarts = new HashSet<>();
        while (true) {
            Integer startVertex = findStartVertex(graph, visitedStarts);
            if (startVertex == null) {
                return result;
            }
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(startVertex);
            visited.add(startVertex);
            int index = 0;

            while (!stack.isEmpty()) {
                int current = stack.pop();
                result[index++] = current;
                visited.add(current);

                List<Integer> nodes = graph.get(current);
                for (int neighbor : nodes) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    } else if (nodes.size() == 1) {
                        stack.clear();
                        break;
                    }
                }
            }
            if (visited.size() == graph.size()) {
                break;
            }
        }
        return result;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>(2)).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>(2)).add(u);
        }
        return graph;
    }

    private Integer findStartVertex(Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        for (int vertex : graph.keySet()) {
            if (graph.get(vertex).size() == 1 && !visited.contains(vertex)) {
                visited.add(vertex);
                return vertex;
            }
        }
        return null;
    }
}