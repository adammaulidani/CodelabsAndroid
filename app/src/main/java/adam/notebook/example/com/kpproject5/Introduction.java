package adam.notebook.example.com.kpproject5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduction extends AppCompatActivity {
Button btn_Logn,btn_Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

      Button btn_Login = (Button)findViewById(R.id.btn_login);
      btn_Login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(Introduction.this,MainActivity.class);
              startActivity(i);
          }
      });
      Button btn_Signup = (Button)findViewById(R.id.btn_signup);
    }
}
