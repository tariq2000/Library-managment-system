package projectoop;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Projectoop extends Application {

    private Button add = new Button("Add");
    private Button book1 = new Button("Book");
    private Button student1 = new Button("Student");
    private Button professor1 = new Button("Professor");
    private Button delete = new Button("Delete");
    private Button book2 = new Button("Book");
    private Button student2 = new Button("Student");
    private Button professor2 = new Button("Professor");
    private Button borret = new Button("Bor/Ret");
    private Button reborts = new Button("Reports");
    private Button clear = new Button("clear");
    private Button exit = new Button("Exit");
    private Button add2 = new Button("Add");
    private Button student3 = new Button("Student");
    private Button prof3 = new Button("Professor");
    private Button student4 = new Button("students");
    private Button professor4 = new Button("professors");
    private Button book4 = new Button("books");
    private Button stbooks = new Button("students books");
    private Button profbooks = new Button("professors books");
    private Button borrow = new Button("Borrow");
    private Button ret = new Button("Return");
    private Button profbor = new Button("Borrow");
    private Button profret = new Button("Return");

    private PreparedStatement preparedStatement;
    private ResultSet resultSet = null;
    private TextField ISBN = new TextField();
    private TextField bookName = new TextField();
    private TextField AuthorName = new TextField();
    private TextField DateofPublication = new TextField();
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> items2 = FXCollections.observableArrayList();

    BorderPane pane2 = new BorderPane();
    HBox hBox = new HBox(70);
    @Override
    public void start(Stage primaryStage) {
        add.setPrefSize(140, 40);
        book1.setPrefSize(140, 40);
        student1.setPrefSize(140, 40);
        professor1.setPrefSize(140, 40);
        delete.setPrefSize(140, 40);
        book2.setPrefSize(140, 40);
        student2.setPrefSize(140, 40);
        professor2.setPrefSize(140, 40);
        borret.setPrefSize(140, 40);
        reborts.setPrefSize(140, 40);
        clear.setPrefSize(140, 40);
        exit.setPrefSize(140, 40);
        student3.setPrefSize(140, 40);
        prof3.setPrefSize(140, 40);
        book4.setPrefSize(140, 40);
        student4.setPrefSize(140, 40);
        professor4.setPrefSize(140, 40);
        stbooks.setPrefSize(140, 40);
        profbooks.setPrefSize(140, 40);

        StackPane p = new StackPane();
        Label lbl = new Label("An-Najah National University Library");
        p.getChildren().add(lbl);
        BorderPane pane = new BorderPane();
        pane.setTop(p);

        
        hBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        hBox.getChildren().addAll(add, delete, borret, reborts,clear, exit);
        hBox.setStyle("-fx-border-color: red");
        hBox.setAlignment(Pos.CENTER);
        pane2.setTop(hBox);

        pane.setCenter(pane2);

        add.setOnAction(e -> {

            add();
        });
        delete.setOnAction(e -> {
            delete();
        });

        borret.setOnAction(e -> {
            borret();
        });

        reborts.setOnAction(e -> {
            reports();
        });

        book1.setOnAction(e -> {
            addbookform();
        });

        student1.setOnAction(e -> {
            addstudentform();
        });

        professor1.setOnAction(e -> {
            addprofessorform();
        });

        book2.setOnAction(e -> {
            deletebook();
        });

        student2.setOnAction(e -> {
            deletestudent();
        });

        professor2.setOnAction(e -> {
            deleteprof();
        });

        student3.setOnAction(e -> {
            stborret();
        });

        prof3.setOnAction(e -> {
            profborret();
        });

        borrow.setOnAction(e -> {
            stbor();
        });

        ret.setOnAction(e -> {
            stret();
        });

        profbor.setOnAction(e -> {
            profbor();
        });

        profret.setOnAction(e -> {
            profret();
        });

        stbooks.setOnAction(e -> {
            stbooks();
        });

        profbooks.setOnAction(e -> {
            profbooks();
        });
        
         clear.setOnAction(e -> {
            clear();
        });
        exit.setOnAction(e -> {
            exit();
        });
       
        primaryStage.setResizable(false);
        Scene scene = new Scene(pane, 1500, 970);
        primaryStage.setTitle("FindGrade");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void add() {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(11.5, 1215, 13.5, 15));

        vBox.getChildren().addAll(book1, student1, professor1);

        pane2.setRight(vBox);

    }

    public void addbookform() {

        GridPane pane3 = new GridPane();
        TextField ISBN = new TextField();
        TextField bookName = new TextField();
        TextField AuthorName = new TextField();
        TextField DateofPublication = new TextField();

        pane3.setAlignment(Pos.CENTER);
        pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane3.setHgap(5.5);
        pane3.setVgap(5.5);
        pane3.setStyle("-fx-border-color: red");
        Label lbl = new Label("Adding new book");

        pane3.add(lbl, 2, 0);
        pane3.add(new Label("ISBN"), 0, 5);
        pane3.add(ISBN, 1, 5);
        pane3.add(new Label("Book name"), 3, 5);
        pane3.add(bookName, 4, 5);
        pane3.add(new Label("Author name"), 0, 7);
        pane3.add(AuthorName, 1, 7);
        pane3.add(new Label("Date of publication"), 3, 7);
        pane3.add(DateofPublication, 4, 7);
        pane3.add(add2, 2, 9);
        pane3.setPadding(new Insets(300, 300, 300, 300));
        pane2.setBottom(pane3);

        add2.setOnAction(e -> {
            String isbn = ISBN.getText();
            String bname = bookName.getText();
            String authname = AuthorName.getText();
            String date = DateofPublication.getText();
            System.out.println(isbn);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");
                connection.prepareStatement("insert into book(ISBN,bookFullName,AuthorName,DateofPublication,flag,borrow) values('"
                        + isbn + "','" + bname + "','" + authname + "','" + date + "',0,0)").execute();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane3.add(new Label("Data of book inserted succefully"), 2, 11);
        });
    }

    public void addstudentform() {
        GridPane pane4 = new GridPane();
        TextField stid = new TextField();
        TextField stname = new TextField();
        TextField collage = new TextField();
        pane4.setAlignment(Pos.CENTER);
        pane4.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane4.setHgap(5.5);
        pane4.setVgap(5.5);
        pane4.setStyle("-fx-border-color: red");
        Label lbl = new Label("Adding new student");

        pane4.add(lbl, 2, 0);
        pane4.add(new Label("Student id"), 1, 5);
        pane4.add(stid, 3, 5);
        pane4.add(new Label("Student name"), 1, 7);
        pane4.add(stname, 3, 7);
        pane4.add(new Label("Student Collage"), 1, 9);
        pane4.add(collage, 3, 9);
        pane4.add(add2, 2, 11);
        pane4.setPadding(new Insets(300, 300, 300, 300));
        pane2.setBottom(pane4);

        add2.setOnAction(e -> {
            String studentid = stid.getText();
            String studentname = stname.getText();
            String stcollage = collage.getText();

            System.out.println(studentid);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");
                connection.prepareStatement("insert into student(stid,stname,collage,flag,borrow) values('"
                        + studentid + "','" + studentname + "','" + stcollage + "',0,0)").execute();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane4.add(new Label("Data of Student inserted succefully"), 2, 13);
        });

    }

    public void addprofessorform() {
        GridPane pane5 = new GridPane();
        TextField profid = new TextField();
        TextField profname = new TextField();
        TextField profcollage = new TextField();
        pane5.setAlignment(Pos.CENTER);
        pane5.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane5.setHgap(5.5);
        pane5.setVgap(5.5);
        pane5.setStyle("-fx-border-color: red");
        Label lbl = new Label("Adding new student");

        pane5.add(lbl, 2, 0);
        pane5.add(new Label("Professor id"), 1, 5);
        pane5.add(profid, 3, 5);
        pane5.add(new Label("Professor name"), 1, 7);
        pane5.add(profname, 3, 7);
        pane5.add(new Label("Professor Collage"), 1, 9);
        pane5.add(profcollage, 3, 9);
        pane5.add(add2, 2, 11);
        pane5.setPadding(new Insets(300, 300, 300, 300));
        pane2.setBottom(pane5);

        add2.setOnAction(e -> {
            String professorid = profid.getText();
            String professorname = profname.getText();
            String professorcollage = profcollage.getText();

            System.out.println(professorid);
           
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");
                connection.prepareStatement("insert into professor(profid,profname,profcollage,flag,borrow) values('"
                        + professorid + "','" + professorname + "','" + professorcollage + "',0,0)").execute();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane5.add(new Label("Data of professor inserted succefully"), 2, 13);
           
        });

    }

    public void delete() {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(11.5, 1000, 13.5, 15));

        vBox.getChildren().addAll(book2, student2, professor2);

        pane2.setRight(vBox);
    }

    public void deletebook() {
        GridPane pane6 = new GridPane();
        TextField search = new TextField();
        pane6.setAlignment(Pos.CENTER);
        pane6.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane6.setHgap(5.5);
        pane6.setVgap(5.5);
        pane6.setPadding(new Insets(300, 300, 300, 300));
        Label lbl = new Label("Choose the wanted book");
        ComboBox<String> cbo = new ComboBox<>();
        cbo.setValue("All available books");
        String Details[] = new String[200];

        cbo.setPrefWidth(200);
        Button delete2 = new Button("Delete");

        pane6.add(new Label("Delete the book"), 2, 0);
        pane6.add(new Label("search"), 2, 4);
        pane6.add(search, 3, 4);
        pane6.add(lbl, 1, 5);
        pane6.add(cbo, 3, 5);
        pane6.add(delete2, 2, 7);

        pane2.setBottom(pane6);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  BookFullName from book where flag = 0 and borrow = 0";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String bookname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                Details[i] = bookname;
                i++;
            }
            items = FXCollections.observableArrayList(Details);
            cbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        delete2.setOnAction(e -> {
            String name = cbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update book set flag = 1 where BookFullName = '" + name + "'  ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane6.add(new Label("Book deleted succefully"), 2, 9);
        });

        search.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infobook[] = new String[200];
            String bookname = search.getText();
            System.out.println(bookname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select BookFullName from book where BookFullName like'" + bookname + "%' and flag =0 and borrow = 0 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String bookName = resultSet.getString(1);

                    infobook[i] = bookName;
                    i++;
                }
                items = FXCollections.observableArrayList(infobook);
                cbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void deletestudent() {
        GridPane pane6 = new GridPane();
        TextField search = new TextField();
        pane6.setAlignment(Pos.CENTER);
        pane6.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane6.setHgap(5.5);
        pane6.setVgap(5.5);
        pane6.setPadding(new Insets(300, 300, 300, 300));
        Label lbl = new Label("Choose the wanted student");
        ComboBox<String> cbo = new ComboBox<>();
        cbo.setValue("All availble students");
        String Details[] = new String[200];
        // ObservableList<String> items = FXCollections.observableArrayList();
        cbo.setPrefWidth(200);
        Button delete2 = new Button("Delete");

        pane6.add(new Label("Delete the student"), 2, 0);
        pane6.add(new Label("search"), 2, 4);
        pane6.add(search, 3, 4);
        pane6.add(lbl, 1, 5);
        pane6.add(cbo, 3, 5);
        pane6.add(delete2, 2, 7);
        pane2.setBottom(pane6);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  stName from student where flag = 0 and borrow = 0";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String studentname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                Details[i] = studentname;
                i++;
            }
            items = FXCollections.observableArrayList(Details);
            cbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        delete2.setOnAction(e -> {
            String name = cbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update student set flag = 1 where stName = '" + name + "' ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane6.add(new Label("student deleted succefully"), 2, 9);
        });

        search.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infostudent[] = new String[200];
            String stname = search.getText();
            System.out.println(stname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select stname from student where stname like'" + stname + "%' and flag =0 and borrow = 0 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String studentname = resultSet.getString(1);

                    infostudent[i] = studentname;
                    i++;
                }
                items = FXCollections.observableArrayList(infostudent);
                cbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void deleteprof() {
        GridPane pane6 = new GridPane();
        TextField search = new TextField();
        pane6.setAlignment(Pos.CENTER);
        pane6.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane6.setHgap(5.5);
        pane6.setVgap(5.5);
        pane6.setPadding(new Insets(300, 300, 300, 300));
        Label lbl = new Label("Choose the wanted professor");
        ComboBox<String> cbo = new ComboBox<>();
        cbo.setValue("All availble professors");
        String Details[] = new String[200];
        //ObservableList<String> items = FXCollections.observableArrayList();
        cbo.setPrefWidth(200);
        Button delete2 = new Button("Delete");

        pane6.add(new Label("Delete the professor"), 2, 0);
        pane6.add(new Label("search"), 2, 4);
        pane6.add(search, 3, 4);
        pane6.add(lbl, 1, 5);
        pane6.add(cbo, 3, 5);
        pane6.add(delete2, 2, 7);
        pane2.setBottom(pane6);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  profname from professor where flag = 0 and borrow = 0";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String profname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                Details[i] = profname;
                i++;
            }
            items = FXCollections.observableArrayList(Details);
            cbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        delete2.setOnAction(e -> {
            String name = cbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update professor set flag = 1 where profname = '" + name + "' ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane6.add(new Label("profesor deleted succefully"), 2, 9);
        });

        search.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infoprof[] = new String[200];
            String profname = search.getText();
            System.out.println(profname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select profname from professor where profname like'" + profname + "%' and flag =0 and borrow = 0 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String professorname = resultSet.getString(1);

                    infoprof[i] = professorname;
                    i++;
                }
                items = FXCollections.observableArrayList(infoprof);
                cbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void borret() {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(11.5, 790, 13.5, 15));

        vBox.getChildren().addAll(student3, prof3);

        pane2.setRight(vBox);

    }

    public void stborret() {
        HBox hBox = new HBox(50);
        hBox.setPadding(new Insets(300, 300, 300, 300));
        hBox.setAlignment(Pos.CENTER);
        borrow.setPrefSize(300, 60);
        ret.setPrefSize(300, 60);
        hBox.getChildren().addAll(borrow, ret);
        pane2.setBottom(hBox);

    }

    public void stbor() {
        ComboBox<String> bcbo = new ComboBox<>();
        bcbo.setValue("All availble books");
        String bDetails[] = new String[200];
        ComboBox<String> scbo = new ComboBox<>();
        scbo.setValue("All availble students");
        String sDetails[] = new String[200];
        TextField stsearch = new TextField();
        TextField booksearch = new TextField();
        Button borrow2 = new Button("Borrow");
        GridPane pane7 = new GridPane();
        pane7.setAlignment(Pos.CENTER);
        pane7.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane7.setHgap(5.5);
        pane7.setVgap(5.5);
        pane7.setPadding(new Insets(300, 300, 300, 300));

        pane7.add(new Label("Student borrow book"), 2, 0);
        pane7.add(new Label("Student"), 1, 2);
        pane7.add(new Label("Book"), 3, 2);
        pane7.add(stsearch, 1, 4);
        pane7.add(booksearch, 3, 4);
        pane7.add(scbo, 1, 6);
        pane7.add(bcbo, 3, 6);
        pane7.add(borrow2, 2, 8);

        pane2.setBottom(pane7);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  BookFullName from book where flag = 0 and borrow = 0";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String bookname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                bDetails[i] = bookname;
                i++;
            }
            items = FXCollections.observableArrayList(bDetails);
            bcbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  stName from student where flag = 0 and borrow =0 or borrow =1";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String studentname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                sDetails[i] = studentname;
                i++;
            }
            items2 = FXCollections.observableArrayList(sDetails);
            scbo.setItems(items2);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        borrow2.setOnAction(e -> {
            String bname = bcbo.getValue();

            String sname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("insert into sttake(bookname,studentname,flag) values('" + bname + "','" + sname + "',0)").execute();
                connection.prepareStatement("update student set borrow = 2 where stName = '" + sname + "'and borrow = 1 ").executeUpdate();
                connection.prepareStatement("update student set borrow = 1 where stName = '" + sname + "'and borrow = 0 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 1 where BookFullName = '" + bname + "'and borrow = 0 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }

            pane7.add(new Label("Borrow operation completed succefully"), 2, 10);
        });

       stsearch.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infostudent[] = new String[200];
            String stname = stsearch.getText();
            System.out.println(stname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select stname from student where stname like'" + stname + "%' and flag =0 and borrow = 0 or borrow = 1 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String studentname = resultSet.getString(1);

                    infostudent[i] = studentname;
                    i++;
                }
                items = FXCollections.observableArrayList(infostudent);
                scbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        booksearch.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infobook[] = new String[200];
            String bookname = booksearch.getText();
            System.out.println(bookname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select BookFullName from book where BookFullName like'" + bookname + "%' and flag =0 and borrow = 0 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String bookName = resultSet.getString(1);

                    infobook[i] = bookName;
                    i++;
                }
                items = FXCollections.observableArrayList(infobook);
                bcbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }

    public void stret() {
        ComboBox<String> scbo = new ComboBox<>();
        scbo.setValue("All availble students");
        String sDetails[] = new String[200];
        TextField stsearch = new TextField();
        TextField stname = new TextField();
        TextField stid = new TextField();
        TextField book1 = new TextField();
        TextField book2 = new TextField();
        Button stret1 = new Button("Retuen");
        Button stret2 = new Button("Return");
        Button show = new Button("show");
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));

        pane8.add(new Label("Student return book"), 2, 0);
        pane8.add(new Label("Students"), 1, 2);
        pane8.add(new Label("Student name"), 3, 2);
        pane8.add(stsearch, 1, 4);
        pane8.add(stname, 3, 4);
        pane8.add(show, 0, 6);
        pane8.add(scbo, 1, 6);
        pane8.add(new Label("Book1"), 3, 8);
        pane8.add(book1, 3, 10);
        pane8.add(stret1, 5, 10);
        pane8.add(new Label("Book2"), 3, 12);
        pane8.add(book2, 3, 14);
        pane8.add(stret2, 5, 14);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  stName from student where flag = 0 and borrow = 1 or borrow = 2";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String studentname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                sDetails[i] = studentname;
                i++;
            }
            items = FXCollections.observableArrayList(sDetails);
            scbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        stsearch.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infostudent[] = new String[200];
            String name = stsearch.getText();
            System.out.println(name);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select stname from student where stname like'" + name + "%' and flag =0 and borrow = 1 or borrow = 2 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String studentname = resultSet.getString(1);

                    infostudent[i] = studentname;
                    i++;
                }
                items = FXCollections.observableArrayList(infostudent);
                scbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        show.setOnAction(e -> {
            String name = scbo.getValue();
            ResultSet result = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = ("select stname from student where flag = 0 and stname =  '" + name + "'");
                preparedStatement = connection.prepareStatement(sql);
                result = preparedStatement.executeQuery();
                String studentname = null;
                while (result.next()) {
                    studentname = result.getString(1);

                }
                stname.setText(studentname);

                String sname = stname.getText();
                String Sql = "select bookname from sttake where flag = 0 and studentname = '" + sname + "'";
                preparedStatement = connection.prepareStatement(Sql);
                result = preparedStatement.executeQuery();
                String bookname = null;
                while (result.next()) {
                    bookname = result.getString(1);
                }

                book1.setText(bookname);

                String bn = book1.getText();
                System.out.println(bn);

                String SQL = "select bookname from sttake where flag = 0 and studentname = '" + sname + "' and bookname != '" + bn + "'";
                preparedStatement = connection.prepareStatement(SQL);
                result = preparedStatement.executeQuery();
                String bookname2 = null;
                while (result.next()) {
                    bookname2 = result.getString(1);
                }
                book2.setText(bookname2);

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        });

        stret1.setOnAction(e -> {

            String bname = book1.getText();

            String sname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update sttake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update student set borrow = 0 where stName = '" + sname + "'and borrow = 1 ").executeUpdate();
                connection.prepareStatement("update student set borrow = 1 where stName = '" + sname + "'and borrow = 2 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }

            pane8.add(new Label("Book1 is returned succefully"), 6, 10);
        });

        stret2.setOnAction(e -> {

            String bname = book2.getText();

            String sname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update sttake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update student set borrow = 0 where stName = '" + sname + "'and borrow = 1 ").executeUpdate();
                connection.prepareStatement("update student set borrow = 1 where stName = '" + sname + "'and borrow = 2 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book2 is retrned succefully"), 6, 14);
        });

        pane2.setBottom(pane8);

    }

    public void profborret() {
        HBox hBox = new HBox(50);
        hBox.setPadding(new Insets(300, 300, 300, 300));
        hBox.setAlignment(Pos.CENTER);
        profbor.setPrefSize(300, 60);
        profret.setPrefSize(300, 60);
        hBox.getChildren().addAll(profbor, profret);
        pane2.setBottom(hBox);
    }

    public void profbor() {
        ComboBox<String> bcbo = new ComboBox<>();
        bcbo.setValue("All availble books");
        String bDetails[] = new String[200];
        ComboBox<String> scbo = new ComboBox<>();
        scbo.setValue("All availble professors");
        String sDetails[] = new String[200];
        TextField profsearch = new TextField();
        TextField booksearch = new TextField();
        Button borrow2 = new Button("Borrow");
        GridPane pane7 = new GridPane();
        pane7.setAlignment(Pos.CENTER);
        pane7.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane7.setHgap(5.5);
        pane7.setVgap(5.5);
        pane7.setPadding(new Insets(300, 300, 300, 300));

        pane7.add(new Label("prfessor borrow book"), 2, 0);
        pane7.add(new Label("professor"), 1, 2);
        pane7.add(new Label("Book"), 3, 2);
        pane7.add(profsearch, 1, 4);
        pane7.add(booksearch, 3, 4);
        pane7.add(scbo, 1, 6);
        pane7.add(bcbo, 3, 6);
        pane7.add(borrow2, 2, 8);
        pane2.setBottom(pane7);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  BookFullName from book where flag = 0 and borrow = 0";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String bookname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                bDetails[i] = bookname;
                i++;
            }
            items = FXCollections.observableArrayList(bDetails);
            bcbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  profname from professor where flag = 0 and borrow =0 or borrow = 1 or borrow = 2 or borrow = 3 or borrow=4";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String profname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                sDetails[i] = profname;
                i++;
            }
            items2 = FXCollections.observableArrayList(sDetails);
            scbo.setItems(items2);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        borrow2.setOnAction(e -> {
            String bname = bcbo.getValue();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("insert into proftake(bookname,profname,flag) values('" + bname + "','" + pname + "',0)").execute();
                connection.prepareStatement("update professor set borrow = 5 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "' and borrow =3").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =2 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "'and borrow =0 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 1 where BookFullName = '" + bname + "'and borrow = 0 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }

            pane7.add(new Label("Borrow operation completed succefully"), 2, 10);
        });

        profsearch.setOnKeyReleased(e -> {
            items2.clear();
            //pane6.getChildren().clear();

            String infostudent[] = new String[200];
            String profname = profsearch.getText();
            System.out.println(profname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select profname from professor where profname like'" + profname + "%' and flag =0 and borrow = 0 or borrow = 2 or borrow = 3 or borrow=4";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String studentname = resultSet.getString(1);

                    infostudent[i] = studentname;
                    i++;
                }
                items2 = FXCollections.observableArrayList(infostudent);
                scbo.setItems(items2);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        booksearch.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infobook[] = new String[200];
            String bookname = booksearch.getText();
            System.out.println(bookname);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select BookFullName from book where BookFullName like'" + bookname + "%' and flag =0 and borrow = 0 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String bookName = resultSet.getString(1);

                    infobook[i] = bookName;
                    i++;
                }
                items = FXCollections.observableArrayList(infobook);
                bcbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void profret() {

        ComboBox<String> scbo = new ComboBox<>();
        scbo.setValue("All availble professors");
        String pDetails[] = new String[200];
        TextField profsearch = new TextField();
        TextField profname = new TextField();
        TextField book1 = new TextField();
        TextField book2 = new TextField();
        TextField book3 = new TextField();
        TextField book4 = new TextField();
        TextField book5 = new TextField();
        Button show = new Button("show");
        Button profret1 = new Button("Retuen");
        Button profret2 = new Button("Return");
        Button profret3 = new Button("Return");
        Button profret4 = new Button("Return");
        Button profret5 = new Button("Return");
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));

        pane8.add(new Label("professor return book"), 2, 0);
        pane8.add(new Label("professors"), 1, 2);
        pane8.add(new Label("professor name"), 3, 2);
        pane8.add(profsearch, 1, 4);
        pane8.add(profname, 3, 4);
        pane8.add(scbo, 1, 6);
        pane8.add(show, 0, 6);
        pane8.add(new Label("Book1"), 3, 6);
        pane8.add(book1, 3, 8);
        pane8.add(profret1, 5, 8);
        pane8.add(new Label("Book2"), 3, 10);
        pane8.add(book2, 3, 12);
        pane8.add(profret2, 5, 12);
        pane8.add(new Label("Book3"), 3, 14);
        pane8.add(book3, 3, 16);
        pane8.add(profret3, 5, 16);
        pane8.add(new Label("Book4"), 3, 18);
        pane8.add(book4, 3, 20);
        pane8.add(profret4, 5, 20);
        pane8.add(new Label("Book5"), 3, 22);
        pane8.add(book5, 3, 24);
        pane8.add(profret5, 5, 24);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
            System.out.println("Database connected");

            String sql = "select  profname from professor where flag = 0 and borrow = 1 or borrow = 2 or borrow = 3 or borrow = 4 or borrow = 5";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                String professorname = resultSet.getString(1);

                //String name = ssn+" "+ firstName+" "+mi+" "+lastName;
                pDetails[i] = professorname;
                i++;
            }
            items = FXCollections.observableArrayList(pDetails);
            scbo.setItems(items);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        profsearch.setOnKeyReleased(e -> {
            items.clear();
            //pane6.getChildren().clear();

            String infoprof[] = new String[200];
            String name = profsearch.getText();
            System.out.println(name);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = "select profname from professor where profname like'" + name + "%' and flag =0 and borrow = 1 or borrow = 2 or borrow = 3 or borrow = 4 or borrow = 5 ";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                int i = 0;
                while (resultSet.next()) {

                    String studentname = resultSet.getString(1);

                    infoprof[i] = studentname;
                    i++;
                }
                items = FXCollections.observableArrayList(infoprof);
                scbo.setItems(items);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        show.setOnAction(e -> {
            String name = scbo.getValue();
            ResultSet result = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                String sql = ("select profname from professor where flag = 0 and profname =  '" + name + "'");
                preparedStatement = connection.prepareStatement(sql);
                result = preparedStatement.executeQuery();
                String studentname = null;
                while (result.next()) {
                    studentname = result.getString(1);

                }
                profname.setText(studentname);

                String pname = profname.getText();
                String Sql = "select bookname from proftake where flag = 0 and profname = '" + pname + "'";
                preparedStatement = connection.prepareStatement(Sql);
                result = preparedStatement.executeQuery();
                String bookname = null;
                while (result.next()) {
                    bookname = result.getString(1);
                }

                book1.setText(bookname);

                String bn = book1.getText();
                System.out.println(bn);

                String SQL = "select bookname from proftake where flag = 0 and profname = '" + pname + "' and bookname != '" + bn + "'";
                preparedStatement = connection.prepareStatement(SQL);
                result = preparedStatement.executeQuery();
                String bookname2 = null;
                while (result.next()) {
                    bookname2 = result.getString(1);
                }
                book2.setText(bookname2);

                String bn2 = book2.getText();
                System.out.println(bn);

                String SQL2 = "select bookname from proftake where flag = 0 and profname = '" + pname + "' and bookname != '" + bn + "' and bookname != '" + bn2 + "'";
                preparedStatement = connection.prepareStatement(SQL2);
                result = preparedStatement.executeQuery();
                String bookname3 = null;
                while (result.next()) {
                    bookname3 = result.getString(1);
                }
                book3.setText(bookname3);

                String bn3 = book3.getText();
                System.out.println(bn);

                String SQL3 = "select bookname from proftake where flag = 0 and profname = '" + pname + "' and bookname != '" + bn + "' and bookname != '" + bn2 + "' and bookname != '" + bn3 + "'";
                preparedStatement = connection.prepareStatement(SQL3);
                result = preparedStatement.executeQuery();
                String bookname4 = null;
                while (result.next()) {
                    bookname4 = result.getString(1);
                }
                book4.setText(bookname4);

                String bn4 = book4.getText();
                System.out.println(bn);

                String SQL4 = "select bookname from proftake where flag = 0 and profname = '" + pname + "' and bookname != '" + bn + "' and bookname != '" + bn2 + "' and bookname != '" + bn3 + "' and bookname != '" + bn4 + "'";
                preparedStatement = connection.prepareStatement(SQL4);
                result = preparedStatement.executeQuery();
                String bookname5 = null;
                while (result.next()) {
                    bookname5 = result.getString(1);
                }
                book5.setText(bookname5);

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        });

        profret1.setOnAction(e -> {
            String bname = book1.getText();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update proftake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update professor set borrow = 0 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "' and borrow =2").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =3 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "'and borrow =5 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book1 is returned succefully"), 6, 8);
        });
        profret2.setOnAction(e -> {

            String bname = book2.getText();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update proftake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update professor set borrow = 0 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "' and borrow =2").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =3 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "'and borrow =5 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book2 is retrned succefully"), 6, 12);
        });
        profret3.setOnAction(e -> {

            String bname = book3.getText();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update proftake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update professor set borrow = 0 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "' and borrow =2").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =3 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "'and borrow =5 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book3 is retrned succefully"), 6, 16);
        });
        profret4.setOnAction(e -> {
            String bname = book4.getText();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update proftake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update professor set borrow = 0 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "' and borrow =2").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =3 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "'and borrow =5 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book4 is retrned succefully"), 6, 20);
        });
        profret5.setOnAction(e -> {
            String bname = book5.getText();

            String pname = scbo.getValue();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");
                System.out.println("Database connected");

                connection.prepareStatement("update proftake set flag = 1 where bookname = '" + bname + "'").executeUpdate();
                connection.prepareStatement("update professor set borrow = 0 where profname = '" + pname + "'and borrow =1 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 1 where profname = '" + pname + "' and borrow =2").executeUpdate();
                connection.prepareStatement("update professor set borrow = 2 where profname = '" + pname + "'and borrow =3 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 3 where profname = '" + pname + "'and borrow =4 ").executeUpdate();
                connection.prepareStatement("update professor set borrow = 4 where profname = '" + pname + "'and borrow =5 ").executeUpdate();
                connection.prepareStatement("update book set borrow = 0 where BookFullName = '" + bname + "'and borrow = 1 ").executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();

            }
            pane8.add(new Label("Book5 is retrned succefully"), 6, 24);
        });

        pane2.setBottom(pane8);

    }

    public void reports() {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(11.5, 580, 13.5, 15));

        vBox.getChildren().addAll(book4, student4, professor4, stbooks, profbooks);

        pane2.setRight(vBox);

        book4.setOnAction(e -> {
            repbook();
        });
        student4.setOnAction(e -> {
            repst();
        });
        professor4.setOnAction(e -> {
            repprof();
        });
        stbooks.setOnAction(e -> {
            stbooks();
        });
        profbooks.setOnAction(e -> {
            profbooks();
        });
    }

    public void repbook() {
        Button foundedbooks = new Button("Founded books");
        Button borroowedbooks = new Button("Borrowed books");
        Button deletedbooks = new Button("Deleted books");
        HBox hBox = new HBox(50);
        hBox.setPadding(new Insets(300, 300, 300, 300));
        hBox.setAlignment(Pos.CENTER);
        profbor.setPrefSize(300, 60);
        profret.setPrefSize(300, 60);
        hBox.getChildren().addAll(foundedbooks, borroowedbooks, deletedbooks);
        pane2.setBottom(hBox);

        foundedbooks.setOnAction(e -> {
            foundedbooks();
        });
        borroowedbooks.setOnAction(e -> {
            borroowedbooks();
        });
        deletedbooks.setOnAction(e -> {
            deletedbooks();
        });
    }

    public void foundedbooks() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Founded Books"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select ISBN, BookFullName,AuthorName,DateOfPublication from book where flag = 0 and borrow = 0";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String isbn = result.getString(1);
                String name = result.getString(2);
                String authorname = result.getString(3);
                String DateOfPublication = result.getString(4);

                rrr = rrr+" \n" + "The book has an ISBN : " + isbn + " , and name : " + name + ", and the author of this book is : " + authorname + " and the date of publication is : " + DateOfPublication + "\n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void borroowedbooks() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Borrowed Books"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select ISBN, BookFullName,AuthorName,DateOfPublication from book where flag = 0 and borrow = 1";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String isbn = result.getString(1);
                String name = result.getString(2);
                String authorname = result.getString(3);
                String DateOfPublication = result.getString(4);

                rrr = rrr +" \n"+ "The book has an ISBN : " + isbn + " , and name : " + name + ", and the author of this book is : " + authorname + " and the date of publication is : " + DateOfPublication + "\n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void deletedbooks() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Deleted Books"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select ISBN, BookFullName,AuthorName,DateOfPublication from book where flag = 1";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String isbn = result.getString(1);
                String name = result.getString(2);
                String authorname = result.getString(3);
                String DateOfPublication = result.getString(4);

                rrr = rrr +" \n"+ "The book has an ISBN : " + isbn + " , and name : " + name + ", and the author of this book is : " + authorname + " and the date of publication is : " + DateOfPublication + "\n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void repst() {
        Button foundedst = new Button("Founded students");
        Button borrowerst = new Button("Borrower students");
        Button deletedst = new Button("Deleted students");
        HBox hBox = new HBox(50);
        hBox.setPadding(new Insets(300, 300, 300, 300));
        hBox.setAlignment(Pos.CENTER);
        profbor.setPrefSize(300, 60);
        profret.setPrefSize(300, 60);
        hBox.getChildren().addAll(foundedst, borrowerst, deletedst);
        pane2.setBottom(hBox);
        foundedst.setOnAction(e -> {
            foundedst();
        });
        borrowerst.setOnAction(e -> {
            borrowerst();
        });
        deletedst.setOnAction(e -> {
            deletedst();
        });
    }

    public void foundedst() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Founded students"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select stid, stname,collage from student where flag = 0 and borrow = 0";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr+" \n" + "The student has an id : " + id + " , and name : " + name + ", and this student study is  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void borrowerst() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Borrower students"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select stid, stname,collage from student where flag = 0 and borrow = 1 or borrow = 2";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr+" \n" + "The student has an id : " + id + " , and name : " + name + ", and this student study is  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void deletedst() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Deleted students"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select stid, stname,collage from student where flag = 1";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr +" \n"+ "The student has an id : " + id + " , and name : " + name + ", and this student study is  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void repprof() {
        Button foundedprof = new Button("Founded professors");
        Button borrowerprof = new Button("Borrower professors");
        Button deletedprof = new Button("Deleted professors");
        HBox hBox = new HBox(50);
        hBox.setPadding(new Insets(300, 300, 300, 300));
        hBox.setAlignment(Pos.CENTER);
        profbor.setPrefSize(300, 60);
        profret.setPrefSize(300, 60);
        hBox.getChildren().addAll(foundedprof, borrowerprof, deletedprof);
        pane2.setBottom(hBox);

        foundedprof.setOnAction(e -> {
            foundedprof();
        });
        borrowerprof.setOnAction(e -> {
            borrowerprof();
        });
        deletedprof.setOnAction(e -> {
            deletedprof();
        });
    }

    public void foundedprof() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Founded professors"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select profid, profname,profcollage from professor where flag = 0 and borrow = 0";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr+" \n" + "The professor has an id : " + id + " , and name : " + name + ", and he is prof in  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void borrowerprof() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Borrower professors"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select profid, profname,profcollage from professor where flag = 0 and borrow = 1 or borrow = 2 or borrow = 3 or borrow = 4 or borrow = 5 ";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr+" \n" + "The professor has an id : " + id + " , and name : " + name + ", and he is prof in  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void deletedprof() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("Deleted professors"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select profid, profname,profcollage from professor where flag = 1 ";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String id = result.getString(1);
                String name = result.getString(2);
                String collage = result.getString(3);

                rrr = rrr+" \n" + "The professor has an id : " + id + " , and name : " + name + ", and he is prof in  : " + collage + " collage \n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void stbooks() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("students books"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select bookname, studentname from sttake where flag = 0 ";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String bookname = result.getString(1);
                String studentname = result.getString(2);

                rrr = rrr +" \n"+ bookname + " book is borrowed by student (" + studentname + ")";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void profbooks() {
        TextArea fb = new TextArea();
        GridPane pane8 = new GridPane();
        pane8.setAlignment(Pos.CENTER);
        pane8.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane8.setHgap(5.5);
        pane8.setVgap(5.5);
        pane8.setPadding(new Insets(300, 300, 300, 300));
        pane8.add(new Label("professors books"), 0, 0);
        pane8.add(fb, 0, 2);
        pane2.setBottom(pane8);

        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oopproject?user=root");

            String sql = "select bookname, profname from proftake where flag = 0 ";
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            String rrr = null;
            while (result.next()) {
                String bookname = result.getString(1);
                String profname = result.getString(2);

                rrr = rrr +" \n"+ bookname + " book is borrowed by professor ( " + profname + " )\n";
            }

            fb.setText(rrr);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void exit() {
        System.exit(0);
        
    }
    public void clear(){
       pane2.getChildren().clear();
       pane2.setTop(hBox);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
