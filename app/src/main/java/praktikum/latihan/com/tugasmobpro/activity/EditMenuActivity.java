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

public class EditMenuActivity extends AppCompatActivity {

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

    String namaMenu = "", jenisMenu = "", id = "", hargaMenu = "", keternagnaMenu = "";
    private Boolean form = false;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        ButterKnife.bind(this);

        dbHelper = new DBHelper(this);
        id = getIntent().getStringExtra("id");
        namaMenu = getIntent().getStringExtra("nama");
        hargaMenu = getIntent().getStringExtra("keterangan");
        jenisMenu = getIntent().getStringExtra("harga");
        keternagnaMenu = getIntent().getStringExtra("deskripsi");

        nama.setText(namaMenu);
        harga.setText(hargaMenu);
        jenis.setText(jenisMenu);
        keterangan.setText(keternagnaMenu);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText() != null) {
                    namaMenu = nama.getText().toString();
                }
                if (harga.getText() != null) {
                    hargaMenu = harga.getText().toString();
                }
                if (jenis.getText() != null) {
                    jenisMenu = jenis.getText().toString();
                }
                if (keterangan.getText() != null) {
                    keternagnaMenu = keterangan.getText().toString();
                }
                if (dbHelper.EditData(id, namaMenu, jenisMenu, hargaMenu, keternagnaMenu)) {
                    Toast.makeText(EditMenuActivity.this, "Edit Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditMenuActivity.this, ListMenuActivity.class));
                } else {
                    Toast.makeText(EditMenuActivity.this, "Edit Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
