package com.example.studentqueryform;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    RelativeLayout pass_lyt;
    EditText username_call, password_call;
    EditText enroll_call, name_call, program_call, sem_call, div_call, email_call, contact_call, complainBox_call;
    Button login, submitBtn;

    String username, password;

    final String[] error_text = {
            "enter Enrollment no.", //0
            "enter your Name",  //1
            "enter your program",   //2
            "enter your current Semester",  //3
            "enter your Division",  //4
            "enter your E-mail Address",    //5
            "enter your Contact no.",   //6
            "enter any type of Query or Complain here..",   //7
            "enter valid username", //8
            "enter valid Password", //9
            "username or password is not valid" //10
    };

    public final String connUrl = "jdbc:mysql://192.168.1.8:3306/sou_db";
    public final String connUrlLocal = "jdbc:mysql://localhost:3306/sou_db";
    public final String connUser = "root";
    public final String connPassword = "";
    public final String PHPInsertURL = "http://192.168.43.27/querydb/android_conn_insert_data.php";
    public final String PHPInsertURLLocal = "http://localhost:3306/querydb/android_conn_insert_data.php";


    public void inputEnable()
    {
        enroll_call.setEnabled(true);
        name_call.setEnabled(true);
        program_call.setEnabled(true);
        sem_call.setEnabled(true);
        div_call.setEnabled(true);
        email_call.setEnabled(true);
        contact_call.setEnabled(true);
        complainBox_call.setEnabled(true);
        submitBtn.setClickable(true);
    }

    public String edtToStr(EditText ed)
    {
        return ed.getText().toString();
    }

    @SuppressLint({"MissingInflatedId", "StaticFieldLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass_lyt = findViewById(R.id.pass_lyt);

        username_call = pass_lyt.findViewById(R.id.username);
        password_call = pass_lyt.findViewById(R.id.pass_word);

        enroll_call = findViewById(R.id.enroll);
        name_call = findViewById(R.id.name);
        program_call = findViewById(R.id.program);
        sem_call = findViewById(R.id.sem);
        div_call = findViewById(R.id.div);
        email_call = findViewById(R.id.email);
        contact_call = findViewById(R.id.contact);
        complainBox_call = findViewById(R.id.complain_box);

        login = pass_lyt.findViewById(R.id.login);


        submitBtn = findViewById(R.id.submit);



        login.setOnClickListener(view -> {

            username = username_call.getText().toString();
            password = password_call.getText().toString();

            if(username.equals(""))
            {
                username_call.setError(error_text[0]);
                Toast.makeText(MainActivity.this, error_text[8], Toast.LENGTH_SHORT).show();
            }
            else if (password.equals(""))
            {
                password_call.setError(error_text[1]);
                Toast.makeText(MainActivity.this, error_text[9], Toast.LENGTH_SHORT).show();
            }
            else
            {
                try {
//                    // Load the JDBC driver
//                    Log.e("000","err1");
////                    Class.forName("com.mysql.cj.jdbc.Driver");
//
//                    // Establish a connection
//                    Log.e("000","err2");
//                    Connection connection = DriverManager.getConnection(connUrl, connUser, connPassword);
//
//
//                    // Create a statement
//                    Log.e("000","err3");
//                    Statement statement = connection.createStatement();
//
//
//                    // Prepare the SQL query
//                    Log.e("000","err4");
//                    String acc_query = "SELECT password FROM accounts WHERE username=\"" + username +"\"";
//
//
//                    // Execute the query
//                    Log.e("000","err5");
//                    ResultSet rs = statement.executeQuery(acc_query);
//


//                    if (rs.next())
                    if (true)
                    {
//                        String dbPassword = rs.getString("password");

//                        if (dbPassword.equals(password))
                        if (true)
                        {
                            Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();

                            enroll_call.setText(username);
                            enroll_call.setKeyListener(null);
                            pass_lyt.setVisibility(View.GONE);

                            inputEnable();  // calling  udf
                        }
                        else
                        {
                            Toast.makeText(this, "invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "no server found", Toast.LENGTH_SHORT).show();
                    }

                    // Close the resources
//                    statement.close();
//                    connection.close();
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "can't connecting to Server", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                    Log.e("no connection",e.toString());


                }

            }

        });





        submitBtn.setOnClickListener(view -> {

            String enroll, name, program, sem, div, email, contact, complain;

            enroll = username;
            name = edtToStr(name_call);
            program = edtToStr(program_call);
            sem = edtToStr(sem_call);
            div = edtToStr(div_call);
            email = edtToStr(email_call);
            contact = edtToStr(contact_call);
            complain = edtToStr(complainBox_call);


            if(enroll.equals(""))
            {
                enroll_call.setError(error_text[0]);
                Toast.makeText(MainActivity.this, error_text[0], Toast.LENGTH_SHORT).show();
            }
            else if (name.equals(""))
            {
                name_call.setError(error_text[1]);
                Toast.makeText(MainActivity.this, error_text[1], Toast.LENGTH_SHORT).show();
            }
            else if (program.equals(""))
            {
                program_call.setError(error_text[2]);
                Toast.makeText(MainActivity.this, error_text[2], Toast.LENGTH_SHORT).show();
            }
            else if (sem.equals(""))
            {
                sem_call.setError(error_text[3]);
                Toast.makeText(MainActivity.this, error_text[3], Toast.LENGTH_SHORT).show();
            }
            else if (div.equals(""))
            {
                div_call.setError(error_text[4]);
                Toast.makeText(MainActivity.this, error_text[4], Toast.LENGTH_SHORT).show();
            }
            else if (email.equals(""))
            {
                email_call.setError(error_text[5]);
                Toast.makeText(MainActivity.this, error_text[5], Toast.LENGTH_SHORT).show();
            }
            else if (contact.equals(""))
            {
                contact_call.setError(error_text[6]);
                Toast.makeText(MainActivity.this, error_text[6], Toast.LENGTH_SHORT).show();
            }
            else if (complain.equals(""))
            {
                complainBox_call.setError(error_text[7]);
                Toast.makeText(MainActivity.this, error_text[7], Toast.LENGTH_SHORT).show();
            }
            else
            {
//
//                String sql_query = "INSERT INTO complains (enroll, fname, email, cno, prog, sem, divn, str) VALUES (\"" + enroll + "\", \"" + name + "\", \"" + email + "\", \"" + contact + "\", \"" + program + "\", \"" + sem + "\", \"" + div + "\", \"" + complain + "\")";
//
//
//                Log.e("000","err1");
//                ExecutorService executor = Executors.newSingleThreadExecutor();
//
//                Log.e("000","err2");
//                Handler handler = new Handler(Looper.getMainLooper());
//
//                Log.e("000","err3");
//
//                executor.execute(() -> {
//                    // Background work here
//
//                    try {
//                        Log.e("000","err4");
//                        Class.forName("com.mysql.jdbc.Driver");
//
//                        Log.e("000","err5");
//                        Connection con = DriverManager.getConnection(connUrl, connUser, connPassword);
//
//                        Log.e("000","err6");
//                        try (PreparedStatement pst = con.prepareStatement(sql_query)) {
//
//                            Log.e("000","err7");
//                            // Execute the insert statement
//                            pst.executeUpdate();
//                        }
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                        Log.e("000",ex.toString());
//
//                    }
//
//                    handler.post(() -> {
//                        // UI updates here
//                    });
//                });


                /////////////////////////


                Executors.newSingleThreadExecutor().execute(() -> {

                    try
                    {
                        Log.e("000","err1");
                        // Load the JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");

                        Log.e("000","err2");
                        // Establish a connection
                        Connection connection = DriverManager.getConnection(connUrl, connUser, connPassword);

                        Log.e("000","err3");
                        // Create a statement
                        Statement statement = connection.createStatement();

                        Log.e("000","err4");
                        // Prepare the SQL query
                        String sql_query = "INSERT INTO complains (enroll, fname, email, cno, prog, sem, divn, str) VALUES (\"" + enroll + "\", \"" + name + "\", \"" + email + "\", \"" + contact + "\", \"" + program + "\", \"" + sem + "\", \"" + div + "\", \"" + complain + "\")";

                        Log.e("000","err5");
                        // Execute the query
                        int result = statement.executeUpdate(sql_query);

                        // Check the result
                        if(result > 0)
                        {
                            Toast.makeText(MainActivity.this, "Complain send", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                        }
                        // Close the resources
                        statement.close();
                        connection.close();
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "can't connecting to Server", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                });


                ///////////////////////////////////////


//                Executors.newSingleThreadExecutor().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//
//                            String data = encode("enroll", "UTF-8") + "=" + encode(enroll, "UTF-8") + "&" +
//                                    encode("name", "UTF-8") + "=" + encode(name, "UTF-8") + "&" +
//                                    encode("prog", "UTF-8") + "=" + encode(program, "UTF-8") + "&" +
//                                    encode("sem", "UTF-8") + "=" + encode(sem, "UTF-8") + "&" +
//                                    encode("div", "UTF-8") + "=" + encode(div, "UTF-8") + "&" +
//                                    encode("email", "UTF-8") + "=" + encode(email, "UTF-8") + "&" +
//                                    encode("contact", "UTF-8") + "=" + encode(contact, "UTF-8") + "&" +
//                                    encode("complain", "UTF-8") + "=" + encode(complain, "UTF-8");
//
//                            Log.e("000","err1");
//                            URL url = new URL(PHPInsertURLLocal);
//
//                            Log.e("000","err2");
//                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//                            Log.e("000","err3");
//                            conn.setRequestMethod("POST");
//
//                            Log.e("000","err4");
//                            conn.setDoOutput(true);
//
//                            Log.e("000","err5");
//                            conn.setDoInput(true);
//
//                            Log.e("000","err6");
//                            OutputStream os = conn.getOutputStream();
//
//                            Log.e("000","err7");
//                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
//
//
//
//                            Log.e("000","err8");
//                            writer.write(data);
//                            writer.flush();
//                            writer.close();
//                            os.close();
//
//                            InputStream is = conn.getInputStream();
//                            is.close();
//
//                        }
//                        catch (Exception e)
//                        {
//                            e.printStackTrace();
//                            runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(), "can't send", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        }
//
//                    }
//                });


            }


        });
    }
}