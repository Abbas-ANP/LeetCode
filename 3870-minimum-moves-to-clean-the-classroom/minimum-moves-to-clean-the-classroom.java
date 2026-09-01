class State {
    int r, c, energy, mask;

    State(int r, int c, int energy, int mask) {
        this.r = r;
        this.c = c;
        this.energy = energy;
        this.mask = mask;
    }
}

class Solution {
    int m, n;
    int maxEnergy;
    int litterCount;
    int[][] litterId;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int minMoves(String[] classroom, int energy) {
        m = classroom.length;
        n = classroom[0].length();
        maxEnergy = energy;
        litterId = new int[m][n];
        char[][] room = new char[m][n];

        for (int r = 0; r < m; r++) {
            Arrays.fill(litterId[r], -1);
            for (int c = 0; c < n; c++) {
                room[r][c] = classroom[r].charAt(c);
            }
        }

        int startR = 0;
        int startC = 0;

        // find S and assign an ID to every L
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (room[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }

                if (room[r][c] == 'L') {
                    litterId[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        boolean[][][][] visited = new boolean[m][n][maxEnergy + 1][1 << litterCount];
        Queue<State> queue = new ArrayDeque<>();
        int startMask = 0;

        queue.offer(new State(startR, startC, energy, startMask));
        visited[startR][startC][energy][startMask] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // process one level
            for (int i = 0; i < size; i++) {
                State curr = queue.poll();

                // if all litter collected
                if (curr.mask == fullMask) {
                    return moves;
                }

                if (curr.energy == 0) {
                    continue;
                }

                // try 4 dirs
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    // out of bounds
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    if (room[nr][nc] == 'X') {
                        continue;
                    }

                    // moving costs one energy
                    int newEnergy = curr.energy - 1;

                    if (room[nr][nc] == 'R') {
                        newEnergy = maxEnergy;
                    }

                    // same mask initially
                    int newMask = curr.mask;

                    // collect if litter
                    if (room[nr][nc] == 'L') {
                        int id = litterId[nr][nc];

                        newMask = curr.mask | (1 << id);
                    }

                    // already visited this exact state
                    if (visited[nr][nc][newEnergy][newMask]) {
                        continue;
                    }

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new State(nr, nc, newEnergy, newMask));
                }
            }

            moves++;
        }

        return -1;
    }
}