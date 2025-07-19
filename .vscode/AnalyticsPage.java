import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AnalyticsPage extends VBox {

    public AnalyticsPage() {
        setPadding(new Insets(20));
        setSpacing(20);

        Text title = new Text("Analytics Dashboard");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // === PIE CHART ===
        PieChart pieChart = new PieChart();
        pieChart.setTitle("User Engagement");
        pieChart.getData().add(new PieChart.Data("Posts", 40));
        pieChart.getData().add(new PieChart.Data("Likes", 35));
        pieChart.getData().add(new PieChart.Data("Comments", 25));

        // === LINE CHART ===
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Week");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Activity Count");

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Weekly Activity Trend");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Engagement Over Time");
        series.getData().add(new XYChart.Data<>("Week 1", 20));
        series.getData().add(new XYChart.Data<>("Week 2", 35));
        series.getData().add(new XYChart.Data<>("Week 3", 28));
        series.getData().add(new XYChart.Data<>("Week 4", 50));

        lineChart.getData().add(series);

        // === COMBINE BOTH CHARTS ===
        HBox chartContainer = new HBox(20, pieChart, lineChart);
        chartContainer.setAlignment(Pos.CENTER);

        getChildren().addAll(title, chartContainer);
    }
}
