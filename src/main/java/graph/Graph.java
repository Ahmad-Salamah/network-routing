package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void addVertix(Vertex vertex){
        this.vertices.add(vertex);
    }


}
