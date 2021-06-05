package com.company.objects.fifth;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

// Movie의 메시지를 받은 순번이든 기간이든 해당되는 메시지가 수행된다 -> Movie와 DiscountCondition과의 다형성패턴이라고 함
// 또한 새로운 환경 조건이 추가된다고 해도 Movie는 모른다. DiscountCondition만 변경되면 되니까 안에 어떤 조건들이 있는지 모름
// 이것을 변경보호 패턴이라고 부름.

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected Money getFee() {
        return fee;
    }

    //할인 정책의 종류에 따라 할인 금액을 계산해야 하는 로직이 달라져야함.
    abstract protected Money calculateDiscountAmount();
}


//public class Movie {   // DiscountCondition에 할인 여부 메시지 전송 -> 이 메시지를 처리하기 위해 condition은 isSatisfiedBy 메서드 구성
//    private String title;
//    private Duration runningTime;
//    private Money fee;  // 기본금액
//    private List<DiscountCondition> discountConditions;
//
//    private MovieType movieType;
//    private Money discountAmount;
//    private double discountPercent;
//
//    public Money calculateMovieFee(Screening screening) {
//        if (isDiscountable(screening)) {
//            return fee.minus(calculateDiscountAmount());
//        }
//
//        return fee;
//    }
//
//    private boolean isDiscountable(Screening screening) {
//        return discountConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }
//
//    private Money calculateDiscountAmount() {
//        switch(movieType) {
//            case AMOUNT_DISCOUNT:
//                return calculateAmountDiscountAmount();
//            case PERCENT_DISCOUNT:
//                return calculatePercentDiscountAmount();
//            case NONE_DISCOUNT:
//                return calculateNoneDiscountAmount();
//        }
//
//        throw new IllegalStateException();
//    }
//
//    private Money calculateAmountDiscountAmount() {
//        return discountAmount;
//    }
//
//    private Money calculatePercentDiscountAmount() {
//        return fee.times(discountPercent);
//    }
//
//    private Money calculateNoneDiscountAmount() {
//        return Money.ZERO;
//    }
//}
