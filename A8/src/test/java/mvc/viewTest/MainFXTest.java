package mvc.viewTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import mvc.view.*;
import mvc.controller.*;

@ExtendWith(ApplicationExtension.class)
class MainFXTest {
    private MainFX main;

    /**
     * Will be called with {@code @Before} semantics, i. e. before each test method.
     *
     * @param stage - Will be injected by the test runner.
     */
    @Start
    private void start(Stage stage) {
        main = new MainFX();
        
        assertDoesNotThrow(() -> main.start(stage));
    }

    /** @param robot - Will be injected by the test runner.*/
    @BeforeEach
    void setUp(FxRobot robot) throws Exception {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);

        for(Book book : listView.getItems()) {
            //click on the first item in the list
            //by moving the mouse to the left upper corner of the list and clicking a bit to the right and down
            robot.clickOn(
                listView.localToScreen(listView.getBoundsInLocal()).getMinX() + 5, 
                listView.localToScreen(listView.getBoundsInLocal()).getMinY() + 5
                );
            robot.clickOn("#btn_delete");
        }
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void should_contain_Buttons(FxRobot robot) {
        Set<Button> buttons = robot.lookup(".button").queryAllAs(Button.class);

        Assertions.assertThat(buttons).hasSize(3);
        Assertions.assertThat(buttons).extracting(Button::getText).contains("Add", "Delete", "Edit");
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void should_contain_ListView(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);

        Assertions.assertThat(listView).isNotNull();
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void test_addBook(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();

        createBook(robot, "Title", "Author", "2022", "1234567890");

        listView = robot.lookup("#lst_books").queryAs(ListView.class);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd + 1);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void test_deleteBook(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();

        createBook(robot, "TitleToDelete", "AuthorToDelete", "2022", "1-123-23462-1");
        listView = robot.lookup("#lst_books").queryAs(ListView.class);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd + 1);

        //click on the first item in the list
        //by moving the mouse to the left upper corner of the list and clicking a bit to the right and down
        robot.clickOn(
            listView.localToScreen(listView.getBoundsInLocal()).getMinX() + 5, 
            listView.localToScreen(listView.getBoundsInLocal()).getMinY() + 5
            );
        robot.clickOn("#btn_delete");

        listView = robot.lookup("#lst_books").queryAs(ListView.class);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void test_editBook(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();

        createBook(robot, "Title", "Author", "2022", "1-347234562");
        listView = robot.lookup("#lst_books").queryAs(ListView.class);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd + 1);

        //click on the first item in the list
        //by moving the mouse to the left upper corner of the list and clicking a bit to the right and down
        robot.clickOn(
            listView.localToScreen(listView.getBoundsInLocal()).getMinX() + 5, 
            listView.localToScreen(listView.getBoundsInLocal()).getMinY() + 5
            );
        robot.clickOn("#btn_edit");

        //edit the book
        robot.clickOn("#txt_title").type(KeyCode.DELETE, 10).type(KeyCode.BACK_SPACE, 10).write("_Edited");
        robot.clickOn("#txt_author").type(KeyCode.DELETE, 10).type(KeyCode.BACK_SPACE, 10).write("_Edited");

        //click on the "OK" button
        //query ok button
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();

        robot.clickOn(okButton);

        //check if the book was edited
        listView = robot.lookup("#lst_books").queryAs(ListView.class);
        Assertions.assertThat(listView.getItems().get(0).getTitle()).isEqualTo("_Edited");
        Assertions.assertThat(listView.getItems().get(0).getAuthor()).isEqualTo("_Edited");
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void cancleAdd_invalidAndEmptyInput(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();

        //click on the "Add" button
        robot.clickOn("#btn_add");

        //click on the "Cancel" button
        //query cancel button
        Button cancelButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("Abbrechen"))
                .findFirst().get();
        robot.clickOn(cancelButton);


        //check if the book was added
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);

        
        //click on the "Add" button
        robot.clickOn("#btn_add");

        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        //invalid input alert should be shown
        //query alert
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        //check if the book was added
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);

        //same with invalid input
        //click on the "Add" button
        robot.clickOn("#btn_add");
        createBook(robot, "invalid", "invalid", "invalid", "invalid");

        //invalid input alert should be shown
        //query alert
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        //check if the book was added
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void moreInvalidAdd(FxRobot robot) {
        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();


        //title is empty
        robot.clickOn("#btn_add");
        createBook(robot, "", "Author", "2022", "1-22222222");
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);


        //author is empty
        robot.clickOn("#btn_add");
        createBook(robot, "Title", "", "2022", "1-22222222");
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);


        //year is empty
        robot.clickOn("#btn_add");
        createBook(robot, "Title", "Author", "", "1-22222222");
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);

        //year is empty
        robot.clickOn("#btn_add");
        createBook(robot, "Title", "Author", "2022", "");
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void cancleEdit_invalidAndEmptyInput(FxRobot robot) {
        createBook(robot, "NoEdit", "Author", "2022", "5-6-7-7-2");

        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        String title = listView.getItems().get(0).getTitle();

        //dont select a book
        robot.clickOn("#btn_edit");
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);


        robot.clickOn(
            listView.localToScreen(listView.getBoundsInLocal()).getMinX() + 5, 
            listView.localToScreen(listView.getBoundsInLocal()).getMinY() + 5
            );
        robot.clickOn("#btn_edit");

        //click on the "Cancel" button
        //query cancel button
        Button cancelButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("Abbrechen"))
                .findFirst().get();
        robot.clickOn(cancelButton);


        robot.clickOn(
            listView.localToScreen(listView.getBoundsInLocal()).getMinX() + 5, 
            listView.localToScreen(listView.getBoundsInLocal()).getMinY() + 5
            );
        robot.clickOn("#btn_edit");

        //delete title
        robot.clickOn("#txt_title").eraseText(20).type(KeyCode.DELETE, 20);

        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void addDuplicate(FxRobot robot) {
        createBook(robot, "Title", "Author", "2022", "DuplicateISBN");

        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeAdd = listView.getItems().size();

        robot.clickOn("#btn_add");
        createBook(robot, "Title", "Author", "2022", "DuplicateISBN");

        //duplicate alert should be shown
        //query alert
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        //check if the book was added
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeAdd);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void invalidDelete(FxRobot robot) {
        createBook(robot, "NoDelete", "NoDelete", "2022", "NoDeleteISBN");

        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);
        int size_beforeDelete = listView.getItems().size();

        //dont select a book
        robot.clickOn("#btn_delete");
        //query alert
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        //check if the book was deleted
        Assertions.assertThat(listView.getItems()).hasSize(size_beforeDelete);
    }

    /** @param robot - Will be injected by the test runner.*/
    @Test
    void invalidRemoveAndEditCalls(FxRobot robot){
        createBook(robot,"dummy", "dummy", "2022", "dummyISBN");

        ListView<Book> listView = robot.lookup("#lst_books").queryAs(ListView.class);

        listView.getSelectionModel().select(new Book("null", "null", "2022", "not in list"));
        robot.clickOn("#btn_delete");

        //query alert
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);


        robot.clickOn("#btn_edit");
        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);

        okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();
        robot.clickOn(okButton);
    }

    //---------------------------------- HELPER METHODS ----------------------------------//
    private void createBook(FxRobot robot, String title, String author, String year, String isbn) {
        robot.clickOn("#btn_add");
        robot.clickOn("#txt_title").write(title);
        robot.clickOn("#txt_author").write(author);
        robot.clickOn("#txt_year").write(year);
        robot.clickOn("#txt_isbn").write(isbn);

        //click on the "OK" button
        //query ok button
        Button okButton = robot.lookup(".button").queryAllAs(Button.class).stream()
                .filter(button -> button.getText().equals("OK"))
                .findFirst().get();

        robot.clickOn(okButton);
    }
}