package com.example.mbura.staj11;

/**
 * Created by mbura on 25.07.2017.
 */

public class Model {


        private String name;
        private boolean selected;

        public Model(String name) {
            this.name = name;
            selected = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

    }

