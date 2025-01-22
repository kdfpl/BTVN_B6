package com.sof3022.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {
    @NotBlank(message = "Khong duoc de trong")
    private String idSanPham;

    @NotBlank(message = "Khong duoc de trong")
    private String maSanPham;

    @NotBlank(message = "Khong duoc de trong")
    private String tenSanPham;

    private String loaiSanPham;

    @NotBlank(message = "Khong duoc de trong")
    @Pattern(regexp = "^(15[1-9]|1[6-9][0-9]|[2-9][0-9]{2,})$", message = "Phai la so nguyen duong > 150")
    private String giaSanPham;

}
