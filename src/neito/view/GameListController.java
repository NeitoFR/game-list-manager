package neito.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private TableColumn<Game, String> scoreColumn;
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
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().ScoreProperty());
        showGameDetails(null);
        gameTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showGameDetails(newValue)) ;
    }
    private void showGameDetails(Game game)
    {
    	if(game != null)
    	{
    		nameLabel.setText(game.getName());
    		scoreLabel.setText(game.getScore());;
    		editorLabel.setText(game.getEditor());
    		
    	}
    	else 
    	{
    		nameLabel.setText("");
    		scoreLabel.setText("");
    		editorLabel.setText("");
    	}
    }
    @FXML
    private void handleDeleteGame()
    {
    	int selectedIndex = gameTable.getSelectionModel().getSelectedIndex();
    	if(selectedIndex >= 0){gameTable.getItems().remove(selectedIndex);}
    	else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getPrimary_S());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    @FXML
    private void handleAddGame()
    {
    	Game newGame = new Game();
    	boolean okClicked = main.showGameAddDialog(newGame);
    	if (okClicked)
    		main.getGameList().add(newGame);
    }
    @FXML
    private void handleEditGame()
    {
    	Game selectedGame = gameTable.getSelectionModel().getSelectedItem();
    	if(selectedGame != null)
    	{
    		boolean okClicked = main.showGameAddDialog(selectedGame);
    		if(okClicked)
    			showGameDetails(selectedGame);
    	}
    	else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getPrimary_S());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    
	public void setMain(Main main)
	{
		this.main = main;
		gameTable.setItems(main.getGameList());
	}
}