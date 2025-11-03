package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;


public class ZipParseTest {



        private static final String ZIP_PATH = "test_files.zip";
        private static final String PDF_NAME = "test_pdf.pdf";
        private static final String CSV_NAME = "test_csv.csv";
        private static final String XLS_NAME = "test_xls.xls";

        @Test
        @DisplayName("Проверка PDF файла в Zip-архиве")
        void validatePdfInZip() throws Exception {
            try (ZipInputStream zis = new ZipInputStream(
                    getClass().getClassLoader().getResourceAsStream(ZIP_PATH))) {
                assertNotNull(zis, "ZIP архив не найден: " + ZIP_PATH);

                ZipEntry entry;
                boolean found = false;
                while ((entry = zis.getNextEntry()) != null) {
                    String entryName = entry.getName().replace('\\', '/');
                    if (entry.isDirectory() || entryName.endsWith("/")) {
                        zis.closeEntry();
                        continue;
                    }
                    String baseName = entryName.substring(entryName.lastIndexOf('/') + 1);
                    if (!PDF_NAME.equals(baseName)) { zis.closeEntry(); continue;}

                    found = true;
                    PDF pdf = new PDF(zis);
                    assertEquals(1, pdf.numberOfPages);
                    assertTrue(pdf.text.contains("Тестовый PDF-документ"));
                    zis.closeEntry();
                    break;
                }
                if (!found) fail("PDF файл в архиве не найден: " + PDF_NAME);
            }
        }


        @Test
        @DisplayName("Проверка XLS файла в Zip-архиве")
        void validateXlsxInZipTest() throws Exception {
            try (ZipInputStream zis = new ZipInputStream(
                    getClass().getClassLoader().getResourceAsStream(ZIP_PATH))) {
                assertNotNull(zis, "ZIP архив не найден: " + ZIP_PATH);

                ZipEntry entry;
                boolean found = false;
                while ((entry = zis.getNextEntry()) != null) {
                    String entryName = entry.getName().replace('\\', '/');
                    if (entry.isDirectory() || entryName.endsWith("/")) {
                        zis.closeEntry();
                        continue;
                    }
                    String baseName = entryName.substring(entryName.lastIndexOf('/') + 1);
                    if (!XLS_NAME.equals(baseName)) { zis.closeEntry(); continue;}

                    found = true;
                    XLS xls = new XLS(zis);

                    String test = xls.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
                    System.out.println(test);
                    assertEquals("test2", test);

                    String otherTest = xls.excel.getSheetAt(1).getRow(4).getCell(0).getStringCellValue();
                    System.out.println(otherTest);
                    assertEquals("Way to test5", otherTest);

                    zis.closeEntry();
                    break;
                }
                if (!found) fail("XLS файл в архиве не найден: " + XLS_NAME);
            }
        }

        @Test
        @DisplayName("Проверка CSV файла в Zip-архиве")
        void validateCsvInZipTest() throws Exception {
            try (ZipInputStream zis = new ZipInputStream(
                    getClass().getClassLoader().getResourceAsStream(ZIP_PATH))) {
                assertNotNull(zis, "ZIP архив не найден: " + ZIP_PATH);

                ZipEntry entry;
                boolean found = false;
                while ((entry = zis.getNextEntry()) != null) {
                    String entryName = entry.getName().replace('\\', '/');
                    if (entry.isDirectory() || entryName.endsWith("/")) {
                        zis.closeEntry();
                        continue;
                    }
                    String baseName = entryName.substring(entryName.lastIndexOf('/') + 1);
                    if (!CSV_NAME.equals(baseName)) { zis.closeEntry(); continue;}

                    found = true;
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = csvReader.readAll();

                    assertEquals(10, data.size());

                    assertArrayEquals(
                            new String[]{"test2", "2"},
                            data.get(1)
                    );
                    assertArrayEquals(
                            new String[]{"test6", "6"},
                            data.get(5)
                    );

                    assertEquals("test9", data.get(8)[0]);

                    zis.closeEntry();
                    break;
                }
                if (!found) fail("CSV файл в архиве не найден: " + CSV_NAME);
            }
        }

    }

