package spring.dao.interfaces;

import java.util.List;

import spring.dao.objects.MP3;

public interface MP3Dao {

	void insert(MP3 mp3);

	void delete(MP3 mp3);

	MP3 getMP3ByID(int id);

	List<MP3> getMP3ListByName(String name);

	List<MP3> getMP3ListByAuthor(String author);

}
