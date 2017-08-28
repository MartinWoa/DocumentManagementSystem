package System;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Point2D;
import java.awt.print.*;
import java.text.AttributedString;


public class Printer implements Printable {
	static private Printer pr;

	private String headout=null;
	private String texts=null;
	private void setString(String headout,String texts)
	{
		this.headout=headout;
		this.texts=headout+"                                                  \r\n"+texts;
		
	}
	
	private Printer() {
	}
	
	
     static public void printPage(String headout,String texts)
    {  
    	 if(pr==null) {pr=new Printer();}
		PrinterJob job = PrinterJob.getPrinterJob();
        pr.setString(headout, texts);
		PageFormat pageFormat =job.defaultPage();//得到默认页格式

		job.setPrintable(pr);//设置打印类

		 

		try {

		 //显示打印提示窗口

		if(job.printDialog()) {

		job.print();

		}

		} catch (PrinterException e) {

		e.printStackTrace();

		}
    }
     
     
	@Override
	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub

        Component c =null;

       //print string

       //转换成Graphics2D

       Graphics2D g2 = (Graphics2D) gra;

       g2.setColor(Color.black);

       //打印起点坐标

       double x =pf.getImageableX();

       double y =pf.getImageableY();

       

       switch(pageIndex){

          case 0:            

            Font font = new Font("新宋体", Font.PLAIN, 13);

            g2.setFont(font);//设置字体

            float[]dash1 = {4.0f};

            g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,4.0f,dash1,0.0f));

            float heigth =font.getSize2D();//字体高度


          

            FontRenderContext frc =g2.getFontRenderContext();

            TextLayout layout = new TextLayout(texts,font,frc);

            AttributedString text = new AttributedString(texts);

            text.addAttribute(TextAttribute.FONT,font);

            LineBreakMeasurer lineBreaker =new LineBreakMeasurer(text.getIterator(),frc);

            double width =pf.getImageableWidth();                                        //每行字符显示长度(点)

            Point2D.Double pen = new Point2D.Double (100,y+3*heigth);                    //首字符的基线位于用户空间中的 (x, y)位置处

            while ( (layout =lineBreaker.nextLayout((float)width)) != null){

               layout.draw(g2, (float)x, (float)pen.y);

               pen.y +=layout.getAscent();

            }

          return PAGE_EXISTS;

          default:

          return NO_SUCH_PAGE;
       }
	}

}
