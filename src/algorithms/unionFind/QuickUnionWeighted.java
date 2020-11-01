package algorithms.unionFind;

//"Lazy approach"
//Slightly better, but still too slow
//Union can still take N operations (worst-case) REally tall trees
//Find can take
public class QuickUnionWeighted implements UnionFind {
    private int[] id;
    private int[] size;
    private int _count;

    public QuickUnionWeighted(int N) {
        this.id = new int[N];
        this.size = new int[N];
        for (int i = 0; i < N; ++i) {
            this.id[i] = i;
            this.size[i] = 1;
        }
        this._count = N;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (qRoot == pRoot) {
            return;
        }
        if (this.size[pRoot] < this.size[qRoot]) {
            this.id[pRoot] = qRoot;
            this.size[qRoot] += this.size[pRoot];
        } else {
            this.id[qRoot] = pRoot;
            this.size[pRoot] += this.size[qRoot];
        }
        --this._count;
    }

    public int root(int p) {
        while (p != this.id[p]) {
            //With path compression Uncomment
            id[p] = id[id[p]];
            p = this.id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int count() {
        return this._count;
    }
}
