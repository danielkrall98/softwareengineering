package mvc;

import javafx.application.Platform;
import mvc.controller.Book;
import mvc.model.BookManager;
import mvc.view.MainFX;

public class Main {
	public static BookManager bookManager = new BookManager();

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				MainFX.launch(MainFX.class, args);
			}
		};
		t.start();

		/* 
		Thread.sleep(3000);

		//has to be run on the JavaFX thread
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					
					//remove a book
					bookManager.removeBook("987654321");
					//observe the changes in the gui
					System.out.println(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					//making model changes
					//add a book to the model
					bookManager.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "1937", "123456789"));
					//observe the changes in the gui
					System.out.println(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					
					//add another book
					bookManager.addBook(new Book("Design Patterns", "Erich Gamma", "1994", "987654321"));
					//observe the changes in the gui
					System.out.println(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					
					//edit a book
					bookManager.editBook("123456789", new Book("Lord of the Rings", "J.R.R. Tolkien", "1954", "123456789"));
					//observe the changes in the gui
					System.out.println(".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		*/
  	}
}
