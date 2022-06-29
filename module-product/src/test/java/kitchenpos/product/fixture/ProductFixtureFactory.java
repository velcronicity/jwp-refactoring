package kitchenpos.product.fixture;

import java.math.BigDecimal;
import kitchenpos.product.domain.Product;

public class ProductFixtureFactory {

    private ProductFixtureFactory() {}

    public static Product create(String name, BigDecimal price) {
        return Product.of(name, price);
    }

    public static Product create(Long id, String name, BigDecimal price) {
        return Product.of(id, name, price);
    }
}
