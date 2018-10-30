package praktikum.latihan.com.tugasmobpro.model;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class MenuModel {
    private String namaMenu, hargaMenu, keteranganMenu, deskripsiMenu;
    private int fotoMenu;

    public MenuModel(String namaMenu, String hargaMenu, String keteranganMenu, String deskripsiMenu, int fotoMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.keteranganMenu = keteranganMenu;
        this.deskripsiMenu = deskripsiMenu;
        this.fotoMenu = fotoMenu;
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

    public int getFotoMenu() {
        return fotoMenu;
    }

    public void setFotoMenu(int fotoMenu) {
        this.fotoMenu = fotoMenu;
    }
}
