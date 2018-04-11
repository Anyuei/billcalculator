package billcalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Calculator.java
 * @author anyunpei
 *2018年3月24日下午9:10:56
 *   @param interests
 *   		利息
 *   @param interestMonth
 * 
 */
public class Calculator {
	public double calculator(String loan, String repay, double principal, double rate) {
		// parse方法：将字符串类型（java.lang.String）解析为日期类型（java.util.Date）
		// format方法：将日期类型（Date）数据格式化为字符串（String）

		double interests = 0;// 利息
		double interestsMonth = 0;// 月利息
		Date loanDate = null;// 借日期
		Date repayDate = null;// 还日期

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 自定义日期格式
		try {
			loanDate = format.parse(loan);
			repayDate = format.parse(repay);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int days = differentDaysByMillisecond(loanDate, repayDate);
		int months = differentDaysByMillisecond(loanDate, repayDate) / 30;
		interests = days * principal * rate;

		for (int i = 1; i < days; i++) {

			if (i % 30 == 0) {
				interestsMonth = 30 * principal * rate;
				principal = principal + interestsMonth;
				System.out.print("第" + i / 30 + "个月应还" + (int) principal);
				System.out.println("第" + i / 30 + "个月利息为" + (int) interestsMonth);
			}

		}
		System.out.println("----------------------");
		return interests;
	}

	/*
	 * 计算两个日期 date1 和 date2 的时间差
	 */
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

}
