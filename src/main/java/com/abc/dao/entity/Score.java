package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private int scid;
    private BigDecimal score;
    private int sid;
    private int cid;
    private Course course;

    }
