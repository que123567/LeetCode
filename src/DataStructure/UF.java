package DataStructure;

public class UF {
    /**
     * 连通分量
     */
    private int count;

    /**
     * 树
     */
    private int parent[];

    /**
     * 树的全部节点数
     */
    private int size[];

    /**
     * 构造函数
     *
     * @param n 连通分量
     */
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 连通2个节点
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        //p是大树
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = p;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 是否连通
     */
    public boolean connect(int p, int q) {
        return find(q) == find(p);
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int getCount() {
        return count;
    }
}
