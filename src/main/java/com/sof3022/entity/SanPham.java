package com.sof3022.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {
    @NotBlank
    private String idSanPham;

    @NotBlank
    private String maSanPham;

    @NotBlank
    private String tenSanPham;

    @NotBlank
    private String loaiSanPham;

    @NotBlank
    private String giaSanPham;

}
