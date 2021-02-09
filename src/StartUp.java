import java.io.File;
import java.util.logging.Logger;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartUp extends Application {
	Label wlcm = new Label(" Welcome"); 
	Button btLogin = new Button("  LOGIN ");
	Button btNewStaff = new Button("SIGN UP");
	
	public void start(Stage primaryStage) {
		
		wlcm.setStyle("-fx-text-fill: grey;-fx-font-size: 3.2em;");
		GridPane pane = new GridPane();
		pane.add(btLogin, 1, 0);
		pane.add(btNewStaff,1 , 1);
		pane.add(wlcm,1 , 3);
		pane.setAlignment(Pos.BOTTOM_CENTER);
		btLogin.setPrefWidth(180); //button size
		btNewStaff.setPrefWidth(180);
		
		
		
		btLogin.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btNewStaff.setStyle("-fx-text-fill: White;-fx-background-color: #2A8CCD;-fx-font-size: 1.2em; ");
		
		
		
	    pane.setVgap(15);
		
		GridPane pane1 = new GridPane();
		Image image = new Image(new File("img\\labun.png").toURI().toString(),180,180, false, false);
	    pane1.getChildren().addAll(new ImageView(image));
	    pane1.setAlignment(Pos.CENTER);
	    
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(pane1);
	    borderPane.setBottom(pane);
	    BorderPane.setAlignment(pane1, Pos.CENTER);
	    
	    pane1.setStyle("-fx-background-color: #EBF7FF");
	    
	    
	    //Process events
	    btLogin.setOnAction(e ->{try{ Login toLogin=new Login();toLogin.start(primaryStage); //back to start page
	    }
	    catch(Exception ex){Logger.getLogger(StartUp.class.getName()).log(null);}
	    });	
	    btNewStaff.setOnAction(e ->{try{ NewStaffReg toNewStaffReg=new NewStaffReg();toNewStaffReg.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    
	    Scene scene = new Scene(borderPane,390,560);
	    
		primaryStage.setTitle("CATS PHARMACY SYSTEM"); // Set the stage title
		primaryStage.setScene(scene);// Place the scene in the stage
		primaryStage.show();
	    
	}
	
	
	public static void main(String[] args) {
		
	    launch(args);
	  }
}