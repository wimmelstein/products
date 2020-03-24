package nl.inholland;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import nl.inholland.model.Product;
import nl.inholland.view.ProductView;

public class SampleFX extends Application {

	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage window) throws Exception {
		
	
		VBox box = new VBox();
		box.setPadding(new Insets(10));
		
		ObservableList<Product> products = FXCollections.observableArrayList();
		TableView<Product> productTable = new TableView<Product>();
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumn.setPrefWidth(150);
		
		TableColumn<Product, Integer> stockColumn = new TableColumn<>("In stock");
		stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
		stockColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		stockColumn.setPrefWidth(75);
		
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		priceColumn.setPrefWidth(75);
		
		productTable.getColumns().addAll(nameColumn, stockColumn, priceColumn);
		productTable.setItems(products);
		products.add(new Product("Fender Telecaster", 25, 795.00));
		
		Button newButton = new Button("New...");
		newButton.setAlignment(Pos.BASELINE_RIGHT);
		newButton.setOnAction(event -> {
			ProductView.addProduct(products);
		});
		box.getChildren().addAll(productTable, newButton);
		Scene scene = new Scene(box, 320, 350);
		
		window.setScene(scene);
		window.show();


	}

	public static void main(String[] args) {
		launch();

	}

}
