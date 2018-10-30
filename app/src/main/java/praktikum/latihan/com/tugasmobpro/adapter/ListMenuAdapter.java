package praktikum.latihan.com.tugasmobpro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.LinkedList;
import praktikum.latihan.com.tugasmobpro.R;
import praktikum.latihan.com.tugasmobpro.activity.DetailActivity;
import praktikum.latihan.com.tugasmobpro.activity.DetailMenuActivity;
import praktikum.latihan.com.tugasmobpro.activity.HargaActivity;
import praktikum.latihan.com.tugasmobpro.model.MenuModel;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListMenuViewHolder> {

    //deklarasi global variabel
    private Context context;
    private final LinkedList<MenuModel> listResto;

    //konstruktor untuk menerima data adapter
    public ListMenuAdapter(Context context, LinkedList<MenuModel> listResto) {
        this.context = context;
        this.listResto = listResto;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_menu, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListMenuViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListMenuViewHolder holder, int position) {
        final MenuModel mCurrent = listResto.get(position);
        holder.namaMenu.setText(mCurrent.getNamaMenu());
        holder.hargaMenu.setText(mCurrent.getHargaMenu());
        holder.keteranganMenu.setText(mCurrent.getKeteranganMenu());
        holder.gambarMenu.setImageResource(mCurrent.getFotoMenu());

    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listResto.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView namaMenu,hargaMenu,keteranganMenu,cvDetail;
        private ImageView gambarMenu;
        private CardView cdView;

        final ListMenuAdapter mAdapter;

        //untuk casting view yang digunakan pada list item
        public ListMenuViewHolder(View itemView, ListMenuAdapter adapter) {
            super(itemView);
            cdView = itemView.findViewById(R.id.cv_detail);
            namaMenu = itemView.findViewById(R.id.tv_nama_list_menu);
            hargaMenu = itemView.findViewById(R.id.tv_list_harga);
            keteranganMenu = itemView.findViewById(R.id.tv_list_keterangan);
            gambarMenu = itemView.findViewById(R.id.iv_list_gambar);

            this.mAdapter = adapter;
            cdView.setOnClickListener(this);
        }

        //untuk menambah action click pada list item
        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            MenuModel element = listResto.get(mPosition);

            //intent ke main activity dengan passing data
            Intent i = new Intent(context, DetailMenuActivity.class);

            i.putExtra("nama", element.getNamaMenu());
            i.putExtra("harga", element.getHargaMenu());
            i.putExtra("keterangan", element.getKeteranganMenu());
            i.putExtra("deskripsi", element.getDeskripsiMenu());
            i.putExtra("foto", element.getFotoMenu());

            context.startActivity(i);
            mAdapter.notifyDataSetChanged();
        }
    }
}
