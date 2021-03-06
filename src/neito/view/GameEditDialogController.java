package neito.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		if(isInputValid())
		{	
			game.setName(nameField.getText());
			game.setScore(Integer.parseInt(scoreField.getText()));
			game.setEditor(editorField.getText());
			
			okClicked = true;
			diagStage.close();
		}
	}
	
	private boolean isInputValid()
	{
		String errorMessage = "";
		String nF = nameField.getText(), eF = editorField.getText();//text value of Score
		int sF = Integer.parseInt(scoreField.getText());//int value of Score
		if(nF == null || nF.length() == 0 || nF.length() > 25) 
			errorMessage += "Name empty or too long\n"; 
		if(sF < 0 || sF > 20)
			errorMessage += "Sore too high or null\n";
		if((eF == null || eF.length() == 0 || eF.length() > 25) )
			errorMessage += "Editor name empty or too long\n";
		
		if(errorMessage.length() == 0)
		{
			return true;
		}
		
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(diagStage);
			alert.setTitle("Invalid fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false; 
		}
		
		
	}
}
