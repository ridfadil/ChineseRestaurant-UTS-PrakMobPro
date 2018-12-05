package praktikum.latihan.com.tugasmobpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import praktikum.latihan.com.tugasmobpro.R;
import praktikum.latihan.com.tugasmobpro.database.DBHelper;

public class AddMenuActivity extends AppCompatActivity {

    @BindView(R.id.nama)
    EditText nama;
    @BindView(R.id.jenis)
    EditText jenis;
    @BindView(R.id.harga)
    EditText harga;
    @BindView(R.id.keterangan)
    EditText keterangan;
    @BindView(R.id.btn_save)
    Button btnSave;

    String namaMenu = "", jenisMenu = "", hargaMenu = "", keternagnaMenu = "";
    private Boolean form = false;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        ButterKnife.bind(this);
        dbHelper = new DBHelper(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    public void save() {
        if (!nama.getText().toString().equals("")) {
            namaMenu = nama.getText().toString();
        } else form = true;
        if (!jenis.getText().toString().equals("")) {
            jenisMenu = jenis.getText().toString();
        } else form = true;
        if (!harga.getText().toString().equals("")) {
            hargaMenu = harga.getText().toString();
        } else form = true;
        if (!keterangan.getText().toString().equals("")) {
            keternagnaMenu = keterangan.getText().toString();
        } else form = true;

        if (form) {
            Toast.makeText(this, "Maaf Form Masih ada yang kosong", Toast.LENGTH_SHORT).show();
            form = false;
        } else {
            if (dbHelper.MasukanData(namaMenu, hargaMenu, jenisMenu, keternagnaMenu)) {
                Toast.makeText(this, "Data Berhasil Dimasukan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddMenuActivity.this, ListMenuActivity.class));
            } else {
                Toast.makeText(this, "Data Gagal Dimasukan", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
