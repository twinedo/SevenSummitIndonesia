package example.ssi.Gunung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.ssi.R;

/**
 * Created by TWIN on 9/29/2016.
 */


public class DaftarGunungAdapter extends BaseAdapter{
    private ArrayList<Gunung> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public DaftarGunungAdapter(Context context, ArrayList<Gunung> listData) {
        this.listData = listData;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.daftar_gunung_row, null);

            holder = new ViewHolder();
            holder.nama_gunung = (TextView) convertView.findViewById(R.id.namagunung);
            holder.detail_gunung= (TextView)convertView.findViewById(R.id.detailgunung);
            holder.gambar_gunung= (ImageView) convertView.findViewById(R.id.gambar_gunung);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nama_gunung.setText(listData.get(position).getNama());
        holder.gambar_gunung.setImageResource(listData.get(position).getGambar());





        /*if (position == 1) {
            convertView.setBackground(context.getResources().getDrawable(R.id.gambargunung));
        } else {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.list_row_color2));
        }*/

        return convertView;
    }

    static class ViewHolder {
        TextView nama_gunung;
        TextView detail_gunung;
        ImageView gambar_gunung;

    }
}
