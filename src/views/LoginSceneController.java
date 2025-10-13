package views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.PlaylistService;
import service.SongService;
import service.UserService;

public class LoginSceneController {

	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField emailTextField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private UserService userList;
	private SongService songList;
	private PlaylistService playlistList;

	public void setUserList(UserService userList) {
		this.userList = userList;
	}
	public void setSongList(SongService songList) {
		this.songList = songList;
	}
	public void setPlaylistList(PlaylistService playlistList) {
		this.playlistList = playlistList;
	}
	public User loginCheck() {
		for(User u : this.userList.getAllUser()) {
			if(this.emailTextField.getText().equals(u.getEmail()) && this.nameTextField.getText().equals(u.getName())) {
				return u;
			}
		}
		return null;
	} 

	public void login(ActionEvent event) throws IOException {
		User user = loginCheck();
		if(user != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			root = loader.load();
			MainSceneController mainSceneController = loader.getController();
			mainSceneController.setAuthUser(user);	
			mainSceneController.authUserName(user);
			mainSceneController.setPlaylistList(playlistList);
			mainSceneController.setSongList(songList);
			mainSceneController.setContent("components/UserHomepageView.fxml", null);
		}else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorScene.fxml"));
			root = loader.load();
		}
		
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
	}

	
}
