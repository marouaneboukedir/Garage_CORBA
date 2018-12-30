package comV2.guichetRestitution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import comV2.guichetLocation.LocationImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.IOException;

public class MainRestitution extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String nextViewPath = "restitutionUI.fxml" ;
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(nextViewPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent) ;
        primaryStage.setTitle("Guichet Restitution");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
    	Thread thread = new Thread( () ->{
    		try {
                ORB orb=ORB.init(args, null);
                POA rootPOA= POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
                rootPOA.the_POAManager().activate();
                RestitutionImpl od=new RestitutionImpl(10);
                Context ctx=new InitialContext();
                Object ref=rootPOA.servant_to_reference(od);
                System.out.println(ref);
                ctx.rebind("restitution", ref );
                orb.run();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    );
    thread.start();
    launch(args);
    thread.setName("==== THREAD GUICHET RESTITUTION ====");
        
    }
}
