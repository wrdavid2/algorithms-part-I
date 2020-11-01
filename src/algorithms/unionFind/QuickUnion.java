package algorithms.unionFind;

//"Lazy approach"
//Slightly better, but still too slow
//Union can still take N operations (worst-case) REally tall trees
//Find can take
public class QuickUnion implements UnionFind {
    private int[] id;

    public QuickUnion(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; ++i) {
            this.id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        this.id[pRoot] = qRoot;
    }

    public int find(int p) {
        while (p != this.id[p]) {
            p = this.id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return 0;
    }
}
