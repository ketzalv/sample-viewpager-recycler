package io.github.ketzalv.sampleviewpagerrecycler;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageModel implements Parcelable {
    private String name;
    private String description;
    private List<ItemModel> items;

    public static List<PageModel> getDummies(){
        List<PageModel> dummies = new ArrayList<>();
        for(int index = 0; index < 10; index++){
            PageModel model = new PageModel();
            model.setName("Page Position: " + index);
            model.setDescription("This is a description of position: " + index);
            model.setItems(ItemModel.getItemsDummies());
            dummies.add(model);

        }
        return dummies;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeList(this.items);
    }

    public PageModel() {
    }

    protected PageModel(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.items = new ArrayList<ItemModel>();
        in.readList(this.items, ItemModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<PageModel> CREATOR = new Parcelable.Creator<PageModel>() {
        @Override
        public PageModel createFromParcel(Parcel source) {
            return new PageModel(source);
        }

        @Override
        public PageModel[] newArray(int size) {
            return new PageModel[size];
        }
    };
}
