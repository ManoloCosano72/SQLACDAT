module com.github.ManoloCosano72 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.github.ManoloCosano72 to javafx.fxml;
    exports com.github.ManoloCosano72;
}
