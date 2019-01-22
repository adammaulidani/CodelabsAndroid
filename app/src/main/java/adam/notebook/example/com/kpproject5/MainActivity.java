package adam.notebook.example.com.kpproject5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import adam.notebook.example.com.kpproject5.Fav.FavoriteActivity;
import adam.notebook.example.com.kpproject5.Swipe.adapter.CardItemString;
import adam.notebook.example.com.kpproject5.Swipe.adapter.CardPageAdapterS;
import adam.notebook.example.com.kpproject5.Swipe.utils.ShadowTransformer;
import adam.notebook.example.com.kpproject5.User.ProfileActivity;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private CardPageAdapterS mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    String titlesText [] = {" Processor", " Motherboard", " Harddisk", " VGA Card", " RAM", " Power Supply",
            " Casing", " LCD", " Audio", " Accessories"};
    String  detailsArray [] = {
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
            "Time table details radom, Lorem ipsum characters ment for testing of programs and characters or displaying random informations",
    };
    String color[] = {"#eaad43","#45bc62","#49acd5","#424242","#c5cae9","#bbb5c3","#ede7f6","#c5cae9","#45bc62","#eaad43"};

    private Context context;
    CarouselView carouselView;
    int [] gambarCarousel = {R.drawable.nature,R.drawable.natureone,R.drawable.naturetwo,R.drawable.naturethree};

    private ImageButton btn_fav,btn_profile,btn_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ImageButton btn_fav = (ImageButton)findViewById(R.id.imageButton3);
       btn_fav.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, FavoriteActivity.class);
               startActivity(i);
           }
       });
       ImageButton btn_profile = (ImageButton)findViewById(R.id.imageButton);
       btn_profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, ProfileActivity.class);
               startActivity(i);
           }
       });

       ImageButton btn_intro = (ImageButton)findViewById(R.id.imageButton2);
       btn_intro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent (MainActivity.this,Introduction.class);
               startActivity(i);
           }
       });

        context = this;
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mCardAdapter = new CardPageAdapterS(MainActivity.this);
        for (int i=0; i<titlesText.length; i++){

            mCardAdapter.addCardItemS(new CardItemString( titlesText[i], detailsArray[i]));

        }

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(gambarCarousel.length);
        carouselView.setImageListener(imageListener);
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(gambarCarousel[position]);
        }
    };
}
