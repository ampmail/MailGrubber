package dclink.excel;

import com.extentech.ExtenXLS.CellHandle;
import com.extentech.ExtenXLS.RowHandle;
import com.extentech.ExtenXLS.WorkBookHandle;
import com.extentech.ExtenXLS.WorkSheetHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ampuser on 06.11.2015.
 */
public class OpenXLS {

    private final String workingdir = "D:\\Temp\\1\\";
//    private final String workingdir = "c:\\Users\\ampuser\\Downloads\\";
    private WorkBookHandle workBookHandle;
    private WorkSheetHandle workSheet;

    public OpenXLS(){
        super();
    }

    public OpenXLS(String fileName){
        if(fileName != null) {
            getWorkBook(fileName);
        }
    }

    public void getWorkBook (String fileName) {
        workBookHandle = new WorkBookHandle(workingdir + fileName);
    }

    public List<String> getWorkBookSheetsNames () {
        List<String> sheetNamesList = new ArrayList<>();
        if(workBookHandle != null) {
//            sheetNamesList = workBookHandle.getWorkSheets();
        }
        return sheetNamesList;
    }

    public void setActiveWorkSheetByName (Object sheetname){
        if(workBookHandle != null) {
            try {
                if (sheetname.getClass().equals(new String().getClass())) {
                    workSheet = workBookHandle.getWorkSheet((String) sheetname);
                }
                if (sheetname.getClass().equals(new Integer(0).getClass())) {
                    workSheet = workBookHandle.getWorkSheet((Integer) sheetname);
                }
                if (sheetname == null) {
                    System.out.println(1);
                    workBookHandle = workBookHandle.getNoSheetWorkBook();
                    workSheet = workBookHandle.getActiveSheet();
                }
//            System.out.println(workSheet.getFirstCol() + "\t" + workSheet.getFirstRow());
//            System.out.println(workSheet.getLastCol() + "\t" + workSheet.getLastRow());
            } catch (Exception workSheetHandle) {
                System.out.println(workSheetHandle);
            }
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