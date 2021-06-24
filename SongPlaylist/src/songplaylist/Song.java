/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songplaylist;

/**
 *
 * @author ubuntu
 */
public class Song {
    String title;
    double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    
    public Song() {
        
    }

    public double getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return "Song{" + "title=" + title + ", duration=" + duration + '}';
    }
    
}
