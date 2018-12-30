package comV2.guichetLocation;

import comV2.Voiture;
import comV2.guichetRestitution.GuichetRestitution;
import comV2.guichetRestitution.GuichetRestitutionHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utilities.alerts.AlertMaker;
import comV2.serveurCentral.LocRestHelper;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LocationUIController implements Initializable {
	
    ObservableList<Voiture> listVoitures = FXCollections.observableArrayList();
    @FXML
    private TableView<Voiture> tableViewVoitures;

    @FXML
    private TableColumn<Voiture, String> matricule;
    @FXML
    private TableColumn<Voiture, String> marque;
    /*
    @FXML
    private TableColumn<Voiture, Boolean> disponible;
*/
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showVoitures();

    }

    //Views Display Methods //_________________________________________________________
    private void initCol() {
        matricule.setCellValueFactory(new PropertyValueFactory<Voiture, String>("matricule"));
        marque.setCellValueFactory(new PropertyValueFactory<Voiture, String>("marque"));
        //disponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
    }
    private void loadData() {
        listVoitures.removeAll(listVoitures);
		GuichetRestitution guichetRestitution = LocRestHelper.getGuichetRestitution();
		if(guichetRestitution!=null)
			System.out.println("LOAD === Not NULL");
		else System.out.println("LOAD === NULL");
		for(Voiture voiture : guichetRestitution.voituresRest()) {
			//System.out.println("LOAD REST ==== "+voiture.toString());
			listVoitures.add(voiture);
		}
		for(Voiture voiture : listVoitures) {
			System.out.println("LOAD REST 3 ==== "+voiture.toString());
		}
        tableViewVoitures.setItems(listVoitures);
    }
    @FXML
    private void showVoitures(){
        initCol();
        loadData();
    }
    @FXML
    private void refreshVoituresList(){
        showVoitures();
        System.out.println("================== Actualiser ");
    }
    @FXML
    private void louerVoiture(){
        Voiture voitureSelectionee = tableViewVoitures.getSelectionModel().getSelectedItem();
        Alert alert = AlertMaker.showConfirmationAlert(tableViewVoitures,"Confirmation de la Location" , "louer la voiture qui a la matricule : " + voitureSelectionee.getMatricule() + " ?",ButtonType.OK, ButtonType.CANCEL);
        if(alert.getResult().getText().equals("OK")) {
        	
        	try {
        		GuichetLocation guichetLocation = LocRestHelper.getGuichetLocation();
        		GuichetRestitution guichetRestitution = LocRestHelper.getGuichetRestitution();
        		int nombreVLoc = guichetLocation.voituresLoc().length;
        		int nombreVRes = guichetRestitution.voituresRest().length;
        		System.out.println("SIZE ==== "+nombreVLoc+"\t"+nombreVRes);
        		//AJOUT DANS LIST LOUES
        		Voiture[] voitures = new Voiture[nombreVLoc+1];
        		int i = 0 ;
        		for(Voiture voiture : guichetLocation.voituresLoc())
        			voitures[i++] = voiture;
        		voitures[i] = voitureSelectionee;
        		guichetLocation.voituresLoc(voitures);
        		for(Voiture voiture :guichetLocation.voituresLoc())
        			System.out.println("LOUER METHOD ==== "+voiture.toString());
        		//SUPPRIMER DANS LIST REST
        		Voiture[] voituresRes = new Voiture[nombreVRes-1];
        		int j = 0 ;
        		for(Voiture voiture : guichetRestitution.voituresRest())
        			if(!voiture.getMatricule().equals(voitureSelectionee.getMatricule()))
        				voituresRes[j++] = voiture;
        		guichetRestitution.voituresRest(voituresRes);
        	} catch (Exception e) {
        		// TODO: handle exception
        		e.printStackTrace();
        	}
        	System.out.println("================== Louer --- "+voitureSelectionee.toString());
        	refreshVoituresList();
        }
    }
}
