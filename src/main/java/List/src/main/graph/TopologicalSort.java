package List.src.main.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
    int N; // 그래프의 정점 수
    boolean[] visited; // DFS 수행 중 방문여부 체크 용
    List<Integer>[] adjList; // 인접리스트 형태의 입력 그래프
    List<Integer> sequence; // 위상정렬 순서를 담을 리스트
    public TopologicalSort(List<Integer>[] graph){
        N = graph.length;
        visited = new boolean[N];
        adjList = graph;
        sequence = new ArrayList<>();
    }

    public List<Integer> tsort(){
        for(int i = 0; i < N; i++) {
            if(!visited[i]) dfs(i);
            Collections.reverse(sequence); // sequence 를 역순으로 만들기
        }
        return sequence;
    }

    public void dfs(int i) {
        visited[i] = true;
        for(int v : adjList[i]){ // i의 방문이 끝나고 앞으로 방문해야하는 각 정점 v에 대해
            if(!visited[v]) dfs(v);
        }
        sequence.add(i); // i에서 진출하는 간선이 더 이상 없으므로 i를 sequence 에 추가
    }

}
