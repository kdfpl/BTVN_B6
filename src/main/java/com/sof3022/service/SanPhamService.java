package com.sof3022.service;

import com.sof3022.entity.LoaiSanPham;
import com.sof3022.entity.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamService {

    private List<SanPham> sanPhamList = new ArrayList<>();
    private final List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();

    public SanPhamService() {
        sanPhamList.add(new SanPham("1", "HangNT169", "Tao", "Loai 1", "100000"));
        sanPhamList.add(new SanPham("2", "NguyenVV4", "Cam", "Loai 2", "120000"));
        sanPhamList.add(new SanPham("3", "PhongTT35", "Sau rieng", "Loai 3", "130000"));
        sanPhamList.add(new SanPham("4", "KhanhPG", "7", "Loai 4", "140000"));
        sanPhamList.add(new SanPham("5", "TienNH21", "Mit", "Loai 3", "150000"));
        loaiSanPhamList.add(new LoaiSanPham("Loai 1"));
        loaiSanPhamList.add(new LoaiSanPham("Loai 2"));
        loaiSanPhamList.add(new LoaiSanPham("Loai 3"));
        loaiSanPhamList.add(new LoaiSanPham("Loai 4"));
    }

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public List<LoaiSanPham> getLoaiSanPhamList() {
        return loaiSanPhamList;
    }

    public SanPham detailsSanPham(String idSanPham) {
        return sanPhamList.stream()
                .filter(sanPham -> sanPham.getIdSanPham().equalsIgnoreCase(idSanPham))
                .findFirst()
                .orElse(null);
    }

    public void updateSanPham(String idSanPham, SanPham newSanPham) {
        sanPhamList = sanPhamList.stream()
                .map(sanPham -> sanPham.getIdSanPham().equalsIgnoreCase(idSanPham) ? newSanPham : sanPham)
                .collect(Collectors.toList());
    }

    public void deleteSanPham(String idSanPham) {
        sanPhamList.removeIf(sanPham -> sanPham.getIdSanPham().equalsIgnoreCase(idSanPham));
    }

    public void addSanPham(SanPham sanPham) {
        sanPhamList.add(sanPham);
    }

    public List<SanPham> searchSanPham(String tenSanPham) {
        return sanPhamList.stream()
                .filter(sanPham -> sanPham.getTenSanPham().toLowerCase().contains(tenSanPham.toLowerCase()))
                .collect(Collectors.toList());
    }
}
