package mvc.view;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mvc.controller.BCMessage;
import mvc.controller.Book;
import mvc.controller.BookManagerController;
import mvc.controller.BookManagerObserver;

public class MainFX extends Application implements BookManagerObserver {
  BookManagerController controller;

  ListView<Book> listView;
  ObservableList<Book> bookList;
  BorderPane root;
  Map<String, Button> buttons;

  @Override
  public void start(final Stage stage) throws Exception {
    loadController();
    controller.addObserver(this);

    bookList = FXCollections.observableArrayList(controller.getBooks());
    listView = new ListView<>(bookList);
    listView.setId("lst_books");

    buttons = new LinkedHashMap<String, Button>();
    root = new BorderPane();

    addButtons(root);
    addListView(root);
    createScene(stage, root);
  }

  @Override
  public void update(BCMessage message) {
    bookList = FXCollections.observableArrayList(message.getBooks());
    listView = new ListView<>(bookList);
    listView.setId("lst_books");
    
    listView.setItems(bookList);
    root.setCenter(listView);

    if(message.getBooks().size() == 0) {
      buttons.get("Delete").setDisable(true);
      buttons.get("Edit").setDisable(true);
    } 
    else {
      buttons.get("Delete").setDisable(false);
      buttons.get("Edit").setDisable(false);
    }
  }
	



  //--------------------------------------------------------------------------------
  // Private methods for the GUI setup
  
  /**
   * Load the controller
   * Would load the model from a file or database, if it exists in a real application
   */
  private void loadController() {
    this.controller = new BookManagerController("PATHTOMODEL");
  }


  /**
   * Add the Add, Remove, Edit buttons to the top of the root pane
   * @param root the root pane
   */
  private void addButtons(BorderPane root) {
    ToolBar toolBar = new ToolBar();
    
    // Create Buttons
    Button addButton = new Button("Add");
    Button deleteButton = new Button("Delete");
    Button editButton = new Button("Edit");

    // Set id's for the buttons
    addButton.setId("btn_add");
    deleteButton.setId("btn_delete");
    editButton.setId("btn_edit");

    // add button handler
    addButton.setOnAction(e -> addButtonClicked());
    deleteButton.setOnAction(e -> deleteButtonClicked());
    editButton.setOnAction(e -> editButtonClicked());
    
    // Disable the buttons if there are no books in the list
    if (bookList.size() == 0) {
      deleteButton.setDisable(true);
      editButton.setDisable(true);
    }

    // Add the buttons to the toolbar
    toolBar.getItems().addAll(addButton, deleteButton, editButton);
    root.setTop(toolBar);

    // Add the buttons to the map
    buttons.put("Add", addButton);
    buttons.put("Delete", deleteButton);
    buttons.put("Edit", editButton);
  }

  /**
   * Handler for the Add button
   */
  private void addButtonClicked() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setHeaderText("Enter Book Info");
    dialog.setTitle("Book Entry");

    // Create the input fields
    TextField titleField = new TextField();
    TextField authorField = new TextField();
    TextField yearField = new TextField();
    TextField isbnField = new TextField();

    // Set id's for the fields
    titleField.setId("txt_title");
    authorField.setId("txt_author");
    yearField.setId("txt_year");
    isbnField.setId("txt_isbn");
    
    // Set the prompt text
    titleField.setPromptText("Title");
    authorField.setPromptText("Author");
    yearField.setPromptText("Year");
    isbnField.setPromptText("ISBN");

    // Add the fields to the dialog
    GridPane grid = new GridPane();
    grid.add(titleField, 1, 1);
    grid.add(authorField, 1, 2);
    grid.add(yearField, 1, 3);
    grid.add(isbnField, 1, 4);
    dialog.getDialogPane().setContent(grid);

    // returns null if the user cancels the dialog
    if (dialog.showAndWait().orElse(null) == null) {
        return;
    }
    

    // Get the input from the fields
    String title = titleField.getText();
    String author = authorField.getText();
    String year = yearField.getText();
    String isbn = isbnField.getText();

    // Check if the input is valid
    switch(controller.checkDialogInput(title, author, year, isbn))
    {
        case -1:
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Information");
          alert.setHeaderText("Add-Error:");
          alert.setContentText("Fields must be non empty!");
          alert.showAndWait();

          return;

        case -2:
          alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Information");
          alert.setHeaderText("Add-Error:");
          alert.setContentText("Invalid year!");
          alert.showAndWait();

          return;
    }

