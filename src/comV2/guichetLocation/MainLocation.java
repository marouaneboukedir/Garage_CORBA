package comV2.guichetLocation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import javax.naming.Context;
import javax.naming.InitialContext;

public class MainLocation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("locationUI.fxml"));
        primaryStage.setTitle("Guichet Location");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Thread thread = new Thread( () ->{
                try {
                    ORB orb = ORB.init(args, null);
                    POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
                    rootPOA.the_POAManager().activate();
                    LocationImpl od = new LocationImpl();
                    Context ctx = new InitialContext();
                    Object ref = rootPOA.servant_to_reference(od);
                    System.out.println(ref);
                    ctx.rebind("location", ref);
                    orb.run();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("ERROR LOCATION MAIN ====>"+e.getMessage());
                }
            }
        );
        thread.start();
        launch(args);
        thread.setName("==== THREAD GUICHET LOCATION ====");
    }
}
