package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.User;
import service.SongService;
import service.UserService;

public class FileReader {

	private File FilePath;
	
	public FileReader(String FilePath) {
		this.FilePath = new File(FilePath);
	}
	
	public File getFilePath() {
		return FilePath;
	}

	public List<String> readFile() {
		
		List<String> fileContent = new ArrayList<String>();
		
		try (Scanner reader = new Scanner(this.FilePath)){
			while(reader.hasNextLine()) {
				fileContent.add(reader.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			fileContent.add("Il reader ah avuto un problema nella crezione;");
			e.printStackTrace();
		}
		
		
		return fileContent;
	}
	
	public void createSongs(SongService songList, UserService userService) {
		for(String song: this.readFile()) {
			String[] splitSong = song.split(", ");
			if (splitSong.length < 3) continue;
			
			String title = splitSong[0];
			int duration = Integer.parseInt(splitSong[1]);
			String authorName = splitSong[2];
			
			User author = null;
			
			for(User u: userService.getAllUser()) {
				if(u.getName().equalsIgnoreCase(authorName)) {
					author = u;
				}
			}
			
			if(author == null) {
				author = userService.userCreate(authorName, authorName + "@gmail.com");
			}
			
			songList.songCreate(title, duration, author);
			
		}
	}
	
}
