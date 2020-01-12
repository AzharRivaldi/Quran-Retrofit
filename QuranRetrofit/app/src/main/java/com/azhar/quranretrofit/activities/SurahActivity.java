package com.azhar.quranretrofit.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.quranretrofit.R;
import com.azhar.quranretrofit.adapter.AyatAdapter;
import com.azhar.quranretrofit.model.Ayat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SurahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_content);

        Toolbar mToolbarSurah = findViewById(R.id.mToolbarSurah);
        setSupportActionBar(mToolbarSurah);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String json = getIntent().getStringExtra("jsonlist");
        String jsonIndo = getIntent().getStringExtra("jsonlistIndo");
        String jsonTitle = getIntent().getStringExtra("jsonTitle");
        Type type = new TypeToken<List<Ayat>>() {
        }.getType();

        TextView txtTitleSurah = findViewById(R.id.txtTitleSurah);
        txtTitleSurah.setText(jsonTitle);
        txtTitleSurah.findViewById(R.id.txtTitleSurah);
        txtTitleSurah.setText(jsonTitle);

        Gson gson = new Gson();
        List<Ayat> ayatList = gson.fromJson(json, type);
        List<Ayat> ayatListIndo = gson.fromJson(jsonIndo, type);

        RecyclerView recyclerAyat = findViewById(R.id.ayat_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        AyatAdapter ayatAdapter = new AyatAdapter(this, ayatList, ayatListIndo);
        recyclerAyat.setLayoutManager(layoutManager);
        recyclerAyat.setHasFixedSize(true);
        recyclerAyat.setAdapter(ayatAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
