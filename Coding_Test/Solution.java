import java.io.*;
import java.util.*;

public class Solution {
    static int[] nodeValues;
    static List<List<Integer>> tree;
    static int maxPathLength;

    public static int get_ans(int N, int[] P, int[] A) {
        // Initialize global variables
        nodeValues = A;
        tree = new ArrayList<>(N);
        maxPathLength = 0; // Initialize maxPathLength to 0

        // Fill tree with empty lists for adjacency representation
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the tree using the parent array P
        for (int i = 1; i < N; i++) {
            int parent = P[i];
            tree.get(parent).add(i);
            tree.get(i).add(parent);  // Ensuring the bidirectional nature of the tree
        }

        // Create a visited array to track visited nodes
        boolean[] visited = new boolean[N];
        
        // Start DFS traversal from the root node (node 0)
        dfs(0, -1, visited);

        return maxPathLength;
    }

    // DFS function to calculate the maximum length of the good path
    static int dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;
        int maxDepth1 = 0;
        int maxDepth2 = 0;

        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) { // Ensure we do not revisit the parent
                int depth = dfs(neighbor, node, visited);
                if ((nodeValues[node] ^ nodeValues[neighbor]) < nodeValues[node] &&
                    (nodeValues[node] ^ nodeValues[neighbor]) < nodeValues[neighbor]) {
                    if (depth + 1 > maxDepth1) {
                        maxDepth2 = maxDepth1;
                        maxDepth1 = depth + 1;
                    } else if (depth + 1 > maxDepth2) {
                        maxDepth2 = depth + 1;
                    }
                }
            }
        }

        maxPathLength = Math.max(maxPathLength, maxDepth1 + maxDepth2 + 1);
        return maxDepth1 + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] P = new int[N];
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(br.readLine().trim());
        }

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(get_ans(N, P, A));
    }
}
