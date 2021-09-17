package List.src.main.mst;

import java.util.List;

public class Prim {
    int N; // 그래프 정점의 수
    List<EdgeForPrim>[] graph;

    public Prim(List<EdgeForPrim>[] adjList){ // 생성자
        N = adjList.length;
        graph = adjList;
    }

    public int[] mst(int s) {
        boolean[] visited = new boolean[N];
        int[] D = new int[N];
        int[] previous = new int[N];// 방문된 정점은 true로
        for(int i = 0; i < N; i++) { // 초기화
            visited[i] = false;
            previous[i] = -1;
            D[i] = Integer.MAX_VALUE; // D[i]를 최댓값으로 초기화
        }
        previous[s] = 0; // 시작정점 s의 관련 정보 초기화
        D[s] = 0;

        for(int k = 0; k < N; k++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for(int j =0; j< N; j++) {
                if((!visited[j]&&(D[j]<min))){
                    min = D[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;
            for(EdgeForPrim i : graph[minVertex]) { // minVertex에 인접한 각 정점의 D 원소 갱신
                if(!visited[i.adjvertex]) { // 트리에 아직 포함 안된 정점이면면
                   int currentDist = D[i.adjvertex];
                    int newDist = i.weight;
                    if(newDist<currentDist) {
                        D[i.adjvertex] = newDist; // minVertex와 연결된 정점들의 D 원소 갱신
                        previous[i.adjvertex] = minVertex; // 트리 간선 추출을 위해
                    }
                }
            }
        }
        return previous; // 최소신장트리 간선 정보 리턴
    }

}
class EdgeForPrim{
    int adjvertex; // 간선의 양끝 정점들
    int weight;
    public EdgeForPrim(int u, int v, int wt){
        // 인접 정점
        adjvertex = v;
        // 가중치
        weight = wt;
    }
}