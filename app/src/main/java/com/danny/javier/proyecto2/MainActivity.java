package com.danny.javier.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button botonA1;
    ImageView imagenA1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonA1 = findViewById(R.id.botonA1);
        imagenA1 = findViewById(R.id.imagenA1);

        botonA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirCamara();


            }
        });
    }
    private  void abrirCamara(){
        Intent intet = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // if (intet.resolveActivity(getPackageManager()) !=null){
        startActivityForResult(intet, 1);
        //  }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imBitmap = (Bitmap) extras.get("data");
            imagenA1.setImageBitmap(imBitmap);
        }
    }
}