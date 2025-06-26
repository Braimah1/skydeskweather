module WeatherApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires org.json;
	
	opens WeatherApplication to javafx.graphics, javafx.fxml;
}
