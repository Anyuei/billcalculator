package billcalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Calculator.java
 * @author anyunpei
 *2018��3��24������9:10:56
 *   @param interests
 *   		��Ϣ
 *   @param interestMonth
 * 
 */
public class Calculator {
	public double calculator(String loan, String repay, double principal, double rate) {
		// parse���������ַ������ͣ�java.lang.String������Ϊ�������ͣ�java.util.Date��
		// format���������������ͣ�Date�����ݸ�ʽ��Ϊ�ַ�����String��

		double interests = 0;// ��Ϣ
		double interestsMonth = 0;// ����Ϣ
		Date loanDate = null;// ������
		Date repayDate = null;// ������

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// �Զ������ڸ�ʽ
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
				System.out.print("��" + i / 30 + "����Ӧ��" + (int) principal);
				System.out.println("��" + i / 30 + "������ϢΪ" + (int) interestsMonth);
			}

		}
		System.out.println("----------------------");
		return interests;
	}

	/*
	 * ������������ date1 �� date2 ��ʱ���
	 */
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

}
