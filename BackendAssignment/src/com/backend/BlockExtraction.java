package com.backend;

import java.util.*;

public class BlockExtraction {

    private static final int[] rowDirections = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] colDirections = {0, 0, -1, 1};

    public static void main(String[] args) {
        // Hardcoded input for the matrix and target block color
        int N = 5, M = 5;
        int[][] matrix = {
            {15, 12, 23, 13, 13},
            {15, 12, 14, 8, 10},
            {5, 11, 11, 8, 9},
            {5, 6, 6, 7, 7},
            {1, 1, 2, 3, 4}
        };
        int targetColor = 1;

        int blocksToRemove = calculateBlocksToRemove(matrix, N, M, targetColor);
        System.out.println(blocksToRemove); // Output: 8
    }

    private static int calculateBlocksToRemove(int[][] matrix, int N, int M, int targetColor) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int blocksToRemove = 0;

        // Find the target block's position
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == targetColor) {
                    queue.add(new int[]{i, j});
                    break;
                }
            }
        }

        // BFS to find all blocks that need to be removed
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Remove the block at (row, col)
            if (!visited[row][col]) {
                visited[row][col] = true;
                blocksToRemove++;

                // Check adjacent blocks
                for (int d = 0; d < 4; d++) {
                    int newRow = row + rowDirections[d];
                    int newCol = col + colDirections[d];

                    // Check bounds
                    if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                        // If the adjacent block is not visited and has the same color
                        if (!visited[newRow][newCol] && matrix[newRow][newCol] != 0) {
                            queue.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }

        // Now check for blocks that fall due to gravity
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (matrix[i][j] != 0 && !visited[i][j]) {
                    // Check if the block can fall
                    boolean canFall = false;
                    for (int d = 0; d < 4; d++) {
                        int newRow = i + rowDirections[d];
                        int newCol = j + colDirections[d];

                        if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                            if (visited[newRow][newCol]) {
                                canFall = true;
                                break;
                            }
                        }
                    }

                    if (canFall) {
                        blocksToRemove++;
                        visited[i][j] = true; // Mark as removed
                    }
                }
            }
        }

        return blocksToRemove;
    }
}