package example.ssi.Gunung;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by TWIN on 9/29/2016.
 */

public class Gunung  {
    private String nama;
    private String detail;
    private int gambar;

    public Gunung(){
        this.setGambar(gambar);
        this.setNama(nama);
        this.setDetail(detail);
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String headline) {
        this.nama = headline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String details) {
        this.detail = details;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
