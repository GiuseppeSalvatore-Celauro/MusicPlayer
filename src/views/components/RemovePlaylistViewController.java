package views.components;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Interface.PopupController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Playlist;
import views.MainSceneController;

public class RemovePlaylistViewController{
	
	

	
	private MainSceneController mainController;
	private Stage dialog;
	private List<Playlist> playlists;
	
	@FXML
	private ChoiceBox<Playlist> selectPlaylist;
	
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}

	public void setDialog(Stage dialog) {
		this.dialog = dialog;
		
	}
	
	public void setPlaylist(List<Playlist> playlist) {
		this.playlists = playlist;
		
		if(!playlists.isEmpty()) {
			selectPlaylist.setItems(FXCollections.observableArrayList(playlists));
		}
	}
	
	public void deleteAction() {
		Playlist p = selectPlaylist.getValue();
		
		if(p !=null) {
			playlists.remove(p);
			selectPlaylist.getItems().remove(p);
			dialog.close();
		}
	}

	@FXML
	public void initialize() {
	}
}
