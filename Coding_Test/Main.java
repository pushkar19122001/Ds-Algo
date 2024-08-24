import java.io.*;
import java.util.*;

public class Main {

    static int[] A;
    static List<List<Integer>> tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // Initialize adjacency list for the tree
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        // Read parent array P
        for (int i = 1; i < N; i++) {
            int parent = Integer.parseInt(br.readLine().trim());
            tree.get(parent).add(i);
        }

        // Read array A
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Initialize dp array
        dp = new int[N];

        // Start DFS from the root (node 0)
        dfs(0);

        // Find the maximum value in dp array
        int maxGoodPathLength = 0;
        for (int i = 0; i < N; i++) {
            maxGoodPathLength = Math.max(maxGoodPathLength, dp[i]);
        }

        System.out.println(maxGoodPathLength);
    }

    // DFS function to calculate maximum length of good path starting from node u
    static void dfs(int u) {
        for (int v : tree.get(u)) {
            if ((A[u] ^ A[v]) < A[u] && (A[u] ^ A[v]) < A[v]) {
                dp[v] = dp[u] + 1;
                dfs(v);
            }
        }
    }
}