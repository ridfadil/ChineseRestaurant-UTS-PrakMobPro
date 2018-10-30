package praktikum.latihan.com.tugasmobpro.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import praktikum.latihan.com.tugasmobpro.R;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */
public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.txt_chicken_katsu)
    EditText txtChickenKatsu;
    @BindView(R.id.txt_thailis)
    EditText txtThailis;
    @BindView(R.id.txt_bakpao)
    EditText txtBakpao;
    @BindView(R.id.txt_kwwetiaw)
    EditText txtKwwetiaw;
    @BindView(R.id.txt_jus)
    EditText txtJus;
    @BindView(R.id.txt_kopi_yunan)
    EditText txtKopiYunan;
    @BindView(R.id.txt_teh_krisa)
    EditText txtTehKrisa;
    @BindView(R.id.txt_juinang)
    EditText txtJuinang;
    @BindView(R.id.Total_bayar)
    TextView TotalBayar;
    @BindView(R.id.btn_pesan)
    Button btnPesan;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.review_pesanan)
    TextView reviewPesanan;
    @BindView(R.id.harga1)
    TextView harga1;
    @BindView(R.id.jumlah1)
    TextView jumlah1;
    @BindView(R.id.total_harga)
    TextView totalHarga;

    String katsu, thailis, bakpao, kwetiau, jus, kopiyunan, tehkrisan, jiuniang, total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initLanguage();
        initFocusable();
        getFromIntent();
        setMenu();
        actionClicked();

    }

    public void initLanguage() {
        reviewPesanan.setText(getResources().getString(R.string.ulasan_pesanan));
        harga1.setText(getResources().getString(R.string.harga));
        jumlah1.setText(getResources().getString(R.string.jumlah));
        totalHarga.setText(getResources().getString(R.string.total_harga));
        totalHarga.setText(getResources().getString(R.string.total_harga));
        btnCancel.setText(getResources().getString(R.string.batal));
        btnPesan.setText(getResources().getString(R.string.selesai));
    }

    public void actionClicked() {
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(DetailActivity.this).create();
                alertDialog.setTitle("Info Pesanan");
                alertDialog.setIcon(R.drawable.imageresto);
                alertDialog.setMessage("Terimakasih Sudah Melakukan Pemesanan");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Pesanan Sedang Di Proses", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });
                alertDialog.show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(DetailActivity.this).create();
                alertDialog.setTitle("Info Pesanan");
                alertDialog.setIcon(R.drawable.imageresto);
                alertDialog.setMessage("Batalkan Pesanan?");
                alertDialog.setButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Pesanan Sudah di Batalkan", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });
                alertDialog.show();
            }
        });
    }

    public void initFocusable() {
        txtBakpao.setFocusable(false);
        txtThailis.setFocusable(false);
        txtChickenKatsu.setFocusable(false);
        txtJuinang.setFocusable(false);
        txtJus.setFocusable(false);
        txtKopiYunan.setFocusable(false);
        txtKwwetiaw.setFocusable(false);
        txtTehKrisa.setFocusable(false);
    }

    public void getFromIntent() {
        katsu = getIntent().getStringExtra("chicken");
        thailis = getIntent().getStringExtra("thailis");
        bakpao = getIntent().getStringExtra("bakpao");
        kwetiau = getIntent().getStringExtra("kwetiaw");
        jus = getIntent().getStringExtra("jus");
        kopiyunan = getIntent().getStringExtra("kopiyunan");
        tehkrisan = getIntent().getStringExtra("tehkrisan");
        jiuniang = getIntent().getStringExtra("jiuniang");
        total = getIntent().getStringExtra("total");
    }

    public void setMenu() {
        txtChickenKatsu.setText(katsu);
        txtThailis.setText(thailis);
        txtBakpao.setText(bakpao);
        txtKwwetiaw.setText(kwetiau);
        txtJus.setText(jus);
        txtKopiYunan.setText(kopiyunan);
        txtTehKrisa.setText(tehkrisan);
        txtJuinang.setText(jiuniang);
        TotalBayar.setText(total);
    }
}
