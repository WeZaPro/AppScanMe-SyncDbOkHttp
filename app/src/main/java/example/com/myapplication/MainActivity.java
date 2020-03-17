package example.com.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public Button btnInsert;//, btnShowDialog;
    public TextView text ;
    public EditText etID,etName,etLastname,etAge,etImageUrl;
    String apiShowDataUrl = "http://192.168.64.2/sample/testmysql/showdata.php";
    String apiInsertDataUrl = "http://192.168.64.2/sample/testmysql/insert.php";
    String id,name,lastname,age,ImageUrl;
    MyModel myModel = new MyModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
       // btnShowDialog = findViewById(R.id.btnShowDialog);
        text = findViewById(R.id.text);
        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        etLastname = findViewById(R.id.etLastname);
        etAge = findViewById(R.id.etAge);
        etImageUrl = findViewById(R.id.etImageUrl);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = etID.getText().toString();
                name = etName.getText().toString();
                lastname = etLastname.getText().toString();
                age = etAge.getText().toString();
                ImageUrl = etImageUrl.getText().toString();

                // insertData + ShowData
                new FeedTask().execute();

                // Clear Text input
                etID.getText().clear();
                etName.getText().clear();
                etLastname.getText().clear();
                etAge.getText().clear();
                etImageUrl.getText().clear();
            }
        });
    }

    public class FeedTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient();
                // insert data
                RequestBody postData = new FormEncodingBuilder()
                        .add("id",id )
                        .add("name", name)
                        .add("lastname", lastname)
                        .add("age", age)
                        .add("image_url", ImageUrl)
                        .build();

                Request request = new Request.Builder()
                        .url(apiInsertDataUrl)
                        .post(postData)
                        .build();
                Response reponse = client.newCall(request).execute();
                String result = reponse.body().string();
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //show data
            new ShowData().execute();
        }
    }

    private class ShowData extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient();
                // filter id
                RequestBody postData = new FormEncodingBuilder()
                        .add("mem_id",id)
                        .build();
                // show data
                Request request = new Request.Builder()
                        .url(apiShowDataUrl)
                        .post(postData)
                        .build();
                Response reponse = client.newCall(request).execute();
                String result = reponse.body().string();
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String msg_name="" ;

            try {
                JSONObject jsonstr = new JSONObject(s);
                JSONObject member = jsonstr.getJSONObject("0");
                String mem_name = member.getString("mem_name");
                String mem_id = member.getString("mem_id");
                String age = member.getString("age");
                String mem_lastname = member.getString("mem_lastname");
                String image_url = member.getString("image_url");

                myModel.setId(mem_id);
                myModel.setName(mem_name);
                myModel.setLastname(mem_lastname);
                myModel.setAge(age);
                myModel.setImage_url(image_url);

                msg_name = String.format(" id = %s name = %s %s age = %s",mem_id,mem_name,mem_lastname,age,image_url);

            }catch(JSONException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            //Toast.makeText(getApplicationContext(),"Your Name is"+msg_name,Toast.LENGTH_LONG).show();
            text.setText(msg_name);
            showDialog(myModel);
        }
    }

    public void showDialog(final MyModel myModel){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //builder.setMessage("Do you want to exit?");
        builder.setMessage(myModel.getName());
        builder.setTitle("Alert! your product");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setCancelable(false);

        builder.setPositiveButton("Detail Product", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                i.putExtra("key_name",myModel.getName());
                i.putExtra("key_lastname",myModel.getLastname());
                i.putExtra("key_age",myModel.getAge());
                i.putExtra("key_image_url",myModel.getImage_url());
                startActivity(i);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
