package org.jae.productorderservice.product;

interface ProductPort {
    void save(final Product product);
    Product getProduct(final Long productId);

}
