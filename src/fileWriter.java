import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.Label;

public class fileWriter {

	public void medicineAdd(String checkMedID, String checkMedName, String checkUnitPrice, String checkSalePrice, String checkQuantity, String checkPurDate) {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("medicines.txt", true))) {
	    	
	        bw.newLine();
	        bw.write(String.format("%s      Name : %s       U_Price : %s       S_Price : %s       Qty : %s       P_Date : %s", checkMedID, checkMedName, checkUnitPrice, checkSalePrice, checkQuantity, checkPurDate));
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();

	    }
	}
	
	public void patientAdd(String checkPat, String checkAge, String checkID, String checkDOB, String checkDetail){
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("patients.txt", true))) {
	        bw.newLine();
	        bw.write(String.format("%s        DOB : %s        Fullname : %s            Age : %s        Details : %s",checkPat,checkAge,checkID,checkDOB,checkDetail));
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();

	    }
	}
	
	
	
	public void staffAdd(String checkFullname, String checkEmail, String checkPass, String checkStaffNo, String checkMobNo){
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("staffs.txt", true))) {
	    	bw.newLine();
	        bw.write(String.format("%s",checkFullname));
	        bw.newLine();
	        bw.write(String.format("%s",checkPass));
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();

	    }
	}
}
