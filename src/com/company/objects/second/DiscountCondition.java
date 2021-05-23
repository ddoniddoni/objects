package com.company.objects.second;

/**
 할인조건
**/

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
