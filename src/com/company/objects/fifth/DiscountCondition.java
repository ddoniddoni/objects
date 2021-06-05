package com.company.objects.fifth;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}


//public class DiscountCondition {
//    private DiscountConditionType type;
//    private int sequence;
//    private DayOfWeek dayOfWeek;
//    private LocalTime startTime;
//    private LocalTime endTime;
//
//    public boolean isSatisfiedBy(Screening screening) { // 전송된 메시지를 받기위해 메서드 구성
//        if (type == DiscountConditionType.PERIOD) {
//            return isSatisfiedByPeriod(screening);
//        }
//
//        return isSatisfiedBySequence(screening);
//    }
//
//    private boolean isSatisfiedByPeriod(Screening screening) {
//        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
//                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//                endTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0;
//    }
//
//    private boolean isSatisfiedBySequence(Screening screening) {
//        return sequence == screening.getSequence();
//    }
//}

// -> 변경에 취약함! 1. 새로운 할인 조건 추가, 2. 순번조건을 판단하는 로직 변경, 3. 기간 조건을 판단하는 로직이 변경
// -> 여기서 가장 큰 문제점은 순번 조건과 기간 조건이 하나의 클래스안에 공존한다는 점. 이것을 2개의 클래스로 분리 필요
// -> 하지만 또 2개로 나누니까 Movie의 인스턴스들은 순번조건과, 기간조건의 클래스의 인스턴스와 모두 협력할 수 있어야 한다는 문제가 생긴다.
// -> 155쪽 소스를 보면 또 위 문제를 해결하기 위해 List로 순번과 기간조건을 따로 갖고 있는 것인데, 또 문제가 발생
// -> 클래스 양쪽에 묶이면서 결합도가 증가해버리고, 할인조건을 추가하면 또 Movie에 추가된다는 점?

