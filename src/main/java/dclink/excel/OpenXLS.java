package dclink.excel;

import com.extentech.ExtenXLS.CellHandle;
import com.extentech.ExtenXLS.RowHandle;
import com.extentech.ExtenXLS.WorkBookHandle;
import com.extentech.ExtenXLS.WorkSheetHandle;

/**
 * Created by ampuser on 06.11.2015.
 */
public class OpenXLS {

//    String workingdir = "D:\\Temp\\";
    private final String workingdir = "c:\\Users\\ampuser\\Downloads\\";
    private WorkBookHandle workBookHandle;
    private WorkSheetHandle workSheet;

    public OpenXLS(){
        super();
    }

    public OpenXLS(String fileName){
        getWorkBook(fileName);
    }

    public void getWorkBook (String fileName) {
        workBookHandle = new WorkBookHandle(workingdir + fileName);
    }

    public void setActiveWorkSheetByName (String sheetname){
        try {
            workSheet = workBookHandle.getWorkSheet(sheetname);
//            System.out.println(workSheet.getFirstCol() + "\t" + workSheet.getFirstRow());
//            System.out.println(workSheet.getLastCol() + "\t" + workSheet.getLastRow());
        }catch (Exception workSheetHandle){
            System.out.println(workSheetHandle);
        }
    }

    public void getWorkSheetData(){
        try {
            RowHandle[] rows = workSheet.getRows();
            for (RowHandle row : rows) {
                CellHandle[] cells = row.getCells();
                for (CellHandle cell : cells) {
                    System.out.print(cell.getCellTypeName());
                    System.out.print('_');
                    System.out.print(cell.getCellAddress());
                    System.out.print(' ');
                    String originalStringVal = cell.getFormattedStringVal();
//                    System.out.print(originalStringVal);
                    byte[] encoded = originalStringVal.getBytes("windows-1251");
                    System.out.print(new String(encoded, "UTF-8"));
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }catch (Exception workSheetHandle){
            System.out.println(workSheetHandle);
        }
    }
}