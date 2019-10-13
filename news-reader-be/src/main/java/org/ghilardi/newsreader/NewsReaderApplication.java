package org.ghilardi.newsreader;

import org.ghilardi.newsreader.command.PrintLatestNewsCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsReaderApplication implements CommandLineRunner {

	public NewsReaderApplication(PrintLatestNewsCommand printLatestNewsCommand) {
		this.printLatestNewsCommand = printLatestNewsCommand;
	}

	public static void main(String[] args) {
		SpringApplication.run(NewsReaderApplication.class, args);
	}

	private final PrintLatestNewsCommand printLatestNewsCommand;

	@Override
	public void run(String... args) throws Exception {
		printLatestNewsCommand.execute();
	}
}
