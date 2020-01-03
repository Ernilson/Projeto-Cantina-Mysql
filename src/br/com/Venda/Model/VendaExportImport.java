/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Venda.Model;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
/**
 *
 * @author S60254831168
 */
public class VendaExportImport {
    Workbook wb;
    
    public String Importar(File archivo, JTable tabelaD){
        String resp = "Tentativa sem sucesso ao importar!!!";
        DefaultTableModel modeloT = new DefaultTableModel();
        tabelaD.setModel(modeloT);
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet T = wb.getSheetAt(0);
            Iterator filaItarator = T.rowIterator();
            int indiceFile = -1;
            while(filaItarator.hasNext()){
                indiceFile++;
                Row file = (Row) filaItarator.next();
                Iterator columnaIterator = file.cellIterator();
                Object[] listaColumna = new Object[5];
                int indiceColumna=-1;
                while(columnaIterator.hasNext()){
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if(indiceFile==0){
                        modeloT.addColumn(celda.getStringCellValue());                        
                    }else{
                        if(celda!=null){
                            switch(celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna]=(int)Math.round(celda.getNumericCellValue());
                                    break;
                                    case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna]= celda.getStringCellValue();
                                    break;
                                    case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna]= celda.getBooleanCellValue();
                                    break;
                                    default:
                                        listaColumna[indiceColumna]= celda.getDateCellValue();
                                    break;
                            }
                        }
                    }
                }
                if(indiceFile!=0)modeloT.addRow(listaColumna);
            }
            resp = "Importação bem sucedida!!";
        } catch (Exception e) {
        }
        return resp;
    }
    
    public String Exportar(File arquivo, JTable tableD){
        String resp = "Sem sucesso";
        int numFila=tableD.getRowCount(), numColumna=tableD.getColumnCount();
        if(arquivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet T2 = wb.createSheet("");
        try {
            for(int i = -1; i< numFila; i++){
                Row fila = T2.createRow(i+1);
                for (int j=0; j< 10; j++){
                  Cell celda = fila.createCell(i);
                    if (i== -1) {
                        celda.setCellValue(String.valueOf(tableD.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tableD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(arquivo));
                }                
            }
            resp ="Exportação execultada com sucesso!";
        } catch (Exception e) {
        }
        return resp;
    }
}
