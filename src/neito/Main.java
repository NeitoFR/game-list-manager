package neito;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neito.model.Game;
import neito.view.GameEditDialogController;
import neito.view.GameListController;

public class Main extends Application {

	private Stage primary_S;
	private BorderPane rootLayout;
	private ObservableList<Game> gameList = FXCollections.observableArrayList();
	
	
	public Main()
	{
		gameList.add(new Game("MK10", 15, "Default"));
		gameList.add(new Game("Dofus", 16, "Ankama"));
		gameList.add(new Game("Dishonored", 18, "Arkane"));
		gameList.add(new Game("Starcraft", 12, "Blizzard"));
		gameList.add(new Game("Battlerite", 17, "Ankama"));	
	}
	public ObservableList<Game> getGameList() {
        return gameList;
    }	
	@Override
	public void start(Stage primary_S) {
		this.primary_S = primary_S;
		this.primary_S.setTitle("Game List Manager");
		initRoot();
		showGameList();
	}
	

	
	public void initRoot()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Root.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primary_S.setScene(scene);
			primary_S.show();
			//primary_S.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showGameList()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameDisplay.fxml"));
			SplitPane gameListLayout = (SplitPane) loader.load();
			rootLayout.setCenter(gameListLayout);
			
			GameListController ctrl = loader.getController();
			ctrl.setMain(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean showGameAddDialog(Game game)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GameEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			//Create Stage
			Stage diagStage = new Stage();
			diagStage.setTitle("Add a new game");
			 diagStage.initOwner(primary_S);
	        Scene scene = new Scene(page);
	        diagStage.setScene(scene);
	        
	        //Set Controller
	        GameEditDialogController ctrl = loader.getController();
	        ctrl.setDialogStage(diagStage);
	        ctrl.setNewGame(game);
	        
	        diagStage.showAndWait();
	        
	        return ctrl.isOkClicked();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public Stage getPrimary_S() {
		return primary_S;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
