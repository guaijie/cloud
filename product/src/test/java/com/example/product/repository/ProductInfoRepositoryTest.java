package com.example.product.repository;

        import com.example.product.Enum.ProductStatusEnum;
        import com.example.product.entity.ProductInfo;
        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.List;

        import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus(){
        Pageable pageable= (Pageable) PageRequest.of(1,1);
        Page<ProductInfo> page=productInfoRepository.findByProductStatus(0,pageable);
        Assert.assertTrue(page.hasContent());
    }
    @Test
    public void findAll(){
        Pageable pageable= (Pageable) PageRequest.of(1,1);
        Page<ProductInfo> page=productInfoRepository.findAll(pageable);
        System.out.println(page.getContent());
        Assert.assertTrue(page.hasContent());
    }
}

