package algorithms;

//"Eager" approach. Some issues as the union means changing a whole bunch of values
//Way too slow. N to in
public class QuickFind implements UnionFind {
    private int[] id;
    private int _count;

    public QuickFind(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; ++i) {
            this.id[i] = i;
        }
        this._count = N;
    }

    public void union(int p, int q) {
        if (connected(p, q))
            return;
        int pID = find(p);
        int qID = find(q);

        for (int i = 0; i < this.id.length; ++i) {
            if (this.id[i] == pID) {
                this.id[i] = qID;
            }
        }
        --this._count;
    }

    public int find(int p) {
        return this.id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return this._count;
    }
}
