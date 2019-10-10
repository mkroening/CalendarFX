package com.calendarfx.view;

import impl.com.calendarfx.view.RecurrenceExceptionViewSkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import static java.util.Objects.requireNonNull;

public class RecurrenceExceptionView extends CalendarFXControl {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RecurrenceExceptionViewSkin(this);
    }

    private final ObjectProperty<EventHandler<ActionEvent>> onCancel = new SimpleObjectProperty<>(
            this, "onCancel", evt -> hide());


    public final ObjectProperty<EventHandler<ActionEvent>> onCancelProperty() {
        return onCancel;
    }

    public final EventHandler<ActionEvent> getOnCancel() {
        return onCancelProperty().get();
    }

    public final void setOnCancel(EventHandler<ActionEvent> handler) {
        onCancelProperty().set(handler);
    }

    private Stage dialog;

    private final ObjectProperty<Image> recurrenceExceptionIcon = new SimpleObjectProperty<>(
            this, "recurrenceExceptionIcon", null);

    public final ObjectProperty<Image> recurrenceExceptionIconProperty() {
        return recurrenceExceptionIcon;
    }

    public final void setRecurrenceExceptionIcon(Image image) {
        requireNonNull(image);
        recurrenceExceptionIconProperty().set(image);
    }

    public final Image getRecurrenceExceptionIcon() {
        return recurrenceExceptionIcon.get();
    }

    public void show(Window owner) {
        if (dialog != null) {
            dialog.show();
        } else {
            Scene scene = new Scene(this);
            dialog = new Stage();
            dialog.initOwner(owner);
            dialog.setScene(scene);
            dialog.sizeToScene();
            dialog.centerOnScreen();
            dialog.setTitle("RecurrenceExceptionViewTitle");
            dialog.initModality(Modality.APPLICATION_MODAL);
            if (getRecurrenceExceptionIcon() != null)
                dialog.getIcons().add(getRecurrenceExceptionIcon());

            dialog.show();
        }
    }

    public final void hide() {
        if (dialog != null) {
            dialog.hide();
        }
    }
}
