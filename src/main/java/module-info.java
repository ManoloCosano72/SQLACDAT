module com.github.ManoloCosano72 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;

    opens com.github.ManoloCosano72 to javafx.fxml;
    opens com.github.ManoloCosano72.model.connection to java.xml.bind;

    exports com.github.ManoloCosano72;
    exports com.github.ManoloCosano72.view;
    opens com.github.ManoloCosano72.view to javafx.fxml;
    exports com.github.ManoloCosano72.model.utils;
    exports com.github.ManoloCosano72.model.test;

    opens com.github.ManoloCosano72.utils to javafx.fxml;
    exports com.github.ManoloCosano72.model.connection;
}
