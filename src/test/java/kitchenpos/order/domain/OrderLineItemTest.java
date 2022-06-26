package kitchenpos.order.domain;

import static org.assertj.core.api.Assertions.assertThat;

import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.Price;
import kitchenpos.table.domain.GuestNumber;
import kitchenpos.table.domain.OrderTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderLineItemTest {

    @Test
    @DisplayName("주문항목 객체가 같은지 검증")
    void verifyEqualsOrderLineItem() {
        final Menu menu = new Menu.Builder("menu")
                .setPrice(Price.of(1_000L))
                .build();
        final OrderTable orderTable = new OrderTable(null, null, GuestNumber.of(2), false);
        final Orders order = new Orders(null, orderTable, null, null, null);
        final OrderLineItem orderLineItem = new OrderLineItem(1L, order, menu, Quantity.of(1L));

        assertThat(orderLineItem).isEqualTo(new OrderLineItem(1L, order, menu, Quantity.of(1L)));
    }
}
