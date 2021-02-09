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

public class RemoveUser extends Application {
	
	TextField tUsername = new TextField();
	PasswordField tPass = new PasswordField();
	Button DelUser2 = new Button("  REMOVE  ");
	Button btCancel = new Button("CANCEL");
	Button btOk = new Button("OK");
	String filepath = "staffs.txt";
	boolean found = false;
	private static Scanner y;
	String checkUser, checkPwd;
	
	
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		DelUser2.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		btCancel.setStyle("-fx-background-color: #2A8CCD;-fx-text-fill: White;-fx-font-size: 1.2em;");
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		Image image = new Image(new File("img\\orig2.gif").toURI().toString(),200,211, false, false);
	    pane.getChildren();
	    pane.setStyle("-fx-background-color: #EBF7FF");
	    
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
	    DelUser2.setPrefWidth(100); //button size
	    btCancel.setPrefWidth(100);
	    hBox.getChildren().addAll(DelUser2,btCancel); 
	    
		pane.add(new ImageView(image),0,0);
		pane.add(new Label(" NAME "), 0, 1);
		tUsername.setPromptText("Username");
		pane.add(tUsername,0,2);
		pane.add(new Label("  PASSWORD "),0,3);
		tPass.setPromptText("Password");
		pane.add(tPass,0,4);
		pane.add(hBox,0,6);
		pane.setVgap(12);
		pane.setAlignment(Pos.CENTER);
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setTop(pane);
	    BorderPane.setAlignment(pane, Pos.CENTER);
	   
	    
	    DelUser2.setOnAction(e ->{
	    	try{ 
		    	String[] temp = new String[200];
	    		checkUser = tUsername.getText().toString();
	    		checkPwd = tPass.getText().toString();
	    		
	    		
	    		y = new Scanner(new File(filepath));
	    		y.useDelimiter("[,\n]");
	    		
	    		int x=-1;
	    		while(y.hasNext()) {
	    			x++;
	    			temp[x] = y.next();
	    			x++;
	    			temp[x] = y.next();
	    			
	    			
	    			if(temp[x-1].trim().equals(checkUser.trim()) && temp[x].trim().equals(checkPwd.trim())) {
	    				found = true;
	    				temp[x-1] = null;
	    				temp[x] = null;
	    				//Dialogue Box
	    				btOk.setPrefWidth(115);
	    				GridPane ok = new GridPane();
	    				ok.setAlignment(Pos.CENTER);
	    				ok.add(btOk, 1, 0);
	    				GridPane newWindowPane = new GridPane();
	    				Label l = new Label("User is Removed! ");
	    				l.setStyle("-fx-text-fill: Red;-fx-font-size: 1.2em;-fx-font-weight: bold");
	                    newWindowPane.add(l,0,0);
	                    newWindowPane.add(btOk,0,1);
	                    newWindowPane.setAlignment(Pos.CENTER);
	                    newWindowPane.setVgap(8);
	                    Scene newWindowScene = new Scene(newWindowPane, 390, 90);
	                    Stage newWindowStage = new Stage();
	                    newWindowStage.setTitle(" ");
	                    newWindowStage.setScene(newWindowScene);
	                    newWindowStage.show();
	                    btOk.setOnAction((event) -> {
	                        newWindowStage.close();
	                        Login toLogin=new Login();
	                        toLogin.start(primaryStage);
	                });
	                    
	                   
	    			}
	    		
	    			
	    	}
	    			
	    			
	    			
					   	
	    			
	    			
	    			
	    		
	    		y.close();   
	    		
	    		java.io.File file = new java.io.File("staffs.txt");
			    // Create a file
			    java.io.PrintWriter output = new java.io.PrintWriter(file);
    			for(int i = 0; i <= x ; i++) {
    				if(i == x) {
    					output.print(temp[i]);
    				}
    				else {
    					output.println(temp[i]);
    				}
    				
    			}
				
	    		output.close();

				   
		    		
    			
    			
	    		if(!found) {
    				pane.add(new Label("ERROR! Try Again..."), 0, 5);
    			}
	    		
	    		
	    		
	    }
	    catch(Exception ex) 
	    	{Logger.getLogger(Login.class.getName()).log(null);}
	    });
	    
	    
	    btCancel.setOnAction(e ->{
	    	try{ 
	    		Login toLogin=new Login();toLogin.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    
		Scene scene = new Scene(borderPane,390,560);
		primaryStage.setTitle("REMOVE USER");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		}
	}