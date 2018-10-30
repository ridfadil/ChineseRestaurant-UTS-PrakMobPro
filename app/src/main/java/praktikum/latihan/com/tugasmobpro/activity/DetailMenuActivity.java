package praktikum.latihan.com.tugasmobpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import praktikum.latihan.com.tugasmobpro.R;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class DetailMenuActivity extends AppCompatActivity {

    @BindView(R.id.image_menu)
    ImageView imageMenu;
    @BindView(R.id.nama_menu)
    TextView namaMenu;
    @BindView(R.id.harga)
    TextView harga;
    @BindView(R.id.keterangan)
    TextView keterangan;
    @BindView(R.id.deskripsi)
    TextView deskripsi;
    String nama = "", hargaMenu = "", keteranganMenu = "", deskripsiMenu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        ButterKnife.bind(this);
        nama = getIntent().getStringExtra("nama");
        hargaMenu = getIntent().getStringExtra("harga");
        keteranganMenu = getIntent().getStringExtra("keterangan");
        deskripsiMenu = getIntent().getStringExtra("deskripsi");
        imageMenu.setImageResource(getIntent().getIntExtra("foto", 0));

        namaMenu.setText(nama);
        harga.setText(hargaMenu);
        keterangan.setText(keteranganMenu);
        deskripsi.setText(deskripsiMenu);


    }
}
