package app;

import java.util.Scanner;


import service.PlaylistService;
import service.SongService;
import service.UserService;
import utils.ConsoleHandler;
import utils.FileReader;


public class Main {
	public static void main(String[] args){
		
		UserService userList = new UserService();

		SongService songList = new SongService();
		
		FileReader fileReader = new FileReader("./data/songs.txt");
		
		fileReader.createSongs(songList, userList);
		
		PlaylistService playlistList = new PlaylistService();
		playlistList.playlistCreate("Nome playlist di prova", userList.getUserById(2));
		playlistList.playlistCreate("Nome Seconda playlist di prova", userList.getUserById(2));
		
		
		ConsoleHandler console = new ConsoleHandler(new Scanner(System.in), new Scanner(System.in), userList, songList, playlistList);
		
		console.showContent();
	}
}
