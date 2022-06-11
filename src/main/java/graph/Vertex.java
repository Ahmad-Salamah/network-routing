package graph;

import UI.Point;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int x;
    private int y;
    private List<Edge> adjacent;

    private Point point;

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        adjacent = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Edge> getAdj() {
        return adjacent;
    }

    public void addEdge(Vertex adj){
        Edge edge = new Edge(this , adj);
        this.adjacent.add(edge);
    }
}
