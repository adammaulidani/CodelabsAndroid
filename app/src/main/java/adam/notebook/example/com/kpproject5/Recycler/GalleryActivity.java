package adam.notebook.example.com.kpproject5.Recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;

import adam.notebook.example.com.kpproject5.R;

/**
 * Created by User on 1/2/2018.
 */

public class GalleryActivity extends AppCompatActivity {



    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra(
                "desc_image"
        )){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String descImage = getIntent().getStringExtra("desc_image");

            setImage(imageUrl, imageName,descImage);
        }
    }


    private void setImage(String imageUrl, String imageName,String descImage){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        KenBurnsView image = findViewById(R.id.img_produk_recycler);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        TextView name = findViewById(R.id.title_product_recycler);
        name.setText(imageName);

        TextView desc = findViewById(R.id.desc_product_recycler);
        desc.setText(descImage);
    }
}


















