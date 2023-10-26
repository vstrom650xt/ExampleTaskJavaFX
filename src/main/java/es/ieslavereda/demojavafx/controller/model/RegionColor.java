package es.ieslavereda.demojavafx.controller.model;


import javax.swing.plaf.synth.Region;
import java.awt.*;

public class RegionColor {
        private Region region;
        private Color color;

        public RegionColor(Region region, Color color) {
            this.region = region;
            this.color = color;
        }

        public Region getRegion() {
            return region;
        }

        public Color getColor() {
            return color;
        }

}
