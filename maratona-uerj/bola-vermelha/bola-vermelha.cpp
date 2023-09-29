#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

#define MAX_N 1000

bool livingRoom[MAX_N][MAX_N];

bool isValid(int, int, int);
void enqueueCoord(queue<tuple<int, int, int>>&, int, int, int, int);
int calculateDistance(int, int, int, int, int);
void readMatrix(int);

int main() {

    int testCases;
    cin >> testCases;
    
    while (testCases--) {

        int n;
        cin >> n;

        readMatrix(n);

        int startX, startY, endX, endY;
        cin >> startX >> startY >> endX >> endY;

        cout << calculateDistance(startX, startY, endX, endY, n) << endl;
    }
 
    return 0;
}

int calculateDistance(int startX, int startY, int endX, int endY, int n) {

    int result = -1;
    queue<tuple<int, int, int>> pathQueue;

    if (isValid(startX, startY, n) && isValid(endX, endY, n)) {
        pathQueue.push(make_tuple(startX, startY, 0));
    }
    
    while (!pathQueue.empty()) {
        tuple<int, int, int> coord = pathQueue.front();
        
        int x = get<0>(coord);
        int y = get<1>(coord);
        int dist = get<2>(coord);

        pathQueue.pop();

        if (x == endX && y == endY) {
            result = dist;
            break;
        }

        int nextDist = dist + 1;
        enqueueCoord(pathQueue, x+1, y, nextDist, n);
        enqueueCoord(pathQueue, x-1, y, nextDist, n);
        enqueueCoord(pathQueue, x, y+1, nextDist, n);
        enqueueCoord(pathQueue, x, y-1, nextDist, n);
    }

    return result;
}

void enqueueCoord(queue<tuple<int, int, int>>& pathQueue, int x, int y, int dist, int n) {

    if (isValid(x, y, n)) {
        pathQueue.push(make_tuple(x, y, dist));
        livingRoom[x][y] = 1;
    }
}

bool isValid(int x, int y, int n) {
    return x >= 0 && x < n && y >= 0 && y < n && !livingRoom[x][y];
}

void readMatrix(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> livingRoom[i][j]; 
        }
    }
}