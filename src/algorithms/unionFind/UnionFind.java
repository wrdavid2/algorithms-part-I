package algorithms.unionFind;

public interface UnionFind {
    void union(int p, int q); //Add connection between p and q. (merge p and q if they're in different sets)

    //int find(int p); // component identifier for p (0 to N-1)

    boolean connected(int p, int q); //return true if p and q are in same component

    //int count(); // # of components
}
