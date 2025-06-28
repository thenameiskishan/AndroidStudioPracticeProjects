package com.example.sql_app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCity, edtId;
    Button insert, update, delete, show;
    ImageView nodata;
    public static final String TAG_TABLE="student";
    public static final String TAG_ID="id";
    public static final String TAG_NAME="name";
    public static final String TAG_CITY="city";
    public static final String INSERT_URL="http://192.168.1.5/gtu/api/v1/insertData.php";
    public static final String UPDATE_URL="http://192.168.1.5/gtu/api/v1/updateData.php";
    public static final String SELECT_URL="http://192.168.1.5/gtu/api/v1/SelectDemo.php";
    public static final String DELETE_URL="http://192.168.1.5/gtu/api/v1/deleteData.php";
    ProgressDialog pDialog;
    String message=null;
    int status=0;
    private List<String> ids=new ArrayList<>();
    private List<String> names=new ArrayList<>();
    private List<String> cities=new ArrayList<>();
    MyAdapter adapter=null;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtname);
        edtId=findViewById(R.id.edtid);
        edtCity=findViewById(R.id.edtcity);
        insert=findViewById(R.id.insert);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        show=findViewById(R.id.show);
        listView=findViewById(R.id.listview);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName=edtName.getText().toString();
                String strCity=edtCity.getText().toString();
                if (strName.equals(""))
                {
                    edtName.setError("Please Enter Name");
                }
                else if(strCity.equals(""))
                {
                    edtCity.setError("Please Enter City");
                }
                else{
                    new Insert().execute(strName,strCity);
                }
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName=edtName.getText().toString();
                String strCity=edtCity.getText().toString();
                String strId=edtId.getText().toString();
                if (strName.equals(""))
                {
                    edtName.setError("Please Enter Name");
                }
                else if(strCity.equals(""))
                {
                    edtCity.setError("Please Enter City");
                }
                else if(strId.equals(""))
                {
                    edtId.setError("Please Enter Id");
                }
                else{
                    new Update().execute(strId,strName,strCity);
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strId=edtId.getText().toString();
                if(strId.equals(""))
                {
                    edtId.setError("please Enter Id");
                }
                else
                {
                    new Delete().execute(strId);
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Select().execute();
            }


        });
    }

    class Insert extends AsyncTask
    {
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog=new ProgressDialog(MainActivity.this);
            pDialog.setTitle("Inserting Data");
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Object doInBackground (Object[] objects) {
            String name = objects[0].toString();
            String city = objects[1].toString();
            SendData send = new SendData();
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair(TAG_NAME,name));
            params.add(new BasicNameValuePair(TAG_CITY,city));
            JSONObject jsonObject = send.request(INSERT_URL,"POST", params);
            try {
                JSONObject jobj = jsonObject.getJSONObject(TAG_TABLE);
                message = jobj.getString("message");
                status = jobj.getInt("status");
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Object o){
            super.onPostExecute(o);
            pDialog.dismiss();
            edtName.setText("");
            edtCity.setText("");
            Toast.makeText(MainActivity.this,message+""+status, Toast.LENGTH_SHORT).show();
       }
    }



    class Select extends AsyncTask {
        protected void onPreExecute(){
            super.onPreExecute();
            ids.clear();
            names.clear();
            cities.clear();
            pDialog= new ProgressDialog(MainActivity.this);
            pDialog.setTitle("Fechting Data");
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        protected Object doInBackground(Object[] objects){
            ReceiveData receiveData= new ReceiveData();
            JSONObject jsonObject=receiveData.request(SELECT_URL);
            try{
                message=jsonObject.getString("message");
                status=jsonObject.getInt("status");
                if(status==200)
                {
                    JSONArray jsonArray=jsonObject.getJSONArray(TAG_TABLE);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jobj=jsonArray.getJSONObject(i);
                        String id=jobj.getString(TAG_ID);
                        String name=jobj.getString(TAG_NAME);
                        String city=jobj.getString(TAG_CITY);
                        ids.add(id);
                        names.add(name);
                        cities.add(city);
                    }
                }
            }catch(JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Object o){
            super.onPostExecute(o);
            pDialog.dismiss();
            Toast.makeText(MainActivity.this, message+""+status, Toast.LENGTH_SHORT).show();
            adapter= new MyAdapter(MainActivity.this,R.layout.row_item,ids,names,cities);
            listView.setAdapter(adapter);
        }
    }



    class Update extends AsyncTask{
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setTitle("Updating Date");
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        protected Object doInBackground(Object[] objects){
            String id=objects[0].toString();
            String name=objects[1].toString();
            String city=objects[2].toString();
            SendData send= new SendData();
            List<NameValuePair> params= new ArrayList<>();
            params.add(new BasicNameValuePair(TAG_ID,id));
            params.add(new BasicNameValuePair(TAG_NAME,name));
            params.add(new BasicNameValuePair(TAG_CITY,city));
            JSONObject jsonObject=send.request(UPDATE_URL,"POST",params);
            try {
                JSONObject jobj = jsonObject.getJSONObject(TAG_TABLE);
                message = jobj.getString("message");
                status = jobj.getInt("status");
            }catch(JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Object o){
            super.onPostExecute(o);
            pDialog.dismiss();
            edtName.setText("");
            edtCity.setText("");
            Toast.makeText(MainActivity.this, message+""+status, Toast.LENGTH_SHORT).show();
        }
    }



    class Delete extends AsyncTask{
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog=new ProgressDialog(MainActivity.this);
            pDialog.setTitle("Deleting Data");
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        protected Object doInBackground(Object[] objects){
            String id=objects[0].toString();
            SendData send= new SendData();
            List<NameValuePair> params= new ArrayList<>();
            params.add(new BasicNameValuePair(TAG_ID,id));
            JSONObject jsonObject=send.request(DELETE_URL,"POST",params);
            try {
                JSONObject jobj=jsonObject.getJSONObject(TAG_TABLE);
                message=jobj.getString("message");
                status=jobj.getInt("status");
            }catch(JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Object o){
            super.onPostExecute(o);
            pDialog.dismiss();
            edtName.setText("");
            edtCity.setText("");
            Toast.makeText(MainActivity.this, message+""+status, Toast.LENGTH_SHORT).show();
        }
    }
}