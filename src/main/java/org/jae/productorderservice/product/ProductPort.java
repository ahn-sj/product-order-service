package org.jae.productorderservice.product;

interface ProductPort {
    void save(final Product product);
    Product getProduct(Long productId);

}
