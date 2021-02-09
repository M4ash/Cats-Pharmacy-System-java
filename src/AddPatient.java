import java.io.File;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddPatient extends Application {
	
	TextField tFullname = new TextField();
	TextField tAge = new TextField();
	TextField tDOB = new TextField();
	TextArea tDetail = new TextArea();
	TextField tPatID = new TextField();
	Button btAdd = new Button("  ADD  ");
	Button btCancel = new Button("CANCEL");
	
	
	fileWriter writer = new fileWriter();
	String checkPat, checkAge, checkID, checkDOB, checkDetail;
	
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
		
		grid.add(new Label(" ID  "), 0, 0);
		grid.add(new Label(" Fullname  "), 0, 1);
		grid.add(new Label(" Date of Birth  "), 0, 2);
		grid.add(new Label(" Age  "), 0, 3);
		grid.add(new Label(" Desease Detail  "), 0, 4);
		
		grid.add(tFullname,1,0);
		grid.add(tPatID,1,1);
		grid.add(tAge,1,2);
		grid.add(tDOB,1,3);
		grid.add(tDetail,1,4);
		tDetail.setPrefWidth(300);;
		
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
		    	checkPat = tFullname.getText().toString();
		    	checkAge = tAge.getText().toString();
		    	checkID = tPatID.getText().toString();
		    	checkDOB = tDOB.getText().toString();
		    	checkDetail = tDetail.getText().toString();
		    	writer.patientAdd(checkPat, checkAge, checkID, checkDOB, checkDetail);
		    	stage.close();
		    	PatientInfo patInfo = new PatientInfo();
		    	patInfo.start(primaryStage);
		    }
		    catch(Exception ex)
		    	{Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    
		Scene scene = new Scene(vBox,450,500);
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setTitle("Add Patient"); // Set the stage title
	    stage.setScene(scene);   // Set a scene with a button in the stage     
	    stage.show(); // Display the stage
		
	}
	public static void main(String[] args) {	
	    launch(args);
	  }
}