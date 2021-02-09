import java.io.*;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
//import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class PatientInfo extends Application {
	
	Button btDashboard = new Button(" < BACK TO HOME  ");
	Button btUp2Patient = new Button("ADD PATIENT CAT");
	Button btMed = new Button("MEDICINE");
	Button btDel = new Button("DELETE");
	Button btUp = new Button("CHANGE/MODIFY");
	Button btClr = new Button("CLEAR ALL");
	Button btSearch = new Button(" ID SEARCH  ");
	TextField tSearch = new TextField();
	TextField tf1 = new TextField();
	Button btUp2 = new Button("  UPDATE  ");
	Button btCancel = new Button("CANCEL");
	fileWriter writer = new fileWriter();

	
	private int selectedIndex = -1;
	String[] line = new String[200];
	int count = 0;
	
	public void start(Stage primaryStage) {
	
		
		List<String> lines = new ArrayList<String>();
        try (Scanner br = new Scanner(new File("patients.txt")))
        {
            while (br.hasNext()) {
            	line[count] = br.nextLine();
                lines.add(line[count]);
                count++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        ListView<String> listView = new ListView<String>();
        listView.setItems(FXCollections.observableList(lines));
		
		Pane spacer = new Pane();
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.TOP_CENTER);
	    tSearch.setPrefWidth(300);
	    tSearch.setPromptText("Search by ID...");
	    btSearch.setPrefWidth(100); //button size
	    hBox.getChildren().addAll(tSearch,btSearch);
	
		
		
		
		VBox vBoxMenu= new VBox();
		vBoxMenu.setSpacing(11);
		vBoxMenu.setAlignment(Pos.TOP_CENTER);
		vBoxMenu.setStyle("-fx-background-color: #2A8CCD");
		btDashboard.setPrefWidth(200); //button size
		btMed.setPrefWidth(200);
		btUp2Patient.setPrefWidth(200);
		btDel.setPrefWidth(200);
		btUp.setPrefWidth(200);
		btClr.setPrefWidth(200);
		vBoxMenu.getChildren().addAll(btDashboard,btMed,btUp2Patient,btDel,btUp,btClr);
		
		VBox vBox= new VBox();
		vBox.setSpacing(15);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(spacer,hBox,listView);
		vBox.setStyle("-fx-background-color: #EBF7FF");
		
		//set selected item
		listView.setOnMouseClicked(event -> {
			String selectItem = listView.getSelectionModel().getSelectedItem().toString();
			selectedIndex = listView.getSelectionModel().getSelectedIndex();
			
		});
	
		btDel.setOnAction(e -> {
			
			listView.getItems().remove(selectedIndex);
			try (PrintWriter out = new PrintWriter("patients.txt")) {
				int i;
				for( i=0; i < count; i++) {
					if(i != selectedIndex) {
						if(selectedIndex == count-1) {
							count = count-1;
						}
						if(i != count-1) {
							out.println(line[i]);
						}
						else if (i == count-1) {
							out.print(line[i]);
						}
						
						System.out.println(line[i]);
					}
				}
			
				count = count -1;
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		
		
		btUp.setOnAction(event ->{
			//Appears new window
			
			Stage stage2=new Stage();
			GridPane label = new GridPane();
			Label l = new Label("\t\t\t\t\tModify");
			l.setStyle("-fx-text-fill: White;-fx-font-size: 1.7em;");
			label.add(l, 1, 0);
			label.setAlignment(Pos.TOP_CENTER);
			
			GridPane grid=new GridPane();
			grid.add(l, 1,0) ;
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(10);
			grid.add(tf1,1,1);
			tf1.setPrefWidth(540);
			tf1.setPrefHeight(37);
			
			HBox hBox2 = new HBox();
		    hBox2.setSpacing(10);
		    hBox2.setAlignment(Pos.CENTER);
		    btUp2.setPrefWidth(100); //button size
		    btCancel.setPrefWidth(100);
		    hBox2.getChildren().addAll(btUp2,btCancel);
			
			VBox vBox2= new VBox();
		    vBox2.setSpacing(15);
		    vBox2.setAlignment(Pos.CENTER);
		    vBox2.setStyle("-fx-background-color: #2A8CCD");
		    vBox2.getChildren().addAll(grid,hBox2);
		    btCancel.setOnAction(event2 ->stage2.close());
		    Scene scene2 = new Scene(vBox2,520,250);
		    stage2.setTitle("Change/Modify"); // Set the stage title
		    stage2.setScene(scene2);   // Set a scene with a button in the stage     
		    stage2.show();
		    
		    
		    String selectItem = listView.getSelectionModel().getSelectedItem().toString();
			selectedIndex = listView.getSelectionModel().getSelectedIndex();
			tf1.setText(selectItem);
			
			btUp2.setOnAction(event2 -> {
				listView.getItems().remove(selectedIndex);
				listView.getItems().add(selectedIndex,tf1.getText());
				try (PrintWriter out = new PrintWriter("patients.txt")) {
					int i;
					for( i=0; i < count; i++) {
						
						if(i == selectedIndex) {
							
							out.println(tf1.getText());
							
						}
						
						if(i != selectedIndex) {
							
							if(i != count-1) {
								out.println(line[i]);
							}
							else if (i == count-1) {
								out.print(line[i]);
								
							}		
							
						}
						
					}
					
					count = count -1;
					stage2.close();
				
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
		
		
		
		btClr.setOnAction(event -> {
			for(int k=0; k < count; k++) {
				listView.getItems().remove(line[k]);
			}
			try (PrintWriter out = new PrintWriter("patients.txt")) {
				
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		
		//Search Button
		btSearch.setOnAction(event -> {
			if(tSearch.getText().isEmpty()) {
				PatientInfo toPatientInfo=new PatientInfo();
				toPatientInfo.start(primaryStage);
			}
			else { 
				String id = tSearch.getText();
				for(int j=0; j < count; j++) {
					if(id.charAt(0) == line[j].charAt(0) && id.charAt(1) == line[j].charAt(1) && id.charAt(2) == line[j].charAt(2)) {
						for(int k=0; k < count ; k++) {
							listView.getItems().remove(line[k]);
						}
						listView.getItems().add(line[j]);
						listView.getSelectionModel().select(0);
					}
				
				}
			}
		});
		
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(vBox);
	    
	    borderPane.setLeft(vBoxMenu);
	    BorderPane.setAlignment(vBoxMenu, Pos.CENTER);
	    BorderPane.setAlignment(vBox, Pos.TOP_CENTER);
	    
	    btUp2Patient.setOnAction(e ->{AddPatient pop=new AddPatient();
	    pop.display(primaryStage);});
	    btMed.setOnAction(e ->{try{ Medicine toMedicine=new Medicine();toMedicine.start(primaryStage);
	    }
	    catch(Exception ex){Logger.getLogger(Login.class.getName()).log(null);}
	    });	
	    btDashboard.setOnAction(e ->{try{ Home toHomeInfo=new Home();toHomeInfo.start(primaryStage);
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