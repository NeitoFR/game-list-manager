package neito.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import neito.model.Game;

public class GameEditDialogController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField scoreField;
	@FXML
	private TextField editorField;
	
	private Stage diagStage;
	private Game game;
	private boolean okClicked = false;
	
	@FXML
    private void initialize() {
    }
	public void setDialogStage(Stage dialogStage) {
        this.diagStage = dialogStage;
    }
	
	public void setNewGame(Game game)
	{
		this.game = game;
		
		nameField.setText(game.getName());
		scoreField.setText(game.getScore());
		editorField.setText(game.getEditor());
	}
	@FXML
	private void handleCancel()
	{
		diagStage.close();
	}
	public boolean isOkClicked()
	{
		return okClicked;
	}
	@FXML
	private void handleOk()
	{
		game.setName(nameField.getText());
		game.setScore(scoreField.getText());
		game.setEditor(editorField.getText());
		
		okClicked = true;
		diagStage.close();
	}
}
