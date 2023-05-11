#include <iostream>
#include <queue>

using namespace std;

// using adjacency matrix

const int MAXN = 100; // maximum number of nodes
bool visited[MAXN]; // visited array to keep track of visited nodes
int adj[MAXN][MAXN]; // adjacency matrix to represent the graph

void bfs(int start) {
    queue<int> q; // create a queue to store nodes to visit
    visited[start] = true; // mark the starting node as visited
    q.push(start); // add the starting node to the queue

    while (!q.empty()) {
        int curr = q.front(); // get the next node from the queue
        q.pop(); // remove the node from the queue

        // loop through all adjacent nodes of the current node
        for (int i = 0; i < MAXN; i++) {
            if (adj[curr][i] && !visited[i]) { // if there is an edge to an unvisited node
                visited[i] = true; // mark the node as visited
                q.push(i); // add the node to the queue
            }
        }
    }
}

int main() {
    // initialize adjacency matrix
    for (int i = 0; i < MAXN; i++) {
        for (int j = 0; j < MAXN; j++) {
            adj[i][j] = 0;
        }
    }

    // add edges to the graph
    adj[0][1] = 1;
    adj[1][2] = 1;
    adj[2][0] = 1;
    adj[2][3] = 1;
    adj[3][3] = 1;

    // perform BFS starting from node 2
    bfs(2);

    return 0;
}

// using adjacency list

const int MAXN = 100; // maximum number of nodes
bool visited[MAXN]; // visited array to keep track of visited nodes
int adj[MAXN][MAXN]; // adjacency list to represent the graph
int degree[MAXN]; // degree array to keep track of the number of neighbors of each node

void bfs(int start) {
    queue<int> q; // create a queue to store nodes to visit
    visited[start] = true; // mark the starting node as visited
    q.push(start); // add the starting node to the queue

    while (!q.empty()) {
        int curr = q.front(); // get the next node from the queue
        q.pop(); // remove the node from the queue

        // loop through all adjacent nodes of the current node
        for (int i = 0; i < degree[curr]; i++) {
            int next = adj[curr][i];
            if (!visited[next]) { // if the adjacent node has not been visited yet
                visited[next] = true; // mark the node as visited
                q.push(next); // add the node to the queue
            }
        }
    }
}

int main() {
    // initialize adjacency list and degree arrays
    for (int i = 0; i < MAXN; i++) {
        degree[i] = 0;
        for (int j = 0; j < MAXN; j++) {
            adj[i][j] = -1; // -1 represents no edge
        }
    }

    // add edges to the graph
    adj[0][degree[0]++] = 1;
    adj[1][degree[1]++] = 2;
    adj[2][degree[2]++] = 0;
    adj[2][degree[2]++] = 3;
    adj[3][degree[3]++] = 3;

    // perform BFS starting from node 2
    bfs(2);

    return 0;
}
