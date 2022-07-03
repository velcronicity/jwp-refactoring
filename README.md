# 키친포스

## 요구 사항
### 메뉴(Menu) 및 메뉴 상품(MenuProduct)
#### 등록
* [x] 메뉴를 등록할 수 있다.
  * [x] 메뉴 이름(name), 가격(price), 메뉴 그룹 ID(menuGroupId) 및 상품ID(productId), 수량(quantity) 으로 구성된 메뉴 상품 목록을 입력 받아 등록한다.
* [x] 메뉴의 가격이 올바르지 않으면 등록할 수 없다.
  * [x] 메뉴의 가격은 반드시 입력되어야 하고, 0 원 이상이어야 한다.
  * [x] 등록하고자 하는 메뉴의 메뉴그룹ID 가 menu_group 테이블에 존재하지 않으면 등록할 수 없다.
* [x] 메뉴의 가격은 메뉴에 포함된 각 상품의 (상품 * 수량) 합과 같거나 작다.
* [x] 메뉴 상품 목록 내 각 메뉴상품을 저장된 메뉴 정보에 추가한다.
* [x] 메뉴를 등록한 후 저장된 메뉴 데이터를 리턴한다.

#### 조회
* [x] 메뉴 목록을 조회한다.
* [x] 각 메뉴별 메뉴 상품을 메뉴ID 로 검색하여 조회된 메뉴 목록 결과에 추가 후 리턴한다.


### 메뉴 그룹(MenuGroup)
#### 등록
* [x] 메뉴 그룹을 등록할 수 있다.
  * [x] 메뉴 그룹명(name) 을 입력 받아 등록 한다.

#### 조회
* [x] 메뉴 그룹 목록을 조회할 수 있다.

### 상품(Product)
#### 등록
* [x] 상품을 등록할 수 있다.
  * [x] 상품의 이름(name) 과 가격(price) 을 입력 받아 등록한다.
  * [x] 상품의 가격은 반드시 입력되어야 하고, 0원 이상이어야 한다.

#### 조회
* [x] 상품 목록을 조회할 수 있다.


### 주문(Order) 및 주문 항목(OrderLineItem)
#### 등록
* [ ] 매장에서 발생하는 주문을 등록할 수 있다.
  * [ ] 주문 항목이 존재하지 않으면 등록할 수 없다.
  * [ ] 주문 항목의 수와 메뉴 테이블에 등록된 메뉴의 수량이 다르면 등록할 수 없다.
  * [ ] 주문 테이블이 존재하지 않으면 등록할 수 없다.
* [ ] 주문 상태를 COOKING 으로 등록한다.
* [ ] 주문 테이블의 ID 와 주문 시간을 등록한다.
* [ ] 주문을 저장한 후, 주문에 포함된 주문 항목을 등록한다. 

#### 조회
* [ ] 주문 목록을 조회한다.
* [ ] 각 주문별 주문 항목을 주문ID 로 검색하여 조회된 주문 목록 결과에 추가 후 리턴한다.

#### 주문 상태 변경
* [ ] 주문ID 와 orderStatus 를 입력 받아 주문 상태를 변경한다.
  * [ ] 주문ID 로 조회되지 않는 주문의 상태는 변경할 수 없다.
  * [ ] 상태를 변경하고자 하는 주문의 상태가 COMPLETION 인 경우 변경할 수 없다.
* [ ] 주문ID 에 해당하는 주문 항목을 검색하여 함께 저장한다.

### 주문 테이블(OrderTable)
#### 등록
* [x] 방문한 손님 수(numberOfGuests) 와 empty 유무를 입력 받아 주문 테이블을 등록할 수 있다.
  * [x] 등록 시 단체 지정 ID 는 null 로 지정한다.

#### 조회
* [x] 주문 테이블 목록을 조회할 수 있다.

#### empty 로 상태 변경
* [x] 주문 테이블 ID 를 입력 받아 테이블을 빈 테이블로 변경할 수 있다.
  * [ ] 주문 테이블의 단체 지정 정보가 null 이 아니면 변경이 불가능하다.
  * [ ] 주문 테이블 ID 에 해당하는 주문의 주문 상태가 COOKING 이거나 MEAL 인 상태인 경우 변경이 불가능하다.

#### 방문한 손님 수 변경
* [x] 주문 테이블의 ID 와 방문한 손님의 수(numberOfGuests) 를 입력 받아 방문한 손님의 수를 변경할 수 있다.
  * [x] 방문한 손님의 수가 0 미만인 경우 변경이 불가능하다.
  * [x] 테이블ID 를 이용하여 주문 테이블의 정보가 조회되지 않으면 변경이 불가능하다

### 단체 지정(TableGroup)
#### 등록
* [ ] 단체를 등록할 수 있다.
  * [ ] 입력된 단체의 주문이 존재하지 않거나 주문이 2건 미만인 경우 등록이 불가능하다.
  * [ ] 주문 테이블의 ID 로 저장된 주문 테이블의 개수와 입력된 주문 테이블의 개수가 같지 않으면 등록이 불가능하다.
  * [ ] 저장된 주문 테이블이 있거나, 저장된 단체 ID 가 존재하는 경우 등록이 불가능하다.
  * [ ] 빈 테이블 여부를 false 로 등록하여 저장한다.
  
#### 단체 해제
* [ ] 단체를 해제할 수 있다.
* [ ] 단체ID 로 조회된 단체의 주문 상태가 COOKING, MEAL 인 경우 해제가 불가능하다
* [ ] 단체ID 를 null 로 설정 후 저장한다.


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
