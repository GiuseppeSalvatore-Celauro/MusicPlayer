package views.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.User;
import views.MainSceneController;

public class NavbarController {
	private User authUser;
	
	@FXML
	private Label labelName;
	
	@FXML
	private HBox navbar;
	
	private MainSceneController mainController;
	
	public void showHome() {
		mainController.setContent("components/UserHomepageView.fxml", "navbar");
	}
	public void showSongs() {
		mainController.setContent("components/SongView.fxml", "navbar");
	}
	public void showPlaylists() {
		mainController.setContent("components/PlaylistView.fxml", "navbar");
	}
	public void setMainController(MainSceneController mainController) {
		this.mainController = mainController;
	}
	public void setLabelName(User authUser) {
		this.authUser = authUser;
		this.labelName.setText("Benvenuto: " + authUser.getName());
	}
	
	public HBox getNavbar() {
		return this.navbar;
	}
}
