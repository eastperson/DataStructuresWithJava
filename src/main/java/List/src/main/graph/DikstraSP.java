package List.src.main.graph;

        import java.util.List;

public class DikstraSP {
    public int N; // 그래프 정점의 수
    List<EdgeForDikstra>[] graph;
    public int[] previous; // 최단경로상 이전 정점을 기록하기 위해
    public DikstraSP(List<EdgeForDikstra>[] adjList) {
        N = adjList.length;
        previous = new int[N];
        graph = adjList;
    }
    public int[] shortesPath(int s){
        boolean[] visited = new  boolean[N];
        int[] D = new int[N];
        for(int i = 0; i < N; i++) { // 초기화
            visited[i] = false;
            previous[i] = -1;
            D[i] = Integer.MAX_VALUE;
        }
        previous[s] = 0; // 시작점 s의 관련 정보 초기화
        D[s] = 0;
        for(int k = 0; k < N; k++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                if((!visited[j]) && (D[j] < min)){
                    min = D[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;
            for(EdgeForDikstra e : graph[minVertex]) {
                if(!visited[e.adjvertex]){
                    int currentDist = D[e.adjvertex];
                    int newDist = D[minVertex] + e.weight;
                    if(newDist < currentDist) {
                        D[e.adjvertex] = newDist;
                        previous[e.adjvertex] = minVertex;
                    }
                }
            }
        }
        return D;
    }
}

class EdgeForDikstra{
    int vertex; // 간선의 한쪽 끝 정점
    int adjvertex; // 간선의 다른쪽 끝 정점
    int weight; // 간선의 가중치
    public EdgeForDikstra(int u, int v, int wt){
        vertex = u;
        adjvertex = v;
        weight = wt;
    }
}
