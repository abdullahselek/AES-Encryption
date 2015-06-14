package com.abdullahselek.aes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SampleActivity extends Activity {

    /** ui components **/
    private EditText etString;
    private TextView tvResult;
    private Button btnEncrypt;
    private Button btnDecrypt;

    /** AES class variable **/
    private AESEncryption aesEncryption = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        String keyValue = "abdullahselekistanbultur";
        String ivValue = "0102030405060708";

        aesEncryption = new AESEncryption(keyValue, ivValue);

        etString = (EditText) findViewById(R.id.etStringData);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnEncrypt = (Button) findViewById(R.id.btnEncrypt);
        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tvResult.setText(aesEncryption.encrypt(etString.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnDecrypt = (Button) findViewById(R.id.btnDecrypt);
        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tvResult.setText(aesEncryption.decrypt(tvResult.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
