package org.mea.util;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.mea.model.AbstractAuditable;
import org.mea.web.errorhandlers.MEAException;

public class MEAUtil {

	public void applyAuditing(AbstractAuditable auditable, Long createdBy) {
		Date currentDate = new Date();
		if (auditable.isNew()) {
			auditable.setCreatedBy(createdBy);
			auditable.setCreatedDate(currentDate);
		}
		auditable.setLastModifiedBy(createdBy);
		auditable.setLastModifiedDate(currentDate);
	}

	public Long calculateElapsedDays(String stateDate) throws MEAException {
		Calendar currentDate= Calendar.getInstance();
		Calendar elapsedCalendarDate= Calendar.getInstance();
		String elapsedStrDate=stateDate.split(" ")[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date elapsedDate=null;
		Long daysBetween=null;
		try {
			elapsedDate=sdf.parse(elapsedStrDate);
			elapsedCalendarDate.setTime(elapsedDate);
			daysBetween = ChronoUnit.DAYS.between(elapsedCalendarDate.toInstant(), currentDate.toInstant());
		} catch (Exception e) {
			throw new MEAException(e.getMessage());
		}

		return daysBetween;
	}
	

}
