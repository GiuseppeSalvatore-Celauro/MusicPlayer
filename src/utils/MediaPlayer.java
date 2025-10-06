package utils;

//import java.util.Scanner;

import model.Song;

public class MediaPlayer {

//	private static boolean skip = false;
//	private static Song nextSong;


//	public static void setNextSong(Song nextSong) {
//		MediaPlayer.nextSong = nextSong;
//	}
	
	public static void playSong(Song song) {
//		skip = false;
		
		System.out.println("In riproduzione... " + song.getTitle());
		
		Thread player = new Thread(() -> {
			try {
				for(int i = 0; i < 5; i++) {
//					if(skip) {
//						System.out.println("Canzone skippata!");
//						return;
//					}
					System.out.println("Secondi passati: " + i + "di" + song.getDuration());
					Thread.sleep(1000);

				}
				System.out.println("Canzone terminata");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});
		
		
//		Thread inputReciver = new Thread(() ->{
//			Scanner input = new Scanner(System.in);
//			while(!skip) {
//				int skipChoice = input.nextInt();
//				if(skipChoice == 1) {
//					skip = true;
//					input.close();
//					playSong(nextSong);
//				}else {
//					input.close();
//					System.out.print("ciao");
//				}
//			}
//		});
		
		player.start();
//		inputReciver.start();

        try {
            player.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}
	
}
