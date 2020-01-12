package com.azhar.quranretrofit.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.quranretrofit.R;
import com.azhar.quranretrofit.activities.SurahActivity;
import com.azhar.quranretrofit.model.Surah;
import com.google.gson.Gson;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.Holder> {

    private Context context;
    private List<Surah> list;
    private List<Surah> listIndo;
    private View view;

    public SurahAdapter(Context context, List<Surah> list, List<Surah> listIndo) {
        this.context = context;
        this.list = list;
        this.listIndo = listIndo;
    }

    public SurahAdapter(Context context, List<Surah> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new Holder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        final Surah surah = list.get(position);
        final Surah surahIndo = listIndo.get(position);

        holder.numberSurah.setText(surah.getNumber());
        holder.titleSurah.setText(surah.getName());
        holder.translationTitle.setText(surah.getTranslateName());
        holder.typeTitle.setText(surah.getType());
        holder.ayatSize.setText(surah.getAyatList().size() +" ayat");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String json = gson.toJson(surah.getAyatList());
                String jsonIndo = gson.toJson(surahIndo.getAyatList());
                Intent intent = new Intent(context, SurahActivity.class);
                intent.putExtra("jsonlist", json);
                intent.putExtra("jsonlistIndo", jsonIndo);
                intent.putExtra("jsonTitle", surah.getEnglishName());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView numberSurah, titleSurah, translationTitle, typeTitle, ayatSize;

        public Holder(View itemView) {
            super(itemView);
            numberSurah = itemView.findViewById(R.id.number_surah);
            titleSurah = itemView.findViewById(R.id.title_surah);
            translationTitle = itemView.findViewById(R.id.translation_title);
            typeTitle = itemView.findViewById(R.id.type_surah);
            ayatSize = itemView.findViewById(R.id.ayat_size);
        }
    }
}
