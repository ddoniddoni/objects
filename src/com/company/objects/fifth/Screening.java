package com.company.objects.fifth;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}


//public class Screening {
//    private Movie movie;    //"가격을 계산하라"라는 메세지를 보내기 위해
//    private int sequence;       //상영순번
//    private LocalDateTime whenScreened;     //상영 시간
//
//    public Reservation reserve(Customer customer, int audienceCount) { // 밑에서 계산된 금액을 이용해 Reservation 생성
//        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
//    }
//
//    private Money calculateFee(int audienceCount) { // 예매 인원수를 곱해서 전체 예매 요금을 결정
//        return movie.calculateMovieFee(this).times(audienceCount); // movie에게 메시지만 전송하면서 내부 구현은 고려하지 않음
//    }
//
//    public LocalDateTime getWhenScreened() {
//        return whenScreened;
//    }
//
//    public int getSequence() {
//        return sequence;
//    }
//}
