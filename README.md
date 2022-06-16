# 키친포스

## 요구 사항
- [X] 메뉴를 생성할 수 있다.
  - 메뉴는 메뉴그룹에 속해야 한다.
  - 메뉴 구성품들 중 조회가 되지 않는 구성품이 있으면 메뉴로 추가할 수 없다.
  - 메뉴 구성품들의 가격 총합보다 메뉴 가격이 크거나 같으면 메뉴로 추가할 수 없다.
  - 메뉴 가격이 NULL 이거나 음수이면 메뉴를 추가할 수 없다.
- [X] 전체 메뉴를 조회할 수 있다.

- [X] 메뉴 그룹을 생성할 수 있다.
- [X] 전체 메뉴 그룹을 조회할 수 있다.

- [ ] 주문을 생성할 수 있다.
  - 주문 항목은 1개 이상 있어야 한다.
  - 테이블이 존재해야 한다.
  - 상태가 '조리'로 바뀐다.
- [ ] 전체 주문을 조회할 수 있다.
- [ ] 주문의 상태를 변경할 수 있다.
  - 상태가 '계산 완료'인 경우 변경할 수 없다.

- [X] 상품을 생성할 수 있다.
    - 가격이 자연수여야 한다.
- [X] 전체 상품을 조회할 수 있다.

- [X] 테이블을 생성할 수 있다.
- [X] 전체 테이블을 조회할 수 있다.
- [X] 테이블을 빈 상태로 변경할 수 있다.
    - 주문 상태가 '조리' 혹은 '식사' 가 아니어야 한다.
    - 주문 테이블을 id로 조회할 수 있어야 한다.
    - 주문 테이블의 그룹 id 가 비어있어야 한다.
- [X] 테이블의 손님 수를 변경할 수 있다.
    - 빈 테이블인 경우 변경할 수 없다.
    - 손님 수는 0 이상이어야 한다.
    - 주문 테이블을 id 로 조회할 수 있어야 한다. 

- [ ] 테이블 그룹을 생성할 수 있다.
    - 주문 테이블이 2개 이상이어야 한다.
- [ ] 테이블 그룹을 해제할 수 있다.
    - 주문 상태가 '조리' 혹은 '식사' 가 아니어야 한다. 

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |
