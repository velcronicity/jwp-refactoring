package kitchenpos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuGroupTest {

    @DisplayName("메뉴묶음을 생성한다.")
    @Test
    void create() {
        //given
        String name = "name";

        //when
        MenuGroup menuGroup = new MenuGroup(name);

        //then
        assertEquals(name, menuGroup.getName());
    }
}