package com.example.mbura.staj10;

/**
 * Created by mbura on 24.07.2017.
 */
public class ListItem {

    String id;
    String category;
    String description;
    boolean Selected;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        this.Selected = Selected;
    }
}

