package neito.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import neito.Main;
import neito.model.Game;

public class GameListController {
	@FXML
	private TableView<Game> gameTable;
	@FXML
	private TableColumn<Game, String> nameColumn;
	@FXML
	private TableColumn<Game, Integer> scoreColumn;
	@FXML
	private Label nameLabel;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label editorLabel;
	
	private Main main;
	
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().ScoreProperty().asObject());
    }
    
	public void setMain(Main main)
	{
		this.main = main;
		gameTable.setItems(main.getGameList());
	}
}