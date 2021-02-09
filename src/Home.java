import java.io.File;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Application{
	
	Button btPatient = new Button(" CATS");
	Button btMed = new Button("MEDICINE");
	Button btLogout = new Button("  LOGOUT  ");
	
	
	public void start(Stage primaryStage) {
		
		btPatient.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btMed.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btLogout.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		
		Image image = new Image(new File("img\\labun.png").toURI().toString(),90,90, false, false);
		Image imagePat = new Image(new File("img\\orig.gif").toURI().toString(),200,350, false, false);
		
	    FlowPane forImage=new FlowPane();
	    Label title = new Label("  CATS PHARMACY SYSTEM");
	    title.setStyle("-fx-text-fill: White;-fx-font-size: 1.2em;-fx-font-weight: bold;");
	    
		forImage.getChildren().addAll(new ImageView(image),title);
		forImage.setStyle("-fx-background-color: #2A8CCD");
	    
	    GridPane pane = new GridPane();
		pane.setHgap(80);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: #EBF7FF");
		pane.getChildren().add(new ImageView(imagePat));
		
		
		Pane spacer = new Pane();
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setStyle("-fx-background-color: #666666");
		btPatient.setPrefWidth(150);
		btMed.setPrefWidth(150);
		btLogout.setPrefWidth(150);
		vBox.getChildren().addAll(spacer,btPatient,btMed,btLogout);
		
		BorderPane borderPane = new BorderPane();
	    borderPane.setTop(forImage);
	    borderPane.setLeft(vBox);
	    borderPane.setCenter(pane);
	    BorderPane.setAlignment(forImage,Pos.CENTER_LEFT);	
	    
	    btLogout.setOnAction(e ->{
	    	try{ Login toLogin=new Login();toLogin.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    btMed.setOnAction(e ->{
	    	try{ Medicine toMedicine=new Medicine();toMedicine.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    btPatient.setOnAction(e ->{try{ PatientInfo toPatientInfo=new PatientInfo();toPatientInfo.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    
	    Scene scene = new Scene(borderPane,700,500);
		primaryStage.setTitle("CATS PHARMACY SYSTEM");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {	
	    launch(args);
	  }
}