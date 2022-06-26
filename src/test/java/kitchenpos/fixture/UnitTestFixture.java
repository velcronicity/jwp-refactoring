package kitchenpos.fixture;

import java.math.BigDecimal;
import java.util.Arrays;
import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuProduct;
import kitchenpos.domain.Product;

public class UnitTestFixture {
    public final MenuGroup 구이류 = new MenuGroup(1L, "구이류");
    public final MenuGroup 식사류 = new MenuGroup(2L, "식사류");

    public final Product 삼겹살 = new Product(1L, "삼겹살", BigDecimal.valueOf(14000L));
    public final Product 목살 = new Product(2L, "목살", BigDecimal.valueOf(15000L));
    public final Product 김치찌개 = new Product(3L, "김치찌개", BigDecimal.valueOf(8000));
    public final Product 공깃밥 = new Product(4L, "공깃밥", BigDecimal.valueOf(1000));

    public final MenuProduct 돼지모듬_삼겹살 = new MenuProduct(1L, 1L, 삼겹살.getId(), 2);
    public final MenuProduct 돼지모듬_목살 = new MenuProduct(2L, 1L, 목살.getId(), 1);
    public final MenuProduct 김치찌개정식_김치찌개 = new MenuProduct(3L, 2L, 김치찌개.getId(), 1);
    public final MenuProduct 김치찌개정식_공깃밥 = new MenuProduct(4L, 2L, 공깃밥.getId(), 1);

    public final Menu 돼지모듬 = new Menu(
            1L, "돼지모듬", BigDecimal.valueOf(43000L), 구이류.getId(), Arrays.asList(돼지모듬_삼겹살, 돼지모듬_목살));
    public final Menu 김치찌개정식 = new Menu(
            2L, "김치찌개정식", BigDecimal.valueOf(9000), 식사류.getId(), Arrays.asList(김치찌개정식_김치찌개, 김치찌개정식_공깃밥));
}
