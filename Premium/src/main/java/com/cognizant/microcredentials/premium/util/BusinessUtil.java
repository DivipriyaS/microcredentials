package com.cognizant.microcredentials.premium.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import com.cognizant.microcredentials.premium.entity.User;
import com.cognizant.microcredentials.premium.request.PremiumRequest;

public class BusinessUtil {

	/*Validate the user details
	 * @Param user
	 * @Param request
	 * @return boolean
	 * */
	public static boolean validateUser(Optional<User> user, PremiumRequest request) {
		boolean valid = false;
			
			if (String.valueOf(user.get().getSsn()).equals(request.getSsn())) {
				valid =true;
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
