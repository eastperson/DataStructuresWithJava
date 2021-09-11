package List.src.main.graph;

import java.util.LinkedList;
import java.util.List;

//public class EdgeTest{
//    public static void main(String[] args) {
//        int N = 3;
//        List<Edge>[] adjList = new List[N];
//        for(int i = 0; i < N; i++){
//            adjList[i] = new LinkedList<>();
//            for(int j = 0; j < N; j++) {
//                if(/*정점 i와 j사이에 간선이 존재하면*/){
//                    Edge e = new Edge(j);
//                    adjList[i].add(e);
//                }
//            }
//        }
//    }
//}

class Edge {
    int adjvertex; // 간선의 다른쪽 정점
    public Edge(int v) { // 생성자
        adjvertex = v;
    }
}
