package kitchenpos.application;

import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuGroupRepository;
import kitchenpos.dto.MenuGroupRequest;
import kitchenpos.dto.MenuGroupResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("메뉴 그룹 서비스 테스트")
@ExtendWith(MockitoExtension.class)
class MenuGroupServiceTest {
    @Mock
    private MenuGroupRepository menuGroupRepository;

    private MenuGroupService menuGroupService;
    private MenuGroup exampleMenuGroup;
    private MenuGroup exampleMenuGroup2;

    private MenuGroupRequest exampleMenuGroupRequest;
    private MenuGroupRequest exampleMenuGroupRequest2;

    @BeforeEach
    void setUp() {
        menuGroupService = new MenuGroupService(menuGroupRepository);
        exampleMenuGroup = new MenuGroup(1L, "메뉴 이름");
        exampleMenuGroup2 = new MenuGroup(2L, "메뉴 이름2");

        exampleMenuGroupRequest = new MenuGroupRequest(1L, "메뉴 이름");
        exampleMenuGroupRequest2 = new MenuGroupRequest(2L, "메뉴 이름2");
    }

    @DisplayName("메뉴 그룹 생성 테스트")
    @Test
    void createMenuGroupTest() {
        when(menuGroupRepository.save(any())).thenReturn(exampleMenuGroup);

        // when
        final MenuGroupResponse createdMenuGroup = menuGroupService.create(exampleMenuGroupRequest);

        // then
        assertAll(
                () -> assertThat(createdMenuGroup.getId()).isEqualTo(1L),
                () -> assertThat(createdMenuGroup.getName()).isEqualTo("메뉴 이름")
        );
    }

    @DisplayName("메뉴 그룹 목록 조회 테스트")
    @Test
    void getListMenuGroupTest() {
        when(menuGroupRepository.findAll())
                .thenReturn(Lists.newArrayList(exampleMenuGroup, exampleMenuGroup2));

        // when
        final List<MenuGroupResponse> createdMenuGroups = menuGroupService.list();

        // then
        assertAll(
                () -> assertThat(createdMenuGroups.get(0).getName()).isEqualTo("메뉴 이름"),
                () -> assertThat(createdMenuGroups.get(1).getName()).isEqualTo("메뉴 이름2")
        );
    }
}