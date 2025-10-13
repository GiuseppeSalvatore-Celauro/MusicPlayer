package views.components;

import java.io.IOException;
import java.util.List;

import com.sun.prism.paint.Color;

import Interface.PopupController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;
import service.UserService;
import views.MainSceneController;


public class UserHomepageViewController {
	
	@FXML
	private VBox userView;
	
	private MainSceneController mainController;
	
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}
	
	private void playlistActions(String path, String title) {
		try {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			Parent dialogVbox = loader.load();
			this.setControllerAndId(loader, dialog, path);
			Scene dialogScene = new Scene(dialogVbox);
			Image icon = new Image("./Images/icon.jpg");
			dialog.getIcons().add(icon);
			dialog.setScene(dialogScene);
			dialog.setTitle(title);
			dialog.show();		
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	private void setControllerAndId(FXMLLoader loader, Stage dialog, String path) {
		switch(path) {
		case "CreatePlaylistView.fxml":
			CreatePlaylistViewController createController = loader.getController();
			createController.setMainController(mainController);
			createController.setDialog(dialog);
			break;
		case "RemovePlaylistView.fxml":
			RemovePlaylistViewController removeController = loader.getController();
			removeController.setMainController(mainController);
			removeController.setDialog(dialog);
			removeController.setPlaylist(mainController.getAuthUser().getUserPlaylists());
			break;
		case "AddSongToPlaylistView.fxml":
			AddSongToPlaylistViewController addSongController = loader.getController();
			addSongController.setMainController(mainController);
			addSongController.setDialog(dialog);
			addSongController.setPlaylist(mainController.getAuthUser().getUserPlaylists());
			addSongController.setSong(mainController.getSongService());
			break;
		}
		
	}

	public void addNewPlaylist() {
		playlistActions("CreatePlaylistView.fxml", "Crea una nuova playlist");     
	}
	
	public void removePlaylist() {
		playlistActions("RemovePlaylistView.fxml", "Rimuovi una playlist");    
	}
	
	public void addNewSongToPlaylist() {
		playlistActions("AddSongToPlaylistView.fxml", "Aggiungi una canzone"); 
	}
}
