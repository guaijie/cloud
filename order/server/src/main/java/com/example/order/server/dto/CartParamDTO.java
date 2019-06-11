package com.example.order.server.dto;

import com.example.product.common.co.CartDTO;
import lombok.Data;

import java.util.List;

@Data
public class CartParamDTO {

    private String userId;

    private List<CartDTO> cartDTOList;
}
