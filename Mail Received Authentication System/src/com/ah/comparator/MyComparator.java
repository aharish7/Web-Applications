package com.ah.comparator;

import java.util.Comparator;

import com.ah.bean.MailBean;

public class MyComparator implements Comparator<MailBean>{


	@Override
	public int compare(MailBean b1, MailBean b2) {
		return -b1.getTime().compareTo(b2.getTime());
	}

}
