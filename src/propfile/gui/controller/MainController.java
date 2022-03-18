package propfile.gui.controller;

//Java imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//Project imports
import javafx.scene.control.TextArea;
import propfile.dal.DBConnector;


public class MainController {

    @FXML
    private TextArea txtOutput;
    @FXML
    private Button btnConnectToDB;

    /**
     *
     */
    public void handleConnectToDB(ActionEvent actionEvent) {
        getData();
    }


    /**
     *
     */
    private void getData() {

        try (Connection conn = new DBConnector().getConnection()) {
            String sql = "SELECT * FROM Users";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            StringBuilder sb = new StringBuilder();

            while (rs.next()) {
                sb.append("\nWelcome " + rs.getString("username") + " " + rs.getString("password"));
            }

            txtOutput.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
