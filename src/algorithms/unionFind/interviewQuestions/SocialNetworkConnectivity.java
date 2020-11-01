package algorithms.unionFind.interviewQuestions;

import algorithms.unionFind.UnionFind;

//Social network connectivity. Given a social network containing N members and a log file containing M timestamps at
// which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected
// (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
// The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to N.

//When count is = 1, then every friend is connected
public class SocialNetworkConnectivity implements UnionFind {

    private int[] id;
    private int[] sz;
    private int count;

    public SocialNetworkConnectivity(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
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
        count--;
        if (count == 1) {
            System.out.println("All friends are connected!");
        }
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
