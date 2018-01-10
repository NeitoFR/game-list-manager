package neito.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
	private final StringProperty score;
	private final StringProperty name;
	private final StringProperty editor;
	
	public Game(String name, String score, String editor)
	{
		this.name = new SimpleStringProperty(name);
		this.score = new SimpleStringProperty(score);
		this.editor = new SimpleStringProperty(editor);
	}
	
	public String getScore() {				
	  return score.get();
	}
	public void setScore(String value) {		
	  this.score.set(value);
	}
	public StringProperty ScoreProperty() {
        return score;
    }	
	public StringProperty NameProperty() {
        return name;
    }	
	public String getName() {
		return name.get();
	}
	public void setName(String value) {
		this.name.set(value);
	}
	public String getEditor() {				
	  return editor.get();
	}
	public void setEditor(String value) {		
	  this.editor.set(value);
	}
	public StringProperty EditorProperty() {
        return editor;
	}
}