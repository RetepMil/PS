#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;

    int **array = new int *[N];

    for (int i = 0; i < N; i++)
    {
        array[i] = new int[N];
        fill_n(array[i], N, 0);
        for (int j = 0; j < N; j++)
        {
            cin >> array[i][j];
        }
    }

    return 0;
}