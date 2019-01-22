package adam.notebook.example.com.kpproject5.List;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import adam.notebook.example.com.kpproject5.R;

public class ProdukActivity extends AppCompatActivity {
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("Position");

        final ListAdapter adapter = new ListAdapter(this);
        final ImageView image_product = (ImageView) findViewById(R.id.img_produk);
        final TextView name_product = (TextView) findViewById(R.id.title_product);
        final TextView price_product = (TextView)findViewById(R.id.desc_product);

        image_product.setImageResource(adapter.image_product[position]);
        name_product.setText(adapter.name_product[position]);
        price_product.setText(adapter.price_product[position]);

    }
}
