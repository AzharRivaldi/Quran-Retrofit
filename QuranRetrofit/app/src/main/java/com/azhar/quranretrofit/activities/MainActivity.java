package com.azhar.quranretrofit.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.quranretrofit.R;
import com.azhar.quranretrofit.adapter.SurahAdapter;
import com.azhar.quranretrofit.model.Cek;
import com.azhar.quranretrofit.model.Data;
import com.azhar.quranretrofit.model.Surah;
import com.azhar.quranretrofit.api.ApiClient;
import com.azhar.quranretrofit.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String arabic = "quran-uthmani";
    private static final String indo = "id.indonesian";

    private List<Surah> surahsArabic = new ArrayList<>();
    private List<Surah> surahsIndo = new ArrayList<>();

    ProgressDialog loadingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingData = new ProgressDialog(this);
        loadingData.setTitle("Mohon tunggu...");
        loadingData.setCancelable(false);
        loadingData.setMessage("Sedang mengambil data dari API");

        RecyclerView recyclerSurah = findViewById(R.id.surah_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerSurah.setHasFixedSize(true);
        recyclerSurah.setLayoutManager(layoutManager);

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Cek> call = apiInterface.getCek(arabic);
        Call<Cek> callIndo = apiInterface.getCek(indo);

        getDataListArabic(recyclerSurah, call);
        getDataTarjim(callIndo);
    }

    private void getDataTarjim(Call<Cek> callIndo) {
        callIndo.enqueue(new Callback<Cek>() {
            @Override
            public void onResponse(Call<Cek> call, Response<Cek> response) {
                Data data = response.body().getData();
                surahsIndo = data.getSurahs();

            }

            @Override
            public void onFailure(Call<Cek> call, Throwable t) {
                Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                Log.d("error", t.getMessage());
            }
        });
    }

    private void getDataListArabic(final RecyclerView recyclerSurah, Call<Cek> call) {
        loadingData.show();
        call.enqueue(new Callback<Cek>() {
            @Override
            public void onResponse(Call<Cek> call, Response<Cek> response) {
                Data data = response.body().getData();
                surahsArabic = data.getSurahs();

                SurahAdapter surahAdapter = new SurahAdapter(MainActivity.this, surahsArabic, surahsIndo);
                recyclerSurah.setAdapter(surahAdapter);
                loadingData.dismiss();
            }

            @Override
            public void onFailure(Call<Cek> call, Throwable t) {
                loadingData.dismiss();
                Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                Log.d("error", t.getMessage());
            }
        });
    }
}
