package example.ssi.Gunung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import example.ssi.R;

public class DaftarGunung extends AppCompatActivity {

    private DaftarGunungAdapter adapter;

    public static final String KEY_NAMA="nama_gunung";
    public static final String KEY_DETAIL="detail_gunung";
    public static final String KEY_GAMBAR = "gambar_gunung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_gunung);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        adapter = new DaftarGunungAdapter(this, getData());
        ListView list = (ListView) findViewById(R.id.daftarGunung);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long offset) {
                Gunung item = (Gunung) adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), DaftarGunungDetail.class);
                intent.putExtra(KEY_NAMA, item.getNama());
                intent.putExtra(KEY_GAMBAR, item.getGambar());
                intent.putExtra(KEY_DETAIL, item.getDetail());

                startActivity(intent);
            }
        });
    }

    private ArrayList<Gunung> getData() {
        ArrayList<Gunung> newsList = new ArrayList<Gunung>();
        String[] nama = getResources().getStringArray(R.array.nama_gunung);
        //int[] gambar = getResources().getIntArray(R.array.gambar_gunung);
        int[] gambar = {R.mipmap.jayawijaya,R.mipmap.kerinci,R.mipmap.rinjani,R.mipmap.semeru,
        R.mipmap.latimojong,R.mipmap.binaiya,R.mipmap.bukitraya};
        String[] detail = getResources().getStringArray(R.array.detail_gunung);

        for (int i = 0; i < nama.length; i++) {
            Gunung item = new Gunung();
            item.setNama(nama[i]);
            item.setGambar(gambar[i]);
            item.setDetail(detail[i]);
            newsList.add(item);
        }

        return newsList;
    }

}
