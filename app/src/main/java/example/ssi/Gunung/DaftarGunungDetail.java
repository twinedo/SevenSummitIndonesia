package example.ssi.Gunung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import example.ssi.R;

import static example.ssi.Gunung.DaftarGunung.KEY_DETAIL;
import static example.ssi.Gunung.DaftarGunung.KEY_GAMBAR;
import static example.ssi.Gunung.DaftarGunung.KEY_NAMA;

/**
 * Created by TWIN on 9/29/2016.
 */

public class DaftarGunungDetail extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_gunung_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        String nama = "";
        String detail = "";
        int gambar = 0;

        Bundle intent = getIntent().getExtras();
        if (null != intent) {
            nama = intent.getString(KEY_NAMA);
            detail = intent.getString(KEY_DETAIL);
            gambar = getIntent().getIntExtra(KEY_GAMBAR,R.mipmap.ic_launcher);
        }

        setTitle(nama);

        ImageView gambargunung = (ImageView) findViewById(R.id.gambargunung);
        gambargunung.setImageResource(gambar);

        TextView detailgunung = (TextView) findViewById(R.id.detailgunung);
        detailgunung.setText(detail);
    }
}
