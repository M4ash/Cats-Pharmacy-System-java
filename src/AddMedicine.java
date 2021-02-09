import java.io.File;
//import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMedicine extends Application{

	
	TextField tMedId = new TextField();
	TextField tMedName = new TextField();
	TextField tUnitPrice = new TextField();
	TextField tSalePrice = new TextField();
	TextField tQuantity = new TextField();
	TextField tPurDate = new TextField();
	fileWriter writer = new fileWriter();
	String checkMedID, checkMedName, checkUnitPrice, checkSalePrice, checkQuantity, checkPurDate;
	Button btAdd = new Button("  ADD  ");
	Button btCancel = new Button("CANCEL");
	

	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void display(Stage primaryStage) {
		// TODO Auto-generated method stub
		Stage stage=new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		
		grid.add(new Label(" Medicine ID :"), 0, 0);
		grid.add(new Label(" Medicine Name : "), 0, 1);
		grid.add(new Label(" Unit Price :"), 0, 2);
		grid.add(new Label(" Sale Price :"), 0, 3);
		grid.add(new Label(" Quantity :"), 0, 4);
		grid.add(new Label(" Purchase Date :"), 0, 5);
		
		grid.add(tMedId,1,0);
		grid.add(tMedName,1,1);
		grid.add(tUnitPrice,1,2);
		grid.add(tSalePrice,1,3);
		grid.add(tQuantity,1,4);
		grid.add(tPurDate,1,5);
		
		HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    btAdd.setPrefWidth(100); //button size
	    btCancel.setPrefWidth(100);
	    hBox.getChildren().addAll(btAdd,btCancel);
		
		VBox vBox= new VBox();
	    vBox.setSpacing(15);
	    vBox.setAlignment(Pos.CENTER);
	    vBox.setStyle("-fx-background-color: #2A8CCD");
	    
	    vBox.getChildren().addAll(grid,hBox);
		
	    btCancel.setOnAction(e ->stage.close());
	    btAdd.setOnAction(e ->{
	    	try
	    	{ 
		    	checkMedID = tMedId.getText().toString();
		    	checkMedName = tMedName.getText().toString();
		    	checkUnitPrice = tUnitPrice.getText().toString();
		    	checkSalePrice = tSalePrice.getText().toString();
		    	checkQuantity = tQuantity.getText().toString();
		    	checkPurDate = tPurDate.getText().toString();
		    	writer.medicineAdd(checkMedID, checkMedName, checkUnitPrice, checkSalePrice, checkQuantity, checkPurDate);
		    	stage.close();
		    	Medicine meds = new Medicine();meds.start(primaryStage);
		    }
		    catch(Exception ex)
		    	{Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    
		Scene scene = new Scene(vBox,450,450);
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setTitle("Add Medicine"); // Set the stage title
	    stage.setScene(scene);   // Set a scene with a button in the stage     
	    stage.show(); // Display the stage
		
	}
	
	public static void main(String[] args) {	
	    launch(args);
	  }
	
}