package com.ericsson.eqinson.usingLambda;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by eqinson on 2016/10/1.
 */
public class LatentImage extends Image {
    private List<UnaryOperator<Color>> pendingOperations;

    public LatentImage(String url) {
        super(url);
    }

    public static void main(String[] args) {
        LatentImage image = new LatentImage("http://docs.oracle" +
                ".com/javafx/javafx/images/javafx-documentation.png");
        image.transform(Color::brighter).transform(Color::grayscale).toImage();
    }

    LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) this.getWidth();
        int height = (int) this.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color color = this.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations)
                    color = f.apply(color);
                out.getPixelWriter().setColor(x, y, color);
            }
        return out;
    }
}
