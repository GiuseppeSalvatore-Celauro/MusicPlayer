package model;

public class Song {

	private static Integer counter = 0;
	private Integer id;
	private String title;
	private Integer duration;
	private User author;
	private String albumPic;
	private String albumName;
	
	public Song(String title, Integer duration, User author) {
		counterIncrese();
		this.id = counter;
		this.title = title;
		this.duration = duration;
		this.author = author;
	}
	
	public String getAlbumPic() {
		return albumPic;
	}
	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	// funzione che permette all'id degli utenti di aumentarsi automaticamente
	static public void counterIncrese() {
		counter++;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Canzone numero " + id + ", " + title + " , "  + author.getName() + " , " + duration + " . \n";
	}
}
