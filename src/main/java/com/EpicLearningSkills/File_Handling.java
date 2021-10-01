package com.EpicLearningSkills;


import java.io.*;

public class File_Handling {
    private int check = 0;

    public int CreateFile(String Filename) {  // This Function is used to create the File
        //It takes the File name as Arguments.
        try {
            File myObj = new File(Filename);
            if (myObj.createNewFile()) {
                System.out.println("File is Created " + myObj.getName());
            } else {
                System.out.println("File Already Existed");
                check = 1;
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return check; 
    }

    public void WriteToFile(String Filename, String Data) {// This Function is used to write in the File
        // It takes Filename and Data as Arguments
        try {
            FileWriter myWriter = new FileWriter(Filename, true);
            myWriter.write(Data);
            myWriter.close();
            System.out.println("Written in file");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    // This Function is used to modify the Data in the File
    // It take the line number, File path , previous data and data modified as Arguments
    static void modifyFile(String filePath, int Counter, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        int index = 1;
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                if ((Counter == index) && (oldString.equals(line))) {
                    System.out.print("True");
                    oldContent = oldContent + newString + System.lineSeparator();
                    line = reader.readLine();


                } else if (Counter != index) {
                    System.out.print("False ");
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
                }
                index++;
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // This Function  check whether data is present in file or not.
    // returns True and False
    public boolean Return_boolean_MatchingInFile(String Filename, String value) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(Filename));
            String line = reader.readLine();
            while (line != null) {
                if (value.equals(line)) {
                    return true;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // This Function  check whether data is present in file or not.
    // returns Line Number.
    public int Return_Count_MatchingLine(String Filename, String value) {
        int counter = 1;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(Filename));
            String line = reader.readLine();
            while (line != null) {
                if (value.equals(line)) {
                    return counter;
                }
                line = reader.readLine();
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // This Function  check whether data is present in file or not.
    // returns that matched Data.
    public String Return_Balance(String Filename, int counter) {

        int index = 1;
        String oldContent = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(Filename));
            String line = reader.readLine();
            while (line != null) {
                if (counter == index) {
                    oldContent = line;
                }
                line = reader.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oldContent;
    }
}

