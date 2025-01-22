package com.sof3022.controller;

import com.sof3022.entity.SanPham;
import com.sof3022.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("remove/{id}")
    private String remove(@PathVariable String id) {
        sanPhamService.deleteSanPham(id);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("view-update/{id}")
    private String viewUpdate(@PathVariable String id, Model model) {
        model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
        model.addAttribute("sp", sanPhamService.detailsSanPham(id));
        return "view-update";
    }

    @PostMapping("update/{id}")
    private String update(@PathVariable String id, @Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSP", sanPhamService.getSanPhamList());
            model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
            return "view-update";
        }
        sanPhamService.updateSanPham(id, sanPham);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("tim-kiem")
    private String searchSanPham(@RequestParam String tenSearch, Model model) {
        model.addAttribute("sp", new SanPham());
        model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
        model.addAttribute("listSP", sanPhamService.searchSanPham(tenSearch));
        return "view-all";
    }

    @PostMapping("add")
    private String addSanPham(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSP", sanPhamService.getSanPhamList());
            model.addAttribute("listLoaiSP", sanPhamService.getLoaiSanPhamList());
            return "view-all";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/san-pham/view-all";
    }
}
