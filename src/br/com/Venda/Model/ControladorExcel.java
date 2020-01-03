/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Venda.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import br.com.Venda.Telas.TelaVenda;
import br.com.Venda.Model.VendaExportImport;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author S60254831168
 */
public class ControladorExcel implements ActionListener {
    
    VendaExportImport vx = new VendaExportImport();
    TelaVenda tv = new TelaVenda();
    JFileChooser selecionaArquivo = new JFileChooser();
    File arquivo;
    int conte = 0;
    
    public ControladorExcel(VendaExportImport vx, TelaVenda tv){
        this.tv = tv;
        this.vx = vx;
        this.tv.btnImportar.addActionListener(this);
        this.tv.btnExport.addActionListener(this);
    }
    public ControladorExcel() {
    }    

    public void adicionarFiltro(){
        selecionaArquivo.setFileFilter(new FileNameExtensionFilter("Excel(*.xls)","xls"));
        selecionaArquivo.setFileFilter(new FileNameExtensionFilter("Excel(*.xlsx)","xlsx"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        conte++;
        if(conte==1)adicionarFiltro();
        if (e.getSource() == tv.btnImportar) {
            if (selecionaArquivo.showDialog(null, "Selecione o arquivo")==JFileChooser.APPROVE_OPTION) {
                arquivo=selecionaArquivo.getSelectedFile();
                if (arquivo.getName().endsWith("xls")|| arquivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, vx.Importar(arquivo, tv.LastTable ));                   
                }else{
                    JOptionPane.showMessageDialog(null, "Não há um formato valido");
                }
            }
        } 

if (e.getSource() == tv.btnExport) {
            if (selecionaArquivo.showDialog(null, "Exportar")==JFileChooser.APPROVE_OPTION) {
                arquivo=selecionaArquivo.getSelectedFile();
                if (arquivo.getName().endsWith("xls")|| arquivo.getName().endsWith("xlsx")) {
                    JOptionPane.showMessageDialog(null, vx.Exportar(arquivo, tv.LastTable ));                   
                }else{
                    JOptionPane.showMessageDialog(null, "Não há um formato valido");
                }
            }
        }         
    }
    
}
