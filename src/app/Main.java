package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.PlaylistService;
import service.SongService;
import service.UserService;
import utils.FileReader;
import views.LoginSceneController;
import views.MainSceneController;

public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception{
		
		UserService userList = new UserService();
		SongService songList = new SongService();
		PlaylistService playlistList = new PlaylistService();;
		FileReader fileReader = new FileReader("./data/songs.txt");
		
		fileReader.createSongs(songList, userList);
		playlistList.playlistCreate("Nome playlist di prova", userList.getUserById(2));
		playlistList.playlistCreate("Nome Seconda playlist di prova", userList.getUserById(2));
		
		playlistList.getPlaylistById(1).addSong(songList.getSongById(2));
		playlistList.getPlaylistById(1).addSong(songList.getSongById(3));
		playlistList.getPlaylistById(1).addSong(songList.getSongById(4));
		userList.getUserById(2).setUserPlaylists(playlistList.getAllPlaylist());
		
//		Login scene loader
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/views/LoginScene.fxml"));
		Parent root = loginLoader.load();
		LoginSceneController loginController = loginLoader.getController();
		loginController.setUserList(userList);
		loginController.setPlaylistList(playlistList);
		loginController.setSongList(songList);
		
		
//		Main scene loader
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainScene.fxml"));
//		Parent root = loader.load();
//		MainSceneController controller = loader.getController();
//		controller.setAuthUser(userList.getUserById(1));
//		controller.authUserName(userList.getUserById(1));
//		controller.setPlaylistList(playlistList);
//		controller.setSongList(songList);
		
		Scene scene = new Scene(root);
		
		Image icon = new Image("/Images/icon.jpg");
		
		stage.getIcons().add(icon);
		
		stage.setScene(scene);
		stage.setTitle("Music Player");
		stage.setHeight(600);
		stage.setResizable(false);
		stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
