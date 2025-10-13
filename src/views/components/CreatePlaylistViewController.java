package views.components;

import Interface.PopupController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.PlaylistService;
import views.MainSceneController;

public class CreatePlaylistViewController {
	@FXML
	private TextField textFieldPlaylistName;
	
	private Stage dialog;
	
	private MainSceneController mainController;
	
	@FXML
	public void initialize() {
		
	}
	
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}

	public void setDialog(Stage dialog) {
		this.dialog = dialog;
	}
	
	public void createPlaylist() {
		PlaylistService playlistList = this.mainController.getPlaylistService();
		User authUser = this.mainController.getAuthUser();
		playlistList.playlistCreate(textFieldPlaylistName.getText(), authUser);
		System.out.println(playlistList.getAllPlaylist());
		dialog.close();
	}
}
