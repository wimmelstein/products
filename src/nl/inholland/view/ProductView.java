package nl.inholland.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nl.inholland.model.Product;

public class ProductView {
	
	public static void addProduct(ObservableList<Product> products) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.WINDOW_MODAL);
		
		Label nameLabel, stockLabel, priceLabel;
		TextField nameInput, stockInput, priceInput;
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(8);
		
		nameLabel = new Label("Name");
		stockLabel = new Label("In stock");
		priceLabel = new Label("Price");
		
		GridPane.setConstraints(nameLabel, 0, 0);
		GridPane.setConstraints(stockLabel, 0, 1);
		GridPane.setConstraints(priceLabel, 0, 2);
		
		
		nameInput = new TextField();
		stockInput = new TextField();
		priceInput = new TextField();
		
		GridPane.setConstraints(nameInput, 1, 0);
		GridPane.setConstraints(stockInput, 1, 1);
		GridPane.setConstraints(priceInput, 1, 2);
		
		Button addButton = new Button("Add");
		
		addButton.setOnAction(event -> {
			Product product = new Product(nameInput.getText(), 
					Integer.parseInt(stockInput.getText()), 
					Double.parseDouble(priceInput.getText()));
			products.add(product);
			window.close();
		});
		GridPane.setConstraints(addButton, 1, 3);
		
		gridPane.setPadding(new Insets(10));
		
		gridPane.getChildren().addAll(nameLabel, nameInput, stockLabel, stockInput, priceLabel, priceInput, addButton);
		
		Scene scene = new Scene(gridPane, 300, 300);
		window.setScene(scene);
		window.show();
		
		
		
	}

}
