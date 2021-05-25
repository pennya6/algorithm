//다익스트라 알고리즘 : 그래프에서 출발점에서 목표점까지의 최단거리 구하기
//두개의 변수 사용 - 최단거리 저장변수, 방문여부 체크 변수

//순서
// 1. 최단거리 초기화 (무한)
// 2. 시작노드의 최단거리, 방문여부 변경
// 3. 시작노드와 연결되어 있는 최단거리값 갱신
// 4. 방문하지 않은 노드중 최단거리가 최소인 값 찾기 -> check false인 아이들 중 최단 true로 변경
// 5. 최소인 노드 check값 true로 변경
 
public class Graph {
	private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
    	
        this.n = n;
        maps = new int[n+1][n+1];
         
    }
    public void input(int i, int j, int w){
    	//int w2=Integer.parseInt(w);
        maps[i][j] = w;
        maps[j][i] = w;
    }
 
    public void dijkstra(int v){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i]=16; //16은 무한대
        	//distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=16;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=16){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}
