package hamiltonianPath;

import java.util.*;

public class SolutionV1 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> graph = extractVertices(adjacentPairs);
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int startVertex : graph.keySet()) {
            path.add(startVertex);
            visited.add(startVertex);
            if (dfs(graph, startVertex, visited, path)) {
                return path.stream().mapToInt(Integer::intValue).toArray();
            }
            path.remove(path.size() - 1);
            visited.remove(startVertex);
        }
        return new int[0];
    }

    private Map<Integer, Set<Integer>> extractVertices(int[][] pairs) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : pairs) {
            int from = edge[0];
            int to = edge[1];
            adjList.putIfAbsent(from, new HashSet<>());
            adjList.get(from).add(to);
            adjList.putIfAbsent(to, new HashSet<>());
            adjList.get(to).add(from);
        }
        return adjList;
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, int current,
                        Set<Integer> visited, List<Integer> path) {
        if (visited.size() == graph.size()) {
            return true;
        }

        for (int neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                path.add(neighbor);
                if (dfs(graph, neighbor, visited, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
                visited.remove(neighbor);
            }
        }
        return false;
    }
}