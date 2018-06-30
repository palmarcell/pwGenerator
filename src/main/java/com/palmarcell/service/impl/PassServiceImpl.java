package com.palmarcell.service.impl;

import com.palmarcell.dao.impl.PassDAOImpl;
import com.palmarcell.model.PassEntity;
import com.palmarcell.service.PassService;

import java.util.List;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */
public class PassServiceImpl implements PassService {

    private PassDAOImpl passDAO;

    public PassServiceImpl(PassDAOImpl passDAO) {
        this.passDAO = passDAO;
    }

    @Override
    public void addPw(PassEntity passEntity) {

        passDAO.persist(passEntity);
    }

    @Override
    public void updatePw(PassEntity passEntity) {

        passDAO.update(passEntity);

    }

    @Override
    public void removePw(PassEntity passEntity) {

        passDAO.delete(passEntity);
    }

    @Override
    public List<PassEntity> getPasses() {

       return passDAO.getPasses();
    }

}
