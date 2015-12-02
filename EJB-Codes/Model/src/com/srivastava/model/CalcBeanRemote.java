package com.srivastava.model;

import javax.ejb.Remote;

@Remote
public interface CalcBeanRemote {
public int add(int x, int y);
}
