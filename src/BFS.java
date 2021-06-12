import java.util.PriorityQueue;

public class BFS {   // sorry teacher i tried my best to make it work but i just could not make by vertices
    // but at least i did this by myself
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        graph.bfs();
        System.out.println();
    }
    static class Queue{
        private final int Size = 20;
        private int[] queArr;
        private int front;
        private int rear;

        public Queue(){
            queArr = new int[Size];
            front = 0;
            rear = -1;
        }
        public void insert(int i) {
            if (rear == Size - 1)
                rear = -1;
            queArr[++rear] = i;
        }
        public int remove(){
            int temp = queArr[front++];
            if (front == Size)
                front=0;
            return temp;
        }
        public boolean isEmpty(){
            return (rear + 1 == front || (front+Size-1 == rear));
        }
    }
    static class Vertex{
        public char label;
        public boolean was;
        private double path;

        public Vertex(char l){
            label = l;
            was = false;
        }
    }
    static class Graph{
        private final int max_verts = 20;
        private Vertex vertexList[];
        private int adjMat[][];
        private int nVerts;
        private Queue theQueue;

        public Graph(){    //adjacency matrix
            vertexList = new Vertex[max_verts];
            adjMat = new int[max_verts][max_verts];
            nVerts = 0;

            for(int i = 0; i < max_verts; i++)
                for (int j = 0; j < max_verts; j++)
                    adjMat[i][j] = 0;
                theQueue = new Queue();
        }

        public void addVertex( char l){
            vertexList[nVerts++] = new Vertex(l);
        }
        public void addEdge(int s, int e){
            adjMat[s][e] = 1;
            adjMat[e][s] = 1;
        }
        public void displayVert(int v){
            System.out.print(vertexList[v].label);
        }


        //BREADTH FIRST SEARCH
        public void bfs(){
            vertexList[0].was = true;
            displayVert(0);
            theQueue.insert(0);
            int v2;

            while (!theQueue.isEmpty()){
                int v1 = theQueue.remove();
                while ((v2 = getUnvisited(v1)) != -1){
                    vertexList[v2].was = true;
                    displayVert(v2);
                    theQueue.insert(v2);
                }
            }
            for (int i = 0; i< nVerts; i++)
                vertexList[i].was = false;
        }
        public int getUnvisited(int v){
            for (int i = 0; i< nVerts; i++)
                if(adjMat[v][i] == 1 && vertexList[i].was == false)
                    return i;
                return -1;

            }
        }
        //so here we were supposed to use your part of code with vertex as an object
    //but it was impossible for me since i am using a vertex class already
        // and how can i just instead of edges which are in the vertex class, use vertices
     class Vertex implements Comparable<Vertex>{
        public final String name;
        public Edge[] adjacencies;
        public double path = Double.POSITIVE_INFINITY;
        public Vertex previous;
        public Vertex(String argName){
            name = argName;
        }
        public String toString(){
            return name;
        }
        public int compareTo(Vertex other){
            return Double.compare(path, other.double);
        }
     }

     class Edge{
        public final Vertex target;
        public final double weight;
        public Edge(Vertex artTarget, double argWeight){
            target = argTarget;
            weight = argWeight;
        }
     }

public class Dijkstra{
        public static void wayTo(Vertex source){
            source.path = 0;
            PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<Vertex>();
            vertexPriorityQueue.add(source);

            while(!vertexPriorityQueue.isEmpty()){
                Vertex v = vertexPriorityQueue.poll();
                for(Edge e : v.adjacencies){
                    Vertex v = e.target;
                    double weight = e.weight;
                    double way = v.path + weight;
                    if(way < new .path){
                        vertexPriorityQueue.remove(new);
                        new.path = way;
                        new.previous = v;
                        vertexPriorityQueue.add(new);
                    }
                }
            }
        }
        // and this is it
        //public static List<Vertex> shortest(Vertex target)
}
    }

