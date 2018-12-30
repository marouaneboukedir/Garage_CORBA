package comV2.guichetRestitution;

import comV2.Voiture;
import comV2.guichetLocation.GuichetLocation;
import comV2.guichetLocation.GuichetLocationHelper;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import utilities.alerts.AlertMaker;
import comV2.serveurCentral.LocRestHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RestitutionUIController implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
    ObservableList<String> listGarages = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> garagesCombo;
    @FXML
    private JFXTextField matriculeTextField;
    @FXML
    private JFXTextField marqueTextField;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listGarages.addAll("G1","G2","G3");
        garagesCombo.setItems(listGarages);
    }
    @FXML
    public void restituerVoiture(){
    	if(matriculeTextField.getText().equals("")||marqueTextField.getText().equals("")||garagesCombo.getSelectionModel().getSelectedItem()==null)
    		return;
        try {
        	GuichetRestitution guichetRestitution  = LocRestHelper.getGuichetRestitution();
    		GuichetLocation guichetLocation = LocRestHelper.getGuichetLocation();
    		Voiture voiture = new Voiture(matriculeTextField.getText(),marqueTextField.getText());
    		
    		//Consulter la Liste des voitures Loues
    		System.out.println("================ Consulter la Liste des voitures Loues ================");
    		boolean existe = false;
    		for(Voiture voiture2 : guichetLocation.voituresLoc())
    			if(voiture2.getMatricule().equals(voiture.getMatricule()))
    				existe = true;
			System.out.println("================ EXISTE : "+existe);
    		if(existe) {
    			//guichetRestitution.restituer();
    			System.out.println("================ Restituer ================");
    			int nombreVRest = guichetRestitution.voituresRest().length;
    			Voiture[] voitures = new Voiture[nombreVRest+1];
    			int i = 0 ;
    			for(Voiture voitureR : guichetRestitution.voituresRest())
    				voitures[i++] = voitureR;
    			voitures[i] = voiture;
    			guichetRestitution.voituresRest(voitures);
    			for(Voiture voitureR :guichetRestitution.voituresRest())
    				System.out.println("RESTIUER METHOD ==== "+voitureR.toString());
    			matriculeTextField.setText("");
    			marqueTextField.setText("");
    			List<JFXButton> buttons = new ArrayList<JFXButton>();
    			buttons.add(new JFXButton("OK"));
    	        AlertMaker.showConfirmationAlert(rootPane,"Confirmation de la restitution" , "restituter la voiture qui a la matricule : " + voiture.getMatricule() + " ?",ButtonType.OK, ButtonType.CANCEL);
    		}else {
    	        AlertMaker.showConfirmationAlert(rootPane,"ERRUER EXISTANCE /!\\" , "la voiture qui a la matricule : << " + voiture.getMatricule() + " >> n'existe pas dans le guichet LOCATION!",ButtonType.OK);
    		}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
