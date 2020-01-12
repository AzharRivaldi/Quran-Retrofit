package com.azhar.quranretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.quranretrofit.R;
import com.azhar.quranretrofit.model.Ayat;

import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.Holder> {

    private Context context;
    private List<Ayat> list;
    private List<Ayat> listIndo;

    public AyatAdapter(Context context, List<Ayat> list, List<Ayat> listIndo) {
        this.context = context;
        this.list = list;
        this.listIndo = listIndo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_ayat, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Ayat ayat = list.get(position);
        Ayat ayatIndo = listIndo.get(position);
        holder.nomorAyat.setText(ayat.getNumberInSurah());
        holder.arabic.setText(ayat.getText());
        holder.tarjim.setText(ayatIndo.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView nomorAyat, arabic, tarjim;

        public Holder(View itemView) {
            super(itemView);
            nomorAyat = itemView.findViewById(R.id.number_ayat);
            arabic = itemView.findViewById(R.id.arabic);
            tarjim = itemView.findViewById(R.id.tarjim);
        }
    }
}
