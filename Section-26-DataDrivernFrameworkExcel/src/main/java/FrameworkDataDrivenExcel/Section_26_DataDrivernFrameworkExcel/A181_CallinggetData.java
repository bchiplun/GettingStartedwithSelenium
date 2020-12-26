package FrameworkDataDrivenExcel.Section_26_DataDrivernFrameworkExcel;

import java.io.IOException;
import java.util.ArrayList;

public class A181_CallinggetData {
	
	public static void main(String[] args) throws IOException {
		
		A177_ExceltoJavaCode cls = new A177_ExceltoJavaCode();
		
		ArrayList a = cls.getData("Add Profile");
		
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		
		
	}

}
