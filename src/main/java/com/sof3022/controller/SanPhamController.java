package com.sof3022.controller;

import com.sof3022.entity.SanPham;
import com.sof3022.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("view-all")
    private String viewAll(Model model) {
        model.addAttribute("listSP", sanPhamService.getSanPhamList());
        model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
        model.addAttribute("sp", new SanPham());
        return "view-all";
    }

    @GetMapping("detail/{id}")
    private String detail(@PathVariable String id, Model model) {
        model.addAttribute("sp", sanPhamService.detailsSanPham(id));
        model.addAttribute("listSP", sanPhamService.getSanPhamList());
        model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
        return "view-all";
    }
}
