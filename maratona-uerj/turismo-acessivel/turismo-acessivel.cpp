#include <iostream>

using namespace std;

#define MAX_LIFTS 1000000
#define MAX_ATTRACTIONS 1000

int lifts[MAX_LIFTS];
int attractions[MAX_ATTRACTIONS];

int closest(int x, int y, int target);
int binarySearch(int n, int target);

int main() {

    int testCases;
    cin >> testCases;

    while(testCases--) {

        int n, d;
        cin >> n >> d;

        for (int i = 0; i < n; i++) {
            cin >> lifts[i];
        }

        for (int i = 0; i < d; i++) {
            cin >> attractions[i];
            cout << binarySearch(n, attractions[i]);
            if (i<d-1) cout << " "; else cout << endl;
        }
    }

    return 0;
}

int binarySearch(int n, int target) {

    if (target <= lifts[0]) {
        return lifts[0];
    }
  
    if (target >= lifts[n-1]) {
        return lifts[n-1];
    }

    int i = 0, j = n, mid = 0;
    while (i < j) {
        mid = (i + j) / 2;
 
        if (lifts[mid] == target)
            return lifts[mid];
 
        if (target < lifts[mid]) {

            if (mid > 0 && target > lifts[mid-1]) {
                return closest(lifts[mid - 1], lifts[mid], target);  
            }

            j = mid;

        } else {
            if (mid < n - 1 && target < lifts[mid + 1]) {
                return closest(lifts[mid], lifts[mid + 1], target);
            }
                
            i = mid + 1;
        }
    }

    return lifts[mid];
}

int closest(int x, int y, int target) {
    if (target - x > y - target) {
        return y;
    } else {
        return x;
    }
}