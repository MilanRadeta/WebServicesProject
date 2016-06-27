package utils.test;

import java.util.Calendar;
import java.util.Date;

import jess.Context;
import jess.JessException;
import jess.Rete;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

public class Test {

	// TODO: test all rules

	public static void main(String[] args) {

		try {
			Date date = new Date();
			Calendar cal = Calendar.getInstance(); // creates calendar
			cal.setTime(new Date()); // sets calendar time/date
			cal.add(Calendar.HOUR_OF_DAY, 24); // adds one hour
			// returns new date object, one hour in the future
			Date date2 = cal.getTime();
			long diffTime = date2.getTime() - date.getTime();
			long diffDays = diffTime / (1000 * 60 * 60 * 24);
			System.out.println(date);
			System.out.println(date2);
			System.out.println(diffTime);
			System.out.println(diffDays);
		    /*
			Rete engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/functions/functions.clp");
			ValueVector vector = new ValueVector();
			vector.add(date);
			vector.add(date);
			System.out.println(vector.toString());
			Userfunction function = engine
					.findUserfunction("getDateDifferenceInDays");
			System.out.println(function);
			function.call(vector, engine.getGlobalContext());
			Value value = function.call(vector, engine.getGlobalContext());
			System.out.println(value.toString());
			engine.eval("(facts)");*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
