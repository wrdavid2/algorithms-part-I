package algorithms.unionFind.interviewQuestions;

import algorithms.unionFind.UnionFind;

//Question 2
//Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i) returns the largest element
//in the connected component containing ii. The operations,union(), connected(), find() should all take logarithmic time or better.
//For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.

public class UnionFindwithCanonicalElement implements UnionFind {

    private int[] id;
    private int[] sz;
    private int[] large;
    private int count;

    public UnionFindwithCanonicalElement(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
        count = N;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        if (qRoot < pRoot) {
            large[qRoot] = pRoot;
        } else {
            large[pRoot] = qRoot;
        }

        count--;
    }

    public int find(int i) {
        return large[root(i)];
    }

    public int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
