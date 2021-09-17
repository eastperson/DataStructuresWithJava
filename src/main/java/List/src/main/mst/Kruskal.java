package List.src.main.mst;

import List.src.main.java.NodeForTree;
import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    int N, M; // 그래프 정점, 간선 수
    List<EdgeForKruskal>[] graph;
    UnionFind uf; // Union-Find 연산
    EdgeForKruskal[] tree;
    // weight 기준으로 우선순위 큐를 사용하기 위해
    static class Weight_Comparison implements Comparator<EdgeForKruskal>{
        public int compare(EdgeForKruskal e, EdgeForKruskal f){
            if(e.weight > f.weight) {
                return 1;
            } else if(e.weight < f.weight) {
                return -1;
            }
            return 0;
        }
    }
    public Kruskal(List<EdgeForKruskal>[] adjList, int numOfEdges) {
        N = adjList.length;
        M = numOfEdges;
        graph = adjList;
        uf = new UnionFind(N);
        tree = new EdgeForKruskal[N-1];
    }

    // kruskal 알고리즘
    public EdgeForKruskal[] mst(){
        // 우선순위큐를 weight 기준으로 구성하기 위해
        // 자바 라이브러리의 우선순위큐 사용
        Weight_Comparison BY_WEIGHT = new Weight_Comparison();
        // 우선순위큐의 크기로 M(간선의 수)을 지정, BY_WEIGHT는 comparator
        PriorityQueue<EdgeForKruskal> pq = new PriorityQueue<>(M,BY_WEIGHT);
        for(int i = 0; i < N; i++) {
            for(EdgeForKruskal e : graph[i]) {
                pq.add(e); // edgeArray의 간선 객체를 pq에 삽입
            }
        }
        int count = 0;
        while(!pq.isEmpty() && count < N-1) {
            EdgeForKruskal e = pq.poll();
            int u =  e.vertex;
            int v = e.adjvertex;
            if(!uf.isConnected(u,v)) {
                uf.union(u,v);
                tree[count++] = e;
            }
        }
        return tree;
    }

}

class EdgeForKruskal{
    int vertex, adjvertex; // 간선의 양끝 정점들
    int weight;
    public EdgeForKruskal(int u, int v, int wt){
        // 정점
        vertex = u;
        // 인접 정점
        adjvertex = v;
        // 가중치
        weight = wt;
    }
}

class NodeForKruskal {
    int parent;
    int rank;
    public NodeForKruskal(int newParent, int newRank){
        parent = newParent;
        rank = newRank;
    }
    public int getParent() {return parent;}
    public int getRank() {return rank;}
    public void setParent(int newParent) {parent = newParent;}
    public void setRank(int newRank) {rank = newRank;}
}

class UnionFind{
    protected NodeForKruskal[] a;

    // 생성자
    public UnionFind(int N) {
        a = new NodeForKruskal[N];
    }

    // i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다.
    protected int find(int i) { // 경로 압축
        if(i != a[i].getParent()) {
            a[i].setParent(find(a[i].getParent()));
        }
        return a[i].getParent();
    }

    public void union(int i, int j) { // Union 연산
        int iroot = find(i);
        int jroot = find(j);
        if(iroot == jroot) return; // 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴

        if(a[iroot].getRank() > a[jroot].getRank()) {
            a[jroot].setParent(iroot); // iroot가 승자
        } else if(a[iroot].getRank() < a[jroot].getRank()) {
            a[iroot].setParent(jroot); // jroot가 승자
        } else {
            a[jroot].setParent(iroot); // 둘 중에 하나 임의로 증가
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t); // iroot의 rank 1 증가
        }
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

}