package org.jae.productorderservice.product.adapter;

import org.jae.productorderservice.product.application.port.ProductPort;
import org.jae.productorderservice.product.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
