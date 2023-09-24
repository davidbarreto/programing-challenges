#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

#define MAX_N 1000

bool livingRoom[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];
queue<tuple<int, int, int>> pathQueue;

bool isValid(int x, int y, int n);
void enqueueCoord(int x, int y, int dist, int n);
void resetVisited(int n);

int main() {

    int testCases;
    cin >> testCases;
    
    while (testCases--) {

        int n;
        cin >> n;

        resetVisited(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> livingRoom[i][j]; 
            }
        }

        int startX, startY, endX, endY;
        cin >> startX >> startY >> endX >> endY;

        pathQueue.push(make_tuple(startX, startY, 0));

        bool foundResult = false;
        while (!pathQueue.empty()) {
            tuple<int, int, int> coord = pathQueue.front();
            
            int x = get<0>(coord);
            int y = get<1>(coord);
            int dist = get<2>(coord);

            pathQueue.pop();

            if (x == endX && y == endY) {
                cout << dist << endl;
                foundResult = true;
                break;
            }

            int nextDist = dist + 1;
            enqueueCoord(x+1, y, nextDist, n);
            enqueueCoord(x-1, y, nextDist, n);
            enqueueCoord(x, y+1, nextDist, n);
            enqueueCoord(x, y-1, nextDist, n);
        }

        if (!foundResult) {
            cout << -1 << endl;
        }
        
    }
 
    return 0;
}

void enqueueCoord(int x, int y, int dist, int n) {

    if (isValid(x, y, n)) {
        pathQueue.push(make_tuple(x, y, dist));
        visited[x][y] = true;
    }
}

bool isValid(int x, int y, int n) {
    return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && !livingRoom[x][y];
}

void resetVisited(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            visited[i][j] = false;
        }
    }
}