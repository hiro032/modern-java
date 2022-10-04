# modern-java

## 2. Lambda Expression

### 2.1 람다란 무엇인가
람다 표현식은 메서드로 전달할 수 있는 익명 함수를 단수화한 것.
이름은 없지만, 파라미터 리스트, 바디, 반환 형식, 발생할 수 있는 예외 리스트는 가질 수 있음.

람다의 특징은 다음과 같다.
- 익명: 보통의 메서드와 달리 이름이 없음
- 함수: 람다는 메서드처럼 특정 클래스에 종속되어 있지 않기에 메서드가 아닌 '함수'로 부름
- 전달: 메서드의 인수로 전달하거나, 변수에 저장, 응답 타입으로 반환 가능 
- 간결성: 익명 클래스와 같이 구현하는 코드가 필요 없음

자바에서 존재하는 람다 사용 예시 (ex_Comparator)
``` Java
// Basic Code
Comparator<Apple> byWeight = new Comparator<Apple>() {
  public int compare(Apple a1, Apple a2) {
    return a1.getWetight().compareTo(a2.getWeight());
  }
}

// Lambda
Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWetight().compareTo(a2.getWeight());
     
```
### 2.2 어디에, 어떻게 람다를 사용할까?
람다 함수는 함수형 인터페이스로 정의된 타입의 변수로 받을 수 있다.
이렇게 참조로 표현되는 람다는 메서드의 파라미터, 응답 타입, 변수를 통해 전달 될 수 있고 이런 특성을 통해 자바에서 일급 객체로 다뤄질 수 있다.

### 2.3 함수형 인터페이스
함수형 인터페이스는 오직 하나의 추상 메서드를 가져야 한다. (default 메서드나 static 메서드는 여러 개여도 상관없음.)

자바 8 에서 제공하는 대표적인 함수형 인터페이스를 알아보자.
```Java
@FunctionalInterface
public interface Predicate<T> {
  boolean test(T t);
}

Predicate predicate = (String s) -> s.isEmpty();
```

```Java
@FunctionalInterface
public interface Consumer<T> {
  void accept(T t);
}

Consumer consumer = (String text) -> System.out.println(text);
```

```Java
@FunctionalInterface
public interface Function<T, R> {
  R apply(T t);
}

Function functional = (String s) -> s.length();
```

## null 대신 Optional 클래스

### null 때문에 발생하는 문제
- 에러의 근원이다: NullPointerException은 자바에서 가장 흔히 발생하는 에러다.
- 코드를 어지럽힌다: 때로는 중첩된 null 확인 코드를 추가해야하므로 null로 인해 코드의 가독성이 떨어진다.
- 아무 의미가 없다: null은 아무 의미표현하지 않는다. 
- 자바 철학에 위배된다: 자바는 개발자로부터 모든 포인터를 숨겼다. 하지만 예외가 있는데 그것이 바로 null 포인다.
- 형식 시스템에 구멍을 만든다: null은 무형식이며 정보를 포함하고 있지 않다. 시스템의 다른 부분으로 null이 퍼졌을 떄 애초에 null이 어떤 의미로 사용되었는지 알 수 없다.

