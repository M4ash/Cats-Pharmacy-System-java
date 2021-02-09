import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Medicine extends Application {
	
	Button btDashboard = new Button(" < BACK TO HOME  ");
	Button btAddMed = new Button("ADD MEDICINE");
	Button btPat = new Button("  PATIENT  ");
	Button btSearch = new Button(" ID SEARCH  ");
	Button btDelt = new Button("DELETE");
	Button btUp = new Button("CHANGE/MODIFY");
	Button btClr = new Button("CLEAR ALL");
	TextField tSearch = new TextField();
	TextField tf1 = new TextField();
	Button btUp2 = new Button("  UPDATE  ");
	Button btCancel = new Button("CANCEL");
	fileWriter writer = new fileWriter();

	
	private int selectedIndex = -1;
	String[] line = new String[50];
	int count = 0;
	
	public void start(Stage primaryStage) {
		
		List<String> lines = new ArrayList<String>();
        try (Scanner br = new Scanner(new File("medicines.txt")))
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
        
		VBox vBoxMenu= new VBox();
		vBoxMenu.setSpacing(10);
		vBoxMenu.setAlignment(Pos.TOP_CENTER);
		vBoxMenu.setStyle("-fx-background-color: #2A8CCD");
		btDashboard.setPrefWidth(200); //button size
		btAddMed.setPrefWidth(200);
		btPat.setPrefWidth(200);
		btDelt.setPrefWidth(200);
		btUp.setPrefWidth(200);
		btClr.setPrefWidth(200);
		vBoxMenu.getChildren().addAll(btDashboard,btPat,btAddMed,btDelt,btUp,btClr);
	    
		Pane spacer = new Pane();
	    HBox hBox = new HBox();
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.TOP_CENTER);
	    tSearch.setPrefWidth(300);
	    tSearch.setPromptText("Search by ID...");
	    btSearch.setPrefWidth(100); //button size
	    hBox.getChildren().addAll(tSearch,btSearch);
		
	    VBox vBoxCenter= new VBox();
	    vBoxCenter.setSpacing(15);
	    vBoxCenter.setAlignment(Pos.TOP_CENTER);
	    vBoxCenter.setStyle("-fx-background-color: #EBF7FF");
	    vBoxCenter.getChildren().addAll(spacer,hBox, listView);
	    
	     
	   
				listView.setOnMouseClicked(event -> {
					String selectItem = listView.getSelectionModel().getSelectedItem().toString();
					selectedIndex = listView.getSelectionModel().getSelectedIndex();
					
				});
			
				btDelt.setOnAction(e -> {
					
					listView.getItems().remove(selectedIndex);
					try (PrintWriter out = new PrintWriter("medicines.txt")) {
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
					Stage stage3=new Stage();
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
				    btCancel.setOnAction(event2 ->stage3.close());
				    Scene scene2 = new Scene(vBox2,520,250);
				    stage3.setTitle("Change/Modify"); // Set the stage title
				    stage3.setScene(scene2);   // Set a scene with a button in the stage     
				    stage3.show();
				    
				    String selectItem = listView.getSelectionModel().getSelectedItem().toString();
					selectedIndex = listView.getSelectionModel().getSelectedIndex();
					tf1.setText(selectItem);
					
					btUp2.setOnAction(event2 -> {
						listView.getItems().remove(selectedIndex);
						listView.getItems().add(selectedIndex,tf1.getText());
						try (PrintWriter out = new PrintWriter("medicines.txt")) {
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
							stage3.close();
						
							
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
					try (PrintWriter out = new PrintWriter("medicines.txt")) {
						
					}
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				//Search button
				btSearch.setOnAction(event -> {
					if(tSearch.getText().isEmpty()) {
						Medicine toMedicine=new Medicine();
						toMedicine.start(primaryStage);
					}
					else { 
						String id = tSearch.getText();
						for(int j=0; j < count; j++) {
							if(id.trim().charAt(0) == line[j].trim().charAt(0) && id.trim().charAt(1) == line[j].trim().charAt(1) && id.trim().charAt(2) == line[j].trim().charAt(2)) {
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
	    borderPane.setLeft(vBoxMenu);
	    borderPane.setCenter(vBoxCenter);
	    BorderPane.setAlignment(vBoxMenu,Pos.TOP_CENTER);
	    
	    btAddMed.setOnAction(e ->{AddMedicine pop=new AddMedicine();
	    pop.display(primaryStage);});
	    btPat.setOnAction(e ->{try{ PatientInfo toPatientInfo=new PatientInfo();toPatientInfo.start(primaryStage);
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