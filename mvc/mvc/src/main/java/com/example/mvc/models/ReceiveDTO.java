/*
 * ReceiveDTO
 * mvc
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-11-05.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package com.example.mvc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class ReceiveDTO {

    private Long currentCount;
    private ArrayList<DataDTO> data;
    private Long matchCount;
    private Long page;
    private Long perPage;
    private Long totalCount;
    @Data
    @NoArgsConstructor
    public class DataDTO {
        // 기준일자 요일
        private String dywk;
        // 기준일자 진료종료시간
        private String endTm;
        // 기준일자 휴무일여부
        private String hldyYn;
        // 기준일자 점심종료시간
        private String lunchEndTm;
        // 기준일자 점심시작시간
        private String lunchSttTm;
        // 기관전화번호
        private String orgTlno;
        // 기관주소
        private String orgZipaddr;
        // 기관코드
        private String orgcd;
        // 기관명
        private String orgnm;
        // 기준일자(현재날짜)
        private String slrYmd;
        // 기준일자 진료시작시간
        private String sttTm;
    }
}
