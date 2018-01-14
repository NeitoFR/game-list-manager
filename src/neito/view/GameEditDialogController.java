package neito.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import neito.Util;
import neito.model.Game;

public class GameEditDialogController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField scoreField;
	@FXML
	private TextField editorField;
	@FXML
	private Label coverLabel;
	
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
	public boolean isOkClicked()
	{
		return okClicked;
	}

	//ButtonHandlers
	@FXML
	private void handleCancel()
	{
		diagStage.close();
	}
	@FXML
	private void handleOk()
	{
		if(isInputValid())
		{	
			game.setName(nameField.getText());
			game.setScore(Integer.parseInt(scoreField.getText()));
			game.setEditor(editorField.getText());
			game.setCoverDirectory(coverLabel.getText());
			okClicked = true;
			diagStage.close();
		}
	}
	@FXML 
	private void handleOpenChooser()
	{
		FileChooser filechooser = new FileChooser();
		File file = filechooser.showOpenDialog(diagStage);
		if(file != null) {
			coverLabel.setText(Util.genrateCoverURI(file.getAbsolutePath()));
		}
	}

	private boolean isInputValid()
	{
		String errorMessage = "";
		String nF = nameField.getText(), eF = editorField.getText(), cL = coverLabel.getText();//text value of Score
		int sF = Integer.parseInt(scoreField.getText());//int value of Score
		if(nF == null || nF.length() == 0 || nF.length() > 25) 
			errorMessage += "Name empty or too long\n"; 
		if(sF < 0 || sF > 20)
			errorMessage += "Sore too high or null\n";
		if((eF == null || eF.length() == 0 || eF.length() > 25) )
			errorMessage += "Editor name empty or too long\n";
		if(cL == null || cL.length() == 0)
			errorMessage += "No cover choosen";
		
		if(errorMessage.length() == 0)
			return true;
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