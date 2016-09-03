package com.chenxun.jxl;



import java.io.File;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @author：chenxun 创建时间：2016年7月21日 下午10:50:24 参考： 说明：
 */
public class CreateXls {
	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		File file = new File("d:/Test.xls");
		
		WritableWorkbook book = Workbook.createWorkbook(file);
		WritableSheet sheet = null;
		for (int i = 0; i < 5; i++) {
		     sheet = book.createSheet("Sheet_"+i,i);
		     doing(sheet,i);
		}
		
		book.write();
		book.close();
		
		long end = System.currentTimeMillis();
		System.out.println("用时======="+(end-start)/1000);
	}

	/**
	 * @param book
	 * @param sheet
	 */
	private static void doing(WritableSheet sheet,int n) {
		try {
			sheet.setColumnView(0, 5); // 设置列的宽度
			sheet.setColumnView(1, 30); // 设置列的宽度
			sheet.setColumnView(2, 10); // 设置列的宽度
			sheet.setColumnView(3, 10); // 设置列的宽度
			sheet.setColumnView(4, 10); // 设置列的宽度
			sheet.setColumnView(6, 10); // 设置列的宽度
			sheet.setColumnView(5, 25); // 设置列的宽度
			sheet.setRowView(0, 500);
			sheet.setRowView(1, 500);
			sheet.setRowView(2, 1000);
			Label labe0;
			
			WritableCellFormat wcfauto1 = fontstyle();
			WritableCellFormat wcfauto2 = wcfauto2();
		    labe0 = new Label(0, 0, "中国石油大学（北京）远程教育学院试卷交接清单", wcfauto1);
			sheet.addCell(labe0);
			sheet.mergeCells(0, 0, 6, 0);
			labe0 = new Label(0, 1, "考点名称： 南京 　 考试批次： 20101127 试卷类型： A 卷",wcfauto1);
			sheet.addCell(labe0);
			sheet.mergeCells(0, 1, 6, 1);
	
			Number labe2 ;
			int x = n*60000;
			for (int i = 2; i <60000; i++) {
				int y  = i+x;
				Thread.sleep(1);
				labe2= new Number(0, i,y, wcfauto2);
				sheet.addCell(labe2);
				labe0 = new Label(1, i, "学习中心/课目名称", wcfauto2);
				sheet.addCell(labe0);
				labe0 = new Label(2, i, "考试类型", wcfauto2);
				sheet.addCell(labe0);
				labe0 = new Label(3, i, "考试场次", wcfauto2);
				sheet.addCell(labe0);
				labe0 = new Label(4, i, "试卷包数", wcfauto2);
				sheet.addCell(labe0);
				labe0 = new Label(5, i, "层次", wcfauto2);
				sheet.addCell(labe0);
				labe0 = new Label(6, i, "备注", wcfauto2);
				sheet.addCell(labe0);
				
				System.out.println("运作======="+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws WriteException
	 */
	private static WritableCellFormat wcfauto2() throws WriteException {
		WritableFont wfauto2 = new WritableFont(
				WritableFont.createFont("宋体"), 12, WritableFont.BOLD,
				false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat wcfauto2 = new WritableCellFormat(wfauto2,
				NumberFormats.TEXT);
		wcfauto2.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfauto2.setAlignment(Alignment.CENTRE);// 内容水平居中
		// 内容垂直居中
		wcfauto2.setVerticalAlignment(VerticalAlignment.CENTRE);
		wcfauto2.setBackground(Colour.YELLOW);
		return wcfauto2;
	}

	/**
	 * @param sheet
	 * @return
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private static WritableCellFormat fontstyle()throws WriteException, RowsExceededException {
		//样式
		WritableFont wfauto0 = new WritableFont(
				WritableFont.createFont("宋体"), 16, WritableFont.BOLD,
				false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat wcfauto0 = new WritableCellFormat(wfauto0,
				NumberFormats.TEXT);
		// 内容居中的显示
		wcfauto0.setAlignment(Alignment.CENTRE);
		wcfauto0.setBackground(Colour.YELLOW);
		wcfauto0.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		/*
		 * 合并单元格， 
		 * 第一个参数：要合并的单元格最左上角的列号， 
		 * 第二个参数：要合并的单元格最左上角的行号，
		 * 第三个参数：要合并的单元格最右角的列号， 
		 * 第四个参数：要合并的单元格最右下角的行号，
		 */
		WritableFont wfauto1 = new WritableFont(
				WritableFont.createFont("宋体"), 12, WritableFont.BOLD,
				false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat wcfauto1 = new WritableCellFormat(wfauto1,
				NumberFormats.TEXT);
		wcfauto1.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcfauto1.setAlignment(Alignment.CENTRE);
		wcfauto1.setVerticalAlignment(VerticalAlignment.CENTRE);
		return wcfauto1;
	}
}
