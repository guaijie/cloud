package com.example.product.server.service.impl;

import com.example.product.common.co.CartDTO;
import com.example.product.server.entity.ProductInfo;
import com.example.product.server.enums.ExceptionEnum;
import com.example.product.server.exception.ProductException;
import com.example.product.server.repository.ProductInfoRepository;
import com.example.product.server.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Page<ProductInfo> findProductInfosByStatus(Integer productStatus, Integer page, Integer size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProductInfo> pageWrapper = productInfoRepository.findByProductStatus(productStatus, pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByPages(Integer page, Integer size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProductInfo> pageWrapper = productInfoRepository.findAll(pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByType(String categoryType, Integer page, Integer size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProductInfo> pageWrapper = productInfoRepository.findByCategory_CategoryType(categoryType, pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByTypeAndStatus(String categoryType, Integer productStatus, Integer page, Integer size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProductInfo> pageWrapper = productInfoRepository.findByCategory_CategoryTypeAndProductStatus(categoryType, productStatus, pageable);
        return pageWrapper;
    }

    @Override
    public List<ProductInfo> findProductInfosByProductIdIn(List<String> productIdList) {
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(productIdList);
        return list;
    }

    @Override
    @Transactional
    public void decreseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ExceptionEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();

            Integer nextStock = productInfo.getProductStock() - cartDTO.getProductCounts();

            //库存是否充足
            if (nextStock < 0) {
                throw new ProductException(ExceptionEnum.PRODUCT_STOCK_ERROR);
            }
            System.out.println(productInfo.toString());

            productInfo.setProductStock(nextStock);

            System.out.println("productInfo" + productInfo);

            productInfoRepository.save(productInfo);

        }
    }
}
