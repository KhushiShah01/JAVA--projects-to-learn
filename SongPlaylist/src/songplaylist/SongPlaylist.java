/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songplaylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ubuntu
 */
public class SongPlaylist {

    private static ArrayList<Album> albums = new ArrayList<>();
    
    public static void main(String[] args) {        
        
        Album album1 = new Album("BE", "BTS");
        
        album1.addSong("Mikrokosmos", 4.5);
        album1.addSong("Filter", 3.2);
        album1.addSong("Ugh", 3.5);
        album1.addSong("Dynamite", 4.6);
        
        
        Album album2 = new Album("Manic", "Halsey");
        
        album2.addSong("Without Me", 3.8);
        album2.addSong("3 AM", 3.5);
        album2.addSong("Be Kind", 4.5);
     
        albums.add(album1);
        albums.add(album2);
        
        LinkedList<Song> playlist1 = new LinkedList<>();
        
        albums.get(0).addToPlaylist("Mikrokosmos", playlist1);
        albums.get(0).addToPlaylist("Ugh", playlist1);
        albums.get(1).addToPlaylist("Without Me", playlist1);
        
        
        play(playlist1);
        
    }
    private static void play(LinkedList<Song> playlist) {
        Scanner sc= new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        
        if(playlist.size()==0){
            System.out.println("This playlist has no song");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        
        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            
            switch(action){
                    case 0: 
                        System.out.println("Playlist complete");
                        quit = true;
                        break;
                    case 1: 
                        if(!forward) {
                            if(listIterator.hasNext()){
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: "+ listIterator.next().toString());
                            
                        }else{
                            System.out.println("End of playlist");
                            forward = false;
                        }
                        break;
                        
                    case 2: if(forward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                        }
                        if(listIterator.hasPrevious()) {
                        System.out.println("Now playing: "+ listIterator.previous().toString());
                        }else{
                        System.out.println("This is the first song in the playlist");
                        forward = false;
                        }
                        break;
                    
                    case 3: 
                        if(forward) {
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing: "+ listIterator.previous().toString());
                                forward = false;
                            }
                            else{
                              System.out.println("This is the first song in the playlist");
                            }
                        }else{
                            if(listIterator.hasNext()){
                                System.out.println("Now playing: "+ listIterator.next().toString());
                                forward = true;
                            }else{
                            System.out.println("Reached the end of the playlist ");
                            }
                        }
                        break;
                        
                    case 4: printList(playlist);
                        break;
                        
                    case 5:
                        printMenu();
                        break;
                    case 6: 
                        if(playlist.size() > 0) {
                            if(listIterator.hasNext()) {
                                System.out.println("Now playing "+listIterator.next().toString());
         
                            }
                            else{
                                if(listIterator.hasPrevious()) {
                                    System.out.println("Now playing "+listIterator.previous().toString());
                                }
                            }
                        }
                    
            }                
        }
    }
    
    private static void printMenu() {
        System.out.println ("MENU\n\nPress");
        System.out.println ("0 - QUIT");
        System.out.println ("1 - PLAY NEXT SONG");
        System.out.println ("2 - PLAY PREVIOUS SONG");
        System.out.println ("3 - REPLAY");
        System.out.println ("4 - ALL SONGS");
        System.out.println ("5 - PRINT ALL OPTIONS");
        System.out.println ("6 - DELETE CURRENT SONG");
    }
    
    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        
        System.out.println("\n");
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        System.out.println("\n");
        
        
    }
    
    
}
