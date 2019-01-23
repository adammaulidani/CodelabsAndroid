package adam.notebook.example.com.kpproject5.List;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.ilyagh.TypewriterRefreshLayout;

import adam.notebook.example.com.kpproject5.R;

public class ListActivity extends AppCompatActivity {

ListView listView;
TypewriterRefreshLayout pulltorefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView)findViewById(R.id.listProduk);
        final TypewriterRefreshLayout pulltorefresh=(TypewriterRefreshLayout)findViewById(R.id.pulltoRefresh);
        pulltorefresh.setOnRefreshListener(new TypewriterRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pulltorefresh.setRefreshing(isFinishing());

            }
        });
        ListAdapter adapter = new ListAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ProdukActivity.class);
                intent.putExtra("Position",position);
                startActivity(intent);
            }
        });

    }
}

