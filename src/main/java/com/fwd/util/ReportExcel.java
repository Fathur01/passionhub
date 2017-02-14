package com.fwd.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ReportExcel {

	public Map<String, String> translationLanguage() {
		Map<String, String> translation = new HashMap<>();
		translation.put("No", "No");
		translation.put("Login Count", "Jumlah Login Pengguna");
		translation.put("Agency Id", "Id Agency");
		translation.put("Agency Name", "Nama Agency");
		translation.put("First Name", "Nama Awal Perserta");
		translation.put("Last Name", "Nama Akhir Perserta");
		translation.put("Rev", "Rev");
		translation.put("Rev Type", "Tipe Rev");
		translation.put("Phone", "No Telepon");
		translation.put("Email", "Email");
		translation.put("Mobile", "No Handphone");
		translation.put("Update Date", "Tanggal Pembaruan");
		translation.put("Created Date", "Tanggal Pembuatan");
		translation.put("FWD Name", "Nama FWD");
		translation.put("ANP*", "ANP*");
		translation.put("Total Agent - Funded Agents", "Total Agent - Funded Agents");
		translation.put("Total Commitment Fee*", "Total Commitment Fee*");
		translation.put("Total Cases", "Total Cases");
		translation.put("Stacking Indication A*", "Stacking Indication A*");
		translation.put("Stacking Indication B", "Stacking Indication B");
		translation.put("Fictious Customer indication C", "Fictious Customer indication C");
		translation.put("Fictious Customer indication D", "Fictious Customer indication D");
		translation.put("Fictious Customer indication E", "Fictious Customer indication E");
		translation.put("Fictious Customer indication F", "Fictious Customer indication F");
		translation.put("Fictious Agent Indication G", "Fictious Agent Indication G");
		translation.put("Fictious Agent Indication H", "Fictious Agent Indication H");
		translation.put("Category", "Category");
		translation.put("Fwd", "Fwd");
		translation.put("Total Agents", "Total Agents");
		translation.put("By Contact Number", "By Contact Number");
		translation.put("By Agents", "By Agents");
		translation.put("Agent Name", "Agent Name");
		translation.put("Level", "Level");
		translation.put("Join", "Join");
		translation.put("Status", "Status");
		translation.put("Total Case Agent", "Total Case Agent");
		translation.put("Total Agents", "Total Agents");
		translation.put("Never Log in (Portal)", "Never Log in (Portal)");
		translation.put("Details", "Details");
		translation.put("Join Date", "Tanggal Bergabung");
		translation.put("Funding Start date", "Funding Start date");
		translation.put("Total Leaders with Financing", "Total Leaders with Financing");
		translation.put("Total Active agents", "Total Active agents");
		translation.put("Production ANP (group)", "Production ANP (group)");
		translation.put("Production by FWP & FWO", "Production by FWP & FWO");
		translation.put("Funding (group)", "Funding (group)");
		translation.put("Commitment Fee (group)", "Commitment Fee (group)");
		translation.put("Total Funding & Comitment Fee", "Total Funding & Comitment Fee");
		translation.put("Leader Name", "Leader Name");
		translation.put("Funding", "Funding");
		translation.put("Commitment Fee", "Commitment Fee");
		translation.put("Total Policy", "Total Policy");
		translation.put("Total ANP", "Total ANP");
		translation.put("ANP From Transfer Payment", "ANP From Transfer Payment");
		translation.put("%", "%");
		translation.put("Group FWD", "Group FWD");
		translation.put("Total Duplicated Agent Email with Customer Email", "Total Duplicated Agent Email with Customer Email");
		translation.put("Total Policies using Agent Email", "Total Policies using Agent Email");
		translation.put("Credit Card Number", "Credit Card Number");
		translation.put("CC used for First Premium Payment", "CC used for First Premium Payment");
		translation.put("User Agent", "User Agent");
		translation.put("Total Duplicated Contact Number Agent with Customer", "Total Duplicated Contact Number Agent with Customer");
		translation.put("Total Policy using Agent Contact Number", "Total Policy using Agent Contact Number");
		translation.put("TOTAL CALL", "TOTAL CALL");
		translation.put("UN-CONNECTED", "UN-CONNECTED");
		translation.put("CONTACTED", "CONTACTED");
		translation.put("UN-CONTACTED", "UN-CONTACTED");
		translation.put("WRONG NUMBER", "WRONG NUMBER");
		translation.put("Never Apply", "Never Apply");
		translation.put("Total", "Total");
		
		return translation;

	}

	public String translate(String msg, String language) {
		return language.equals("B") ? translationLanguage().get(msg) : msg;
	}

	public WritableCellFormat style(int typeNo) {
		try {
			WritableCellFormat cellFormat = new WritableCellFormat();
			// Header
			if (typeNo == 0) {
				cellFormat = new WritableCellFormat();
				cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
				cellFormat.setBackground(Colour.ORANGE);
				WritableFont TableFormat = new WritableFont(WritableFont.TAHOMA, 8, WritableFont.BOLD, false,
						UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
				cellFormat.setAlignment(Alignment.CENTRE);
				cellFormat.setFont(TableFormat);
				cellFormat.setWrap(true);
			} else if (typeNo == 1) {
				// Body
				cellFormat = new WritableCellFormat();
				WritableFont TFHeaderB = new WritableFont(WritableFont.TAHOMA, 8, WritableFont.BOLD);
				cellFormat.setFont(TFHeaderB);
			} else if (typeNo == 2) {
				cellFormat = new WritableCellFormat();
				WritableFont TFHeader = new WritableFont(WritableFont.TAHOMA, 8);
				cellFormat.setFont(TFHeader);
			} else if (typeNo == 3) {
				// Body
				cellFormat = new WritableCellFormat();
				cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
				WritableFont TableFormatB = new WritableFont(WritableFont.TAHOMA, 8);
				cellFormat.setFont(TableFormatB);
				cellFormat.setWrap(true);
			} else if (typeNo == 4) {
				WritableFont TableFormatC = new WritableFont(WritableFont.TAHOMA, 8);
				cellFormat.setFont(TableFormatC);
				cellFormat.setAlignment(Alignment.CENTRE);
				cellFormat.setWrap(true);
			} else {
				cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
				WritableFont TableFormatR = new WritableFont(WritableFont.TAHOMA, 8);
				cellFormat.setAlignment(Alignment.RIGHT);
				cellFormat.setFont(TableFormatR);
				cellFormat.setWrap(true);
			}
			return cellFormat;
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public WritableSheet sheetHeader(WritableSheet sheet, WritableCellFormat style, List<String> label,
			String language) {
		try {
			int column = 0;
			for (String labelHeader : label) {

				sheet.addCell(new Label(column, 0, translate(labelHeader, language), style));

				column++;
			}
			return sheet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public WritableSheet sheetBody(WritableSheet sheet, WritableCellFormat style, List<String> label,int row,List<Integer> mergeCell) {
		try {
			int column = 0;
			if(mergeCell!=null)
				sheet.mergeCells(mergeCell.get(0), mergeCell.get(1), mergeCell.get(2), mergeCell.get(3));
			
			for (String labelBody : label) {
								
				sheet.addCell(new Label(column, row, labelBody, style));

				column++;
			}
			return sheet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
