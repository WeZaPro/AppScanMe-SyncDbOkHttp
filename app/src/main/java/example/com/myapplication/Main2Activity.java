package example.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {

    TextView textViewName,textViewLastName,textViewAge,textViewImage;
    ImageView mv;
    String Name,Lastname,Age,imageText,imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewName = findViewById(R.id.textViewName);
        textViewLastName = findViewById(R.id.textViewLastName);
        textViewAge = findViewById(R.id.textViewAge);
        //textViewImage = findViewById(R.id.textViewImage);
        mv = findViewById(R.id.mv);

        Intent i = getIntent();
        Name = i.getStringExtra("key_name");
        Lastname = i.getStringExtra("key_lastname");
        Age = i.getStringExtra("key_age");
        //imageText = i.getStringExtra("key_image_url");
        imageView = i.getStringExtra("key_image_url");

        textViewName.setText(Name);
        textViewLastName.setText(Lastname);
        textViewAge.setText(Age);
        //textViewImage.setText(imageText);

        Glide.with(this).load(imageView).into(mv);

    }
}
