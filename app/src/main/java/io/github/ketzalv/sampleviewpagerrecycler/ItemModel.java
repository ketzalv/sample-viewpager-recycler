package io.github.ketzalv.sampleviewpagerrecycler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemModel {
    private String name;
    private String image;
    private String description;

    public static List<ItemModel> getItemsDummies() {
        List<ItemModel> items = new ArrayList<>();
        Random random = new Random();
        int randomInteger = random.nextInt(10);
        for(int itemIndex = 0; itemIndex < randomInteger; itemIndex++){
            ItemModel item = new ItemModel();
            item.setName("Item name: " + itemIndex);
            items.add(item);
        }
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
