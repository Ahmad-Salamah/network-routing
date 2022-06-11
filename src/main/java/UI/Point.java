package UI;

import graph.Vertex;
import javafx.scene.shape.Circle;

public class Point extends Circle {

    private Vertex vertex;

    public Vertex getVertex() {
        return vertex;
    }

    public Point(Vertex vertex) {
        super(vertex.getX() + 3, vertex.getY() + 3, 3);
        this.vertex = vertex;
    }
}
