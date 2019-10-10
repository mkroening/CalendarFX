package impl.com.calendarfx.view;

import com.calendarfx.view.RecurrenceExceptionView;
import javafx.scene.control.Button;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class RecurrenceExceptionViewSkin extends SkinBase<RecurrenceExceptionView> {

    public RecurrenceExceptionViewSkin(RecurrenceExceptionView control) {
        super(control);

        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().add("container");
        gridPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // button bar
        Button cancelBtn = new Button("Cancel");
        cancelBtn.onActionProperty().bind(control.onCancelProperty());

        HBox buttonsBar = new HBox();
        buttonsBar.getStyleClass().add("button-bar");
        buttonsBar.getChildren().addAll(cancelBtn);

        gridPane.add(buttonsBar, 2, 1);

        getChildren().add(gridPane);

    }

}
