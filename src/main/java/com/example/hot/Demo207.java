package com.example.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程表
 */
public class Demo207 {

    Map<Integer, List<Integer>> edges;
    private boolean isValid = true;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new HashMap<>();
        visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<Integer> integers = edges.computeIfAbsent(prerequisite[1], k -> new ArrayList<>());
            integers.add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && isValid; i++) {
            if (visited[i] == 0) {
                dfs(i);

            }
        }
        return isValid;

    }

    public void dfs(int u) {
        visited[u] = 1;
        List<Integer> integers = edges.get(u);
        if (integers == null) {
            visited[u] = 2;
            return;
        }
        for (int v : integers) {

            if (visited[v] == 0) {
                dfs(v);


                if (!isValid) {
                    return;
                }
            } else if (visited[v] == 1) {
                isValid = false;
                return;
            }
        }
        visited[u] = 2;

    }




}