    // Add the book to the model
    if(controller.addBook(title, author, year, isbn) == false){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Add-Error:");
        alert.setContentText("Book already exists!");
        alert.showAndWait();
    }
  }

  /**
   * Handler for the Delete button
   */
  private void deleteButtonClicked() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setHeaderText("Enter ISBN of Book to Delete");
    dialog.setTitle("Delete Book");

    // Set the input fields to the selected book's info
    Book selectedBook = listView.getSelectionModel().getSelectedItem();
    if(selectedBook == null){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("No book selected");
        alert.setContentText("No book selected");
        alert.showAndWait();
        return;
    }
    

    // Get the input from the fields
    String isbn = selectedBook.getIsbn();

    // Add the book to the model
    if(controller.removeBook(isbn) == false){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Delete-Error:");
        alert.setContentText("Book does not exist!");
        alert.showAndWait();
    }
  }

  /**
   * Handler for the Edit button
   */
  private void editButtonClicked() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setHeaderText("Edit Book Info");
    dialog.setTitle("Book Entry");

    // Create the input fields
    TextField titleField = new TextField();
    TextField authorField = new TextField();
    TextField yearField = new TextField();
    TextField isbnField = new TextField();

    // Set id's for the fields
    titleField.setId("txt_title");
    authorField.setId("txt_author");
    yearField.setId("txt_year");
    isbnField.setId("txt_isbn");

    // Set the prompt text
    titleField.setPromptText("Title");
    authorField.setPromptText("Author");
    yearField.setPromptText("Year");
    isbnField.setPromptText("ISBN");

    // Set the input fields to the selected book's info
    Book selectedBook = listView.getSelectionModel().getSelectedItem();
    if(selectedBook == null){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("No book selected");
        alert.setContentText("No book selected");
        alert.showAndWait();
        return;
    }

    titleField.setText(selectedBook.getTitle());
    authorField.setText(selectedBook.getAuthor());
    yearField.setText(selectedBook.getYear());
    isbnField.setText(selectedBook.getIsbn());
    String oldIsbn = selectedBook.getIsbn();

    // Add the fields to the dialog
    GridPane grid = new GridPane();
    grid.add(titleField, 1, 1);
    grid.add(authorField, 1, 2);
    grid.add(yearField, 1, 3);
    grid.add(isbnField, 1, 4);
    dialog.getDialogPane().setContent(grid);

    // returns null if the user cancels the dialog
    if (dialog.showAndWait().orElse(null) == null) {
        return;
    }
    

    // Get the input from the fields
    String title = titleField.getText();
    String author = authorField.getText();
    String year = yearField.getText();
    String isbn = isbnField.getText();

    // Check if the input is valid
    switch(controller.checkDialogInput(title, author, year, isbn))
    {
        case -1:
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Information");
          alert.setHeaderText("Add-Error:");
          alert.setContentText("Fields must be non empty!");
          alert.showAndWait();

          return;

        case -2:
          alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Information");
          alert.setHeaderText("Add-Error:");
          alert.setContentText("Invalid year!");
          alert.showAndWait();

          return;
    }
    

    // Add the book to the model
    if(controller.editBook(oldIsbn, title, author, year, isbn) == false){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Book not found");
        alert.setContentText("Book not found");
        alert.showAndWait();
    }
  }

  /**
   * Add the ListView to the center of the root pane
   * @param root the root pane
   */
  private void addListView(BorderPane root) {
    root.setCenter(listView);
  }

  /**
   * Create the scene and show the stage
   * @param stage the stage
   * @param root the root pane
   */
  private void createScene(Stage stage, BorderPane root) {
    createScene(stage, root, 1200, 720);
  }

  /**
   * Create the scene and show the stage
   * @param stage the stage
   * @param root the root pane
   * @param width the width of the scene
   * @param height the height of the scene
   */
  private void createScene(Stage stage, BorderPane root, int width, int height) {
    Scene scene = new Scene(root, width, height);
    stage.setScene(scene);
    stage.show();
  }
  //--------------------------------------------------------------------------------
}
