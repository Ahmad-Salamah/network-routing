package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UI.Point;
import UI.PointClickHandler;
import graph.Graph;
import graph.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Controller {
    public static TextField source;
    public static TextField target;

    public static Point sourcePoint;
    public static Point destinationPoint;

    private Graph graph;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane NetworkPane;

    @FXML
    private TextField SeedTF;

    @FXML
    private TextField SizeTF;

    @FXML
    private Button GenerateBtn;

    @FXML
    private TextField SourceNodeTF;

    @FXML
    private TextField TargetNodeTF;

    @FXML
    private Button ComputeCostBtn;

    @FXML
    private TextField TotalPathCostTF;

    @FXML
    void ComputeCost(ActionEvent event) {

    }

    @FXML
    void Generate(ActionEvent event) {
        NetworkPane.getChildren().clear();

        //get seed and size from the GUI
        int seed = Integer.parseInt(SeedTF.getText());
        int size = Integer.parseInt(SizeTF.getText());

        PointClickHandler pointClickHandler = new PointClickHandler();

        //make the graph
        graph = new Graph(seed, size, pointClickHandler);

        //Add all points in the graph to the UI
        for (int i = 0; i < size; i++) {
            Point point = graph.getVertices().get(i).getPoint();
            NetworkPane.getChildren().add(point);
        }


    }

        //make three adjacent for every vertex
        for (int i = 0; i < size; i++) {
            Vertex vertex = graph.getVertices().get(i);
            for (int j = 0; j < 3; j++) {
                List<Integer> adjacent = new ArrayList<>();
                int edgeIndex = random.nextInt(size);
                //make sure the destination vertix is not the same as the source
                //make sure it does not repeat the same adjacent twice
                while (edgeIndex == i || adjacent.contains(edgeIndex)) {
                    edgeIndex = random.nextInt(size);
                }
                adjacent.add(edgeIndex);
                vertex.addEdge(graph.getVertices().get(edgeIndex));
            }
        }
    }

    @FXML
    void setSourceNode(ActionEvent event) {
        Point point = graph.getVertices().get(Integer.parseInt(SourceNodeTF.getText())).getPoint();
        point.setAsSource();

    }

    @FXML
    void setTargetNode(ActionEvent event) {
        Point point = graph.getVertices().get(Integer.parseInt(TargetNodeTF.getText())).getPoint();
        point.setAsTarget();
    }

    @FXML
    void initialize() {
        assert NetworkPane != null : "fx:id=\"NetworkPane\" was not injected: check your FXML file 'main.fxml'.";
        assert SeedTF != null : "fx:id=\"SeedTF\" was not injected: check your FXML file 'main.fxml'.";
        assert SizeTF != null : "fx:id=\"SizeTF\" was not injected: check your FXML file 'main.fxml'.";
        assert GenerateBtn != null : "fx:id=\"GenerateBtn\" was not injected: check your FXML file 'main.fxml'.";
        assert SourceNodeTF != null : "fx:id=\"SourceNodeTF\" was not injected: check your FXML file 'main.fxml'.";
        assert TargetNodeTF != null : "fx:id=\"TargetNodeTF\" was not injected: check your FXML file 'main.fxml'.";
        assert ComputeCostBtn != null : "fx:id=\"ComputeCostBtn\" was not injected: check your FXML file 'main.fxml'.";
        assert TotalPathCostTF != null : "fx:id=\"TotalPathCostTF\" was not injected: check your FXML file 'main.fxml'.";

        target = TargetNodeTF;
        source = SourceNodeTF;
    }
}
