module org.una.cliente_aeropuerto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.jfoenix;
    requires com.google.gson;

    opens org.una.cliente_aeropuerto to javafx.fxml;
    opens org.una.cliente_aeropuerto.Controllers to javafx.fxml;
    exports org.una.cliente_aeropuerto;
    exports org.una.cliente_aeropuerto.Controllers;
}
