package neito;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neito.model.Game;
import neito.view.GameListController;

public class Main extends Application {

	private Stage primary_S;
	private BorderPane rootLayout;
	private ObservableList<Game> gameList = FXCollections.observableArrayList();
	
	
	public Main()
	{
		gameList.add(new Game("MK10", 15));
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

	public Stage getPrimary_S() {
		return primary_S;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
