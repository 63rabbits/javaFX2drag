package javaFX2drag;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class DragController {

	@FXML
	private Circle circle;

	private double dragDeltaX;
	private double dragDeltaY;

	@FXML
	void initialize() {
		assert circle != null : "fx:id=\"circle\" was not injected: check your FXML file 'Drag.fxml'.";

		Tooltip.install(circle, new Tooltip("Drag me !!"));

		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				circle.setCursor(Cursor.HAND);
			}
		});

		circle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// record a delta distance for the drag and drop operation.
				dragDeltaX = circle.getLayoutX() - e.getSceneX();
				dragDeltaY = circle.getLayoutY() - e.getSceneY();
				circle.setCursor(Cursor.MOVE);
			}
		});

		circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {

				double sceneX = e.getSceneX();
				double sceneY = e.getSceneY();

				double sceneW = circle.getScene().getWidth();
				double sceneH = circle.getScene().getHeight();

				if (sceneX < 0) {
					circle.setLayoutX(dragDeltaX);
				}
				else if (sceneX > sceneW) {
					circle.setLayoutX(sceneW + dragDeltaX);
				}
				else {
					circle.setLayoutX(sceneX + dragDeltaX);
				}

				if (sceneY < 0) {
					circle.setLayoutY(dragDeltaX);
				}
				else if (sceneY > sceneH) {
					circle.setLayoutY(sceneH + dragDeltaY);
				}
				else {
					circle.setLayoutY(sceneY + dragDeltaY);
				}

				circle.setCursor(Cursor.MOVE);
			}
		});

		circle.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				circle.setCursor(Cursor.HAND);
			}
		});
	}
}
