module sample.pool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Sample.View to javafx.fxml;
    exports Sample.View;
}