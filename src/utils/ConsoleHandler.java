package utils;

import java.util.Scanner;


import model.Playlist;
import model.Song;
import model.User;
import service.PlaylistService;
import service.SongService;
import service.UserService;

public class ConsoleHandler {
	
	private Scanner userInputNum;
	private Scanner userInputString;
	private UserService userList;
	private SongService songList;
	private PlaylistService playlistList;
	
	private int userData;
	
	public ConsoleHandler(Scanner userInputNum, Scanner userInputString,UserService userList, SongService songList, PlaylistService playlistList) {
		this.userInputNum = userInputNum;
		this.userInputString = userInputString;
		this.userList = userList;
		this.songList = songList;
		this.playlistList = playlistList;
	}


	private void showEarlyLines() {
		System.out.println("Digita un numero da 1 a 6 per scegliere la tua prossima azione:");
		System.out.println("	- 1. Visualizza gli utenti reggistrati");
		System.out.println("	- 2. Visualizza tutte le canzoni reggistrate");
		System.out.println("	- 3. Visualizza tutte le playlist reggistrate");
		System.out.println("	- 4. Aggiungi una canzone ad una playlist");
		System.out.println("	- 5. Aggiungi una nuova playlist");
		System.out.println("	- 6. Rimuovi un brano da una playlist");
		System.out.println("	- 7. Chiudi applicazione");
		this.userData = userInputNum.nextInt();
	}
	
	public void showContent() {
		boolean running = true;
		while(running) {
			
			this.showEarlyLines();
			
			switch(this.userData) {
			case 1:
				this.showUsers();
				break;
			case 2:
				this.showSongs();
				this.playSong();
				break;
			case 3:
				this.showPlaylists();				
				break;
			case 4:
				this.addSongToPlaylist();
				break;
			case 5:
				this.createNewPlaylist();			
				break;
				
			case 6:
				this.removeSongFromPlaylist();
				break;
			case 7:
				this.consoleExit();
				running = false;
				break;
			default:
				this.errHandler();
				break;
			}
		}
	}
	
	private void showUsers() {
		for(User u: userList.getAllUser()) {
			System.out.println(userList.getUserInfos(u.getId()));
		}
	}
	
	private void showSongs() {
		for (Song song: songList.getAllSongs()) {
			System.out.println(song);
		}
	}
	
	private void playSong() {
		System.out.println("Scegli la canzone che vuoi ascoltare:");
		int chosenSong = userInputNum.nextInt();
		Song selectedSong = songList.getSongById(chosenSong);
		if(selectedSong != null) {
//			Song nextSong = songList.getSongById(chosenSong+1);
//			MediaPlayer.setNextSong(nextSong);
			MediaPlayer.playSong(selectedSong);
			

		}else {
			System.out.println("Errore, devi selezionare una canzone esistente, adesso verrai riportato all'inizio");
		}
	}
	
	private void showPlaylists() {
		for(Playlist p: playlistList.getAllPlaylist()) {
			System.out.println(p);
			if(p.getPlaylistSongs().isEmpty()) {
				System.out.println("E non contiene canzoni \n");
			}else {
				System.out.println("Ed contiene queste canzoni \n");
				for(Song s: p.getPlaylistSongs()) {
					System.out.println(" - " + s.getTitle() + "; \n");
				}
			}
		}
	}
	
	private void consoleExit() {
		System.out.println("Grazie per averci usato");
		this.userInputNum.close();
		this.userInputString.close();
	}
	
	private void errHandler() {
		System.out.println("Azione non consentita");
	}
	
	private void addSongToPlaylist() {
		System.out.println("Seleziona qui sotto l'id della canzone da te scelta");
		this.showSongs();
		
		int userSong = userInputNum.nextInt();
		
		Song selectedSong = songList.getSongById(userSong);
		
		if(selectedSong != null) {
			System.out.println("Seleziona qui sotto l'id playlist dove vuoi mettere la canzone");
			this.showPlaylists();
			int userPlaylist = userInputNum.nextInt();
			
			Playlist selectedPlaylist = playlistList.getPlaylistById(userPlaylist);
			
			if(selectedPlaylist != null) {
				selectedPlaylist.addSong(selectedSong);
				System.out.println("Aggiunta andata con successo!");
			}else {
				System.out.println("Errore, devi selezionare una playlist esistente, adesso verrai riportato all'inizio");
			}
			
		}else {
			System.out.println("Errore, devi selezionare una canzone esistente, adesso verrai riportato all'inizio");
		}
	}
	
	private void createNewPlaylist() {
		System.out.println("Che user vuoi che crei la sua nuova playlist?");
		this.showUsers();
		
		int userId = userInputNum.nextInt();
		
		User userSelected = userList.getUserById(userId);
		
		if(userSelected != null) {
			System.out.println("Immetti qui sotto il nome della tua nuova playlist");

			String playlistName =  userInputString.nextLine();
			
			if(playlistName.length() > 0) {
				playlistList.playlistCreate(playlistName, userSelected);
				System.out.println("Playlist creata con successo");
			}else {
				System.out.println("Il nome deve contenere almeno un carattere, adesso verrai riportato all'inizio");
			}
		}else {
			System.out.println("Devi selezionare uno user esistente, adesso verrai riportato all'inizio");
		}
		
	}
	
	private void removeSongFromPlaylist() {
		System.out.println("Che playlist vuoi modificare?");
		this.showPlaylists();
		
		int userPlaylist = userInputNum.nextInt();
		
		Playlist playlistSelected = playlistList.getPlaylistById(userPlaylist);
		
		if(playlistSelected != null) {
			if(playlistSelected.getPlaylistSongs().isEmpty()) {
				System.out.println("Mi dispiace ma questa playlist non contiene alcuna canzone, verrai riportato all'inizio");
			}else {
				System.out.println("Che canzone vuoi elimare da questa playlist?");
				for(Song s: playlistSelected.getPlaylistSongs()) {
					System.out.println(s);
				}
				int playlistSong = userInputNum.nextInt();
				
				Song songSelected = songList.getSongById(playlistSong);
				
				if(songSelected != null) {
					playlistSelected.removeSong(songSelected);
					System.out.println("Rimozione completata con successo");
				}else {
					System.out.println("Mi dispiace ma devi selezionare una canzone esistente, verrai riportato all'inizio");
				}
			}
		}
	}
}
