package com.palmarcell.service;

import com.palmarcell.model.PassEntity;

import java.util.List;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */
public interface PassService {

    void addPw(PassEntity passEntity);
    void updatePw(PassEntity passEntity);
    void removePw(PassEntity passEntity);
    List<PassEntity> getPasses();
}
