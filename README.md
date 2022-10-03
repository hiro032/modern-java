# modern-java

## 1. 동작 파라미터화 코드 전달하기

## 2. 람다 표현식

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
