package io.github.ketzalv.sampleviewpagerrecycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView textItemName;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textItemName = itemView.findViewById(R.id.text_item_name);
    }

    public void bind(ItemModel itemModel) {
        textItemName.setText(itemModel.getName());
    }
}
