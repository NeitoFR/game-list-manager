package neito.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
	private final IntegerProperty score;
	private final StringProperty name;
	private final StringProperty editor;
	
	
	public Game(String name, int score, String editor)
	{
		this.name = new SimpleStringProperty(name);
		this.score = new SimpleIntegerProperty(score);
		this.editor = new SimpleStringProperty(editor);
	}
	public Game()
	{
		this(null, 0, null);
	}
	
	public String getScore() {				
	  return score.getValue().toString();
	}
	public void setScore(int string) {		
	  this.score.set(string);
	}
	public IntegerProperty ScoreProperty() {
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