package com.cognizant.microcredentials.process.util;

import java.sql.Date;
import java.util.Calendar;

import com.cognizant.microcredentials.process.entity.User;
import com.cognizant.microcredentials.process.request.PremiumRequest;


public class BusinessUtil {
	
	/*Validate the user details
	 * @Param user
	 * @Param request
	 * @return boolean
	 * */
	public static boolean validateUser(User user, PremiumRequest request) {
		boolean valid = false;

		if (null != user) {
			if (String.valueOf(user.getSsn()).equals(request.getSsn())) {
				String dateOfBirth = user.getDateOfBirth().toString();
				if (dateOfBirth.equals(request.getDateOfBirth().toString())) {
					valid = true;
				}
			}
		}
		return valid;
	}

	/*Find the next month date
	 * @Param date
	 * @return date
	 * */
	public static Date findNextMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		Date nextDueDate = new Date(cal.getTimeInMillis());
		return nextDueDate;
	}

}
