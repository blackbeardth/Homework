#include <iostream>
#include <cstring>

using namespace std;

const int MAXN = 100; // maximum number of nodes
bool visited[MAXN]; // visited array to keep track of visited nodes
int adj[MAXN][MAXN]; // adjacency matrix to represent the graph

// using adjacency matrix

void dfs(int node) {
    visited[node] = true; // mark the current node as visited
    cout << node << " "; // print the node

    // loop through all adjacent nodes of the current node
    for (int i = 0; i < MAXN; i++) {
        if (adj[node][i] && !visited[i]) { // if there is an edge between the current node and the adjacent node, and the adjacent node has not been visited yet
            dfs(i); // recursively visit the adjacent node
        }
    }
}

int main() {
    // initialize adjacency matrix
    memset(adj, 0, sizeof(adj));

    // add edges to the graph
    adj[0][1] = 1;
    adj[1][2] = 1;
    adj[2][0] = 1;
    adj[2][3] = 1;
    adj[3][3] = 1;

    // perform DFS starting from node 2
    dfs(2);

    return 0;
}

// using adjacency list

const int MAXN = 100; // maximum number of nodes
bool visited[MAXN]; // visited array to keep track of visited nodes
int adj[MAXN][MAXN]; // adjacency list to represent the graph

void dfs(int node) {
    visited[node] = true; // mark the current node as visited
    cout << node << " "; // print the node

    // loop through all adjacent nodes of the current node
    for (int i = 0; i < MAXN; i++) {
        if (adj[node][i] && !visited[i]) { // if there is an edge between the current node and the adjacent node, and the adjacent node has not been visited yet
            dfs(i); // recursively visit the adjacent node
        }
    }
}

int main() {
    // initialize adjacency list
    memset(adj, 0, sizeof(adj));

    // add edges to the graph
    adj[0][1] = 1;
    adj[1][2] = 1;
    adj[2][0] = 1;
    adj[2][3] = 1;
    adj[3][3] = 1;

    // perform DFS starting from node 2
    dfs(2);

    return 0;
}

