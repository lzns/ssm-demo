package com.dzf.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.InputStream;

/**
 * @author dingzf
 * @date 2018/3/13
 * @time 21:06
 */
public class EventPoiTest {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/test.xlsx");
        OPCPackage opcPackage = OPCPackage.open(file);
        ReadOnlySharedStringsTable sharedStringsTable = new ReadOnlySharedStringsTable(opcPackage);
        XSSFReader xssfReader = new XSSFReader(opcPackage);
        StylesTable styles = xssfReader.getStylesTable();
        XSSFReader.SheetIterator  sheetsData = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        while (sheetsData.hasNext()){
            InputStream inputStream = sheetsData.next();
            String sheetName = sheetsData.getSheetName();
            System.out.println(sheetName);
            process(styles,sharedStringsTable,inputStream);
        }
        opcPackage.close();
    }

    private static void process(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream inputStream)throws Exception {
        InputSource sheetSource = new InputSource(inputStream);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        XMLReader sheetParser = saxParser.getXMLReader();
        //MyXSSFSheetHandler handler = new MyXSSFSheetHandler(styles, strings,
        //        this.minColumns, this.output);
        //sheetParser.setContentHandler(handler);
        sheetParser.parse(sheetSource);
        // handler.getRows();
    }

}
