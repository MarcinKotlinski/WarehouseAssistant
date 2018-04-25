package com.example.a.warehouseassistant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class GeneratorRaportow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_raportow);

        String info=ReadProductFragment.getTextInfo();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Stan magazynu " +currentDateTimeString);
        intent.putExtra(Intent.EXTRA_TEXT, info);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
