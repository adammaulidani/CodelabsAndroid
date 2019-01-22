package adam.notebook.example.com.kpproject5.Recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import adam.notebook.example.com.kpproject5.R;

public class RecyclerActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");



        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");



        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");
        mDesc.add("Rp 2.500.000" + "Dengan spesifikasi mumpuni dan tidak tertandingi");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls,mDesc);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}






















