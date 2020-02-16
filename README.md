# JPA Shop

## Using Libraries

- Spring MVC
- Spring ORM
- JPA, Hibernate, 
- Spring Data JPA
- H2 Database Client
- Connection Pool : HikariCP
- Thymeleaf
- SLF4J & LogBack
- JTest
- Lombok


## Tips

### Entity에서는 가급적 Setter를 사용하지 말자
- Setter가 모두 열려있으면 변경 포인트가 너무 많아서 유지보수가 어렵다.

### 모든 연관관계는 지연로딩(LAZY)으로 설정

- 즉시로딩(EAGER)은 예측이 어렵고, SQL을 추적하기 어렵다. 특히 N + 1 문제가 자주 발생함
- 실무에서 모든 연관관계는 지연로딩(LAZY)로 설정해야 한다.
- 연관된 엔티티를 함께 DB에서 조회해야 하면, fetch join 또는 엔티티 그래프 기능을 사용한다.
- @XToOne(OneToOne, ManyToOne) 관계는 기본이 즉시로딩(EAGER)이므로 직접 지연로딩(LAZY)로 설정해야 한다.


### 컬렉션(Collection)은 필드에서 초기화

- 컬렉션은 필드에서 초기화 하는 것이 안전하다.
- null 문제에서 안전해짐.
- 하이버네이트는 엔티티를 영속화 할 때, 컬렉션을 감싸서 하이버네이트가 제공하는 내장 컬렉션으로 변경한다. 만약 getOrders() 처럼 임의의 메서드에서 컬렉션을 잘못 생성하면 하이버네이트 내부 메커니즘에 문제가 발생할 수 있다. 따라서 필드레벨에서 생성하는 것이 가장 안전하고, 코드도 간결하다.

## Links

- Spring Boot DataSource Decorator  
https://github.com/gavlyukovskiy/spring-boot-data-source-decorator