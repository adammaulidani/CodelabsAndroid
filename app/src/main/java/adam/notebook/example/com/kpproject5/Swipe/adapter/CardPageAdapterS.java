package adam.notebook.example.com.kpproject5.Swipe.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adam.notebook.example.com.kpproject5.List.ListActivity;
import adam.notebook.example.com.kpproject5.DetailActivity;
import adam.notebook.example.com.kpproject5.MainActivity;
import adam.notebook.example.com.kpproject5.R;
import adam.notebook.example.com.kpproject5.Recycler.RecyclerActivity;

public class CardPageAdapterS extends PagerAdapter implements CardAdapter {

    Button btn_click,btn_click2,btn_click3;
    private List<CardView> mViews;
    private List<CardItemString> mData;
    private float mBaseElevation;
    Context mContext;

    public CardPageAdapterS(MainActivity mainActivity) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        mContext = mainActivity;
    }

    public void addCardItemS(CardItemString item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return  mData.size();

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        View v = null;
        switch (position) {
            case 0:
                final Context context = container.getContext();
                Button btn_click = (Button) view.findViewById(R.id.btnklik);
                btn_click.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View View) {
                        Intent intent = new Intent(context, ListActivity.class);
                        context.startActivity(intent);
                        Toast.makeText(mContext, "Category1",Toast.LENGTH_SHORT).show();

                    }
                });
                break;

            case 1:
                final Context context1 = container.getContext();
                Button btn_click1 = (Button) view.findViewById(R.id.btnklik);
                btn_click1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View View) {
                        Intent intent = new Intent(context1, DetailActivity.class);
                        context1.startActivity(intent);
                        Toast.makeText(mContext, "Category2",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
//
            case 2:
                final Context context2 = container.getContext();
                Button btn_click2 = (Button) view.findViewById(R.id.btnklik);
                btn_click2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View View) {
                        Intent intent = new Intent(context2, ListActivity.class);
                        context2.startActivity(intent);
                        Toast.makeText(mContext, "Category3",Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case 3:
                final Context context3 = container.getContext();
                Button btn_click3 = (Button) view.findViewById(R.id.btnklik);
                btn_click3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View View) {
                        Intent intent = new Intent(context3, RecyclerActivity.class);
                        context3.startActivity(intent);
                        Toast.makeText(mContext, "Category3",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

        container.addView(view);
        bind(mData.get(position), view);

        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
//
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "List Position " + position, Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItemString item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        btn_click = (Button) view.findViewById(R.id.btnklik);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
    }
}