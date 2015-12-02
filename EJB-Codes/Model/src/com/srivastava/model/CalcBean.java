package com.srivastava.model;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalcBean
 */
@Stateless
public class CalcBean implements CalcBeanRemote, CalcBeanLocal {

    /**
     * Default constructor. 
     */
    public CalcBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

}
