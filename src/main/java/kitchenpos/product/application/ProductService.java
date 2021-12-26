package kitchenpos.product.application;

import kitchenpos.product.domain.ProductRepository;
import kitchenpos.product.domain.Product;
import kitchenpos.product.dto.ProductRequest;
import kitchenpos.product.dto.ProductResponse;
import kitchenpos.product.exception.NoProductException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse create(final ProductRequest productRequest) {
        Product savedProduct = productRepository.save(Product.of(productRequest.getName(), productRequest.getPrice()));
        return ProductResponse.from(savedProduct);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(NoProductException::new);
    }
}
