import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewStaffReg extends Application{
	public static String username;
	public static String pass;
	TextField tFullname = new TextField();
	TextField tEmail = new TextField();
	PasswordField tPass = new PasswordField();
	TextField tStaffNo = new TextField();
	TextField tMobNo = new TextField();
	Button btOkay = new Button("  OKAY  ");
	Button btCancel = new Button("CANCEL");
	
	
	fileWriter writer = new fileWriter();
	String checkFullname, checkEmail, checkPass, checkStaffNo, checkMobNo;
	
	public void start(Stage primaryStage) {
		
		Image image = new Image(new File("img\\catgiff.gif").toURI().toString(),190,190, false, false);
		btOkay.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btCancel.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    btOkay.setPrefWidth(100); //button size
		btCancel.setPrefWidth(100);
	    hBox.getChildren().addAll(btOkay,btCancel);
	    
	    GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("USERNAME :"), 0, 1);
		pane.add(tFullname,1,1);
		pane.add(new Label("EMAIL :"),0,2);
		pane.add(tEmail,1,2);
		pane.add(new Label("PASSWORD :"),0,3);
		pane.add(tPass,1,3);
		pane.add(new Label("STAFF NO :"),0,4);
		pane.add(tStaffNo,1,4);
		pane.add(new Label("MOBILE PHONE :"),0,5);
		pane.add(tMobNo,1,5);
		pane.setAlignment(Pos.CENTER);
		
		VBox vBox= new VBox();
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(new ImageView(image));
		vBox.getChildren().addAll(pane,hBox);
		vBox.setStyle("-fx-background-color: #EBF7FF");
		
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(vBox);
	    BorderPane.setAlignment(vBox, Pos.CENTER);
	    
	    btOkay.setOnAction(e ->{
	    	try
	    	{ 
	    		checkFullname = tFullname.getText().toString();
	    		checkEmail = tEmail.getText().toString();
	    		checkPass = tPass.getText().toString();
	    		checkStaffNo = tStaffNo.getText().toString();
	    		checkMobNo = tMobNo.getText().toString();
		    	writer.staffAdd(checkFullname, checkEmail, checkPass, checkStaffNo, checkMobNo);
		    	Login loginPage = new Login();
		    	loginPage.start(primaryStage);
		    }
		    catch(Exception ex)
		    	{Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    btCancel.setOnAction(e ->{try{ Login toLogin=new Login();toLogin.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(NewStaffReg.class.getName()).log(null);}
	    });	
	    
		Scene scene = new Scene(borderPane,390,560);
		primaryStage.setTitle("CATS PHARMACY SYSTEM");
		primaryStage.setScene(scene);
		primaryStage.show();
	    
	}
	
	public static void main(String[] args) {	
	    launch(args);
	  }

}