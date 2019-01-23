package adam.notebook.example.com.kpproject5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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

    String titlesText [] = {" Processor",
            " Motherboard",
            " Harddisk",
            " VGA Card",
            " RAM",
            " Power Supply",
            " Casing",
            " LCD",
            " Audio",
            " Accessories"};
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
//    int detailArray []  = {R.drawable.nature,R.drawable.natureone,R.drawable.naturetwo,R.drawable.naturethree};

    private Context context;
    CarouselView carouselView;
    int [] gambarCarousel = {R.drawable.nature,R.drawable.natureone,R.drawable.naturetwo,R.drawable.naturethree};

    private ImageButton btn_fav,btn_profile,btn_intro;
    private MenuItem btn_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       ImageButton btn_fav = (ImageButton)findViewById(R.id.imageButton3);
//       btn_fav.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent i = new Intent(MainActivity.this, FavoriteActivity.class);
//               startActivity(i);
//           }
//       });
//       ImageButton btn_profile = (ImageButton)findViewById(R.id.imageButton);
//       btn_profile.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent i = new Intent(MainActivity.this, ProfileActivity.class);
//               startActivity(i);
//           }
//       });
//
//       ImageButton btn_intro = (ImageButton)findViewById(R.id.imageButton2);
//       btn_intro.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent i = new Intent (MainActivity.this,Introduction.class);
//               startActivity(i);
//           }
//       });
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


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bn_main);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu:
                        Intent intent1 = new Intent(MainActivity.this, DetailActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.favorite_menu:
                        Intent intent2 = new Intent(MainActivity.this, FavoriteActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.search_menu:
                        Intent intent3 = new Intent(MainActivity.this, Introduction.class);
                        startActivity(intent3);
                        break;

                    case R.id.account_menu:
                        Intent intent4 = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent4);
                        break;

                }

                return false;
            }
        });




    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(gambarCarousel[position]);
        }
    };
}
