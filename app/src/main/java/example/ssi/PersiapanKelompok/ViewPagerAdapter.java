package example.ssi.PersiapanKelompok;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.ssi.R;

/**
 * Created by TWIN on 10/2/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] nama_brg, desk_brg;
    private int[] gambar_brg;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] nama_brg, int[] gambar_brg, String[] desk_brg) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.nama_brg =nama_brg;
        this.gambar_brg=gambar_brg;
        this.desk_brg=desk_brg;
    }

    @Override
    public int getCount(){
        return gambar_brg.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        TextView txt_nama,txt_desk;
        ImageView img_brg;

        View itemView = inflater.inflate(R.layout.persiapan_pribadi_item, container, false);

        txt_nama = (TextView) itemView.findViewById(R.id.nama_brg);
        txt_desk = (TextView) itemView.findViewById(R.id.desk_barang);
        img_brg = (ImageView)itemView.findViewById(R.id.gambar_brg);

        txt_nama.setText(nama_brg[position]);
        txt_desk.setText(desk_brg[position]);

        img_brg.setImageResource(gambar_brg[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }

}
