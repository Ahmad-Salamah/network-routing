package UI;

import controller.Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static controller.Controller.destinationPoint;
import static controller.Controller.sourcePoint;

public class PointClickHandler implements EventHandler<MouseEvent> {
    Boolean source = true;



    @Override
    public void handle(MouseEvent event) {
        Point point = (Point) event.getSource();
        if(source) {
            if(sourcePoint != null){
                sourcePoint.setFill(Color.BLACK);
            }
            sourcePoint = point;
            point.setFill(Color.GREEN);
            Controller.source.setText(point.getVertex().getIndex()+"");

        }
        else {
            if(destinationPoint != null){
                destinationPoint.setFill(Color.BLACK);
            }
            destinationPoint = point;
            point.setFill(Color.RED);
            Controller.target.setText(point.getVertex().getIndex()+"");
        }
        source = !source;
    }
}
