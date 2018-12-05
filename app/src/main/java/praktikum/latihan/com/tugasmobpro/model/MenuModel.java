package praktikum.latihan.com.tugasmobpro.model;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class MenuModel {
    private String id, namaMenu, hargaMenu, keteranganMenu, deskripsiMenu;
    //private int fotoMenu;


    public MenuModel(String id, String namaMenu, String hargaMenu, String keteranganMenu, String deskripsiMenu) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.keteranganMenu = keteranganMenu;
        this.deskripsiMenu = deskripsiMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(String hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getKeteranganMenu() {
        return keteranganMenu;
    }

    public void setKeteranganMenu(String keteranganMenu) {
        this.keteranganMenu = keteranganMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public void setDeskripsiMenu(String deskripsiMenu) {
        this.deskripsiMenu = deskripsiMenu;
    }
}
