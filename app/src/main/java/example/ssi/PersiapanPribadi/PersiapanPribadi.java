package example.ssi.PersiapanPribadi;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import example.ssi.R;

public class PersiapanPribadi extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    ViewPager viewPager;
    PagerAdapter adapter;
    String[] nama_brg, desk_brg;
    int[] gambar_brg;
    private int dotsCount;
    private ImageView[] dots;
    private LinearLayout pager_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persiapan_pribadi);

        nama_brg = getResources().getStringArray(R.array.brg_pribadi);
        desk_brg = getResources().getStringArray(R.array.desk_pribadi);

        gambar_brg = new int[]{R.drawable.carrier,R.drawable.deker,R.drawable.gaiter,R.drawable.headlamp,
        R.drawable.jacket,R.drawable.jashujan,R.drawable.kaoskaki,R.drawable.kupluk,R.drawable.logistik,
        R.drawable.masker,R.drawable.matras,R.drawable.obatobatan,R.drawable.pakaianganti,R.drawable.peralatanmakan,
        R.drawable.sarungtangan,R.drawable.sepatusandal,R.drawable.sleepingbag,R.drawable.tongkatdaki};

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(PersiapanPribadi.this,nama_brg,gambar_brg,desk_brg);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);

        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        setPageViewIndicator();
    }
    private void setPageViewIndicator() {
        Log.d("###setPageViewIndicator", " : called");
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            final int presentPosition = i;
            dots[presentPosition].setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    viewPager.setCurrentItem(presentPosition);
                    return true;
                }

            });


            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("###onPageSelected, pos ", String.valueOf(position));
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {

        } else {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
