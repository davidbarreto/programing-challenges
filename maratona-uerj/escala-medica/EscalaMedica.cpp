#include <iostream>
using namespace std;
struct periodo {int c; int f;};

int i, t, nc, n, d1, d2, p, q;
periodo M[100000002];

bool compare(periodo p1, periodo p2){
	return p1.c < p2.c;
}

int main(){
	cin>>nc;
	while(nc--){
		cin>>n>>d1>>d2;
		for (i=0; i<n; i++)
			cin>>M[i].c>>M[i].f;
		sort(M, M+n, compare);
		M[n].c = 1000000000;   M[n].f = 1000000000;
		t = 0;
		p = d1;
		q = 0;
		while(M[q].f < p){
			//cout<<M[q].f<<"\n";
			q++;  
		}
		for (i=q; i<=n; i++){
			//cout<<M[i].c<<" "<<M[i].f<<" "<<p<<" "<<q<<" "<<t<<"\n";
			if (M[i].f >= p){
				if (M[i].c <= p){
					if (M[i].f > M[q].f)
						q = i;
				}
				else {
					t++;
					p = M[q].f+1;
					if (p > d2)
						break;
					q = i;
				}
			}
			//cout<<M[i].c<<" "<<M[i].f<<" "<<p<<" "<<q<<" "<<t<<"\n";
		}
		cout<<t<<"\n";
	}
	return 0;
}
