import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;
//import javafx.scene.text.*;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application {
	
	TextField tUsername = new TextField();
	PasswordField tPass = new PasswordField();
	Button btLogin = new Button("  LOGIN  ");
	Button btStaff = new Button("SIGN UP");
	Button btCancel = new Button("EXIT");
	Button DelUser = new Button("Want to delete user? Click here...");
	String filepath = "staffs.txt";
	boolean found = false;
	private static Scanner x;
	String checkUser, checkPwd;
	
	
	
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		btLogin.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btStaff.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btCancel.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		Image image = new Image(new File("img\\Animated-Kitty-Drawing.gif").toURI().toString(),150,150, false, false);
	    pane.getChildren();
	    pane.setStyle("-fx-background-color: #EBF7FF");
	    
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    btStaff.setPrefWidth(100);
	    btLogin.setPrefWidth(100); //button size
	    btCancel.setPrefWidth(100);
	    hBox.getChildren().addAll(btLogin,btStaff,btCancel); 
	    
	   	DelUser.setStyle("-fx-background-color: #EBF7FF;-fx-text-fill: Blue;-fx-font-size: 1.2em;-fx-underline: true;");
		pane.add(new ImageView(image),0,0);
		pane.add(new Label(" USERNAME "), 0, 1);
		tUsername.setPromptText("Username");
		pane.add(tUsername,0,2);
		pane.add(new Label("  PASSWORD "),0,3);
		tPass.setPromptText("Password");
		pane.add(tPass,0,4);
		pane.add(hBox,0,6);
		pane.add(DelUser,0,7);
		pane.setVgap(12);
		pane.setAlignment(Pos.CENTER);
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setTop(pane);
	    BorderPane.setAlignment(pane, Pos.CENTER);
	   
	    
	    btLogin.setOnAction(e ->{
	    	try{ 
		    		checkUser = tUsername.getText().toString();
		    		checkPwd = tPass.getText().toString();
		    		String tempUser;
		    		String tempPass;
		    		
		    		x = new Scanner(new File(filepath));
		    		x.useDelimiter("[,\n]");
		    		
		    		while(x.hasNext() && !found) {
		    			tempUser = x.next();
		    			tempPass = x.next();
		    			
		    			if(tempUser.trim().equals(checkUser.trim()) && tempPass.trim().equals(checkPwd.trim())) {
		    				found = true;
		    				Home toHomeInfo=new Home();
				    		toHomeInfo.start(primaryStage);
		    			}
		    			
		    		}
		    		if(!found) {
	    				pane.add(new Label("Wrong Password! Try Again..."), 0, 5);
	    			}
		    		
		    		
	    }
	    catch(Exception ex)
	    	{Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    
	    DelUser.setOnAction(e-> {
	    	RemoveUser r=new RemoveUser();
	    	r.start(primaryStage);
	    });
	    
	    btStaff.setOnAction(e ->{
	    	try{ 
	    		NewStaffReg toNewStaff=new NewStaffReg();
	    		toNewStaff.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    
	    btCancel.setOnAction(e ->{
	    	try{ 
	    		System.exit(0);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
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