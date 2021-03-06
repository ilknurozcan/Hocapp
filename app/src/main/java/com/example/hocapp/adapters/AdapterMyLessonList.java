package com.example.hocapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hocapp.MainActivity;
import com.example.hocapp.R;
import com.example.hocapp.models.LessonModel;

import java.util.ArrayList;

public class AdapterMyLessonList extends RecyclerView.Adapter {
    public ArrayList arrayList;
    public Context context;




    public AdapterMyLessonList(ArrayList listdata, Context context) {

        this.arrayList = listdata;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View list = MainActivity.inflater.inflate(R.layout.mylesson_card_item, parent, false);
        return new listItem(list);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final listItem listItem = (AdapterMyLessonList.listItem) holder;
        final LessonModel list = (LessonModel) arrayList.get(position);

        listItem.lessonName.setText(list.getLesson());
        listItem.lessonField.setText(list.getLessonField());
        listItem.lessonPrice.setText(list.getLessonPrice());
        listItem.lessonCity.setText(list.getLessonCity());



        listItem.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
                notifyDataSetChanged();

            }
        });


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class listItem extends RecyclerView.ViewHolder{

        public TextView userName;
        public TextView lessonName;
        public TextView lessonField;
        public TextView lessonPrice;
        public ImageView image_delete;
        //  public TextView lessonLatLng;
        public TextView lessonCity;


        public listItem(@NonNull View itemView) {
            super(itemView);

            lessonName = itemView.findViewById(R.id.lessonName);
            lessonField = itemView.findViewById(R.id.lessonField);
            lessonPrice = itemView.findViewById(R.id.lessonPrice);
            image_delete=itemView.findViewById(R.id.image_delete);
            lessonCity=itemView.findViewById(R.id.lessonCity);


        }
    }

}
