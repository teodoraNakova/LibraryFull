package library;

import java.time.LocalDateTime;

import reading_matter.ReadingMatter;

public class Reader extends Thread{

	private String name;
	private ReadingMatter readingMatter;
	
	public Reader(String name, ReadingMatter readingMatter) {
		this.name = name;
		this.readingMatter = readingMatter;
	}
	
	@Override
	public void run() {
		readingMatter.rent();
	}
}
