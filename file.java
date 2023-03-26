package SIMPLILEARN.assignmentsSelflearningVideo.ReadWriteAndAppendFile;

import java.io.*;
import java.util.Scanner;

public class file {

        String fileName;
        Scanner keyboardInput = new Scanner(System.in);

        File newFile;


        // REQUIREMENTS OF APPLICATION

        public int requirementsOfProject(){
            System.out.println("Type 1: If you want to create a new file");
            System.out.println("Type 2: If you want to write something in file");
            System.out.println("Type 3: If you want to read file");
            System.out.println("Type 4: If you want to exit");
            System.out.println();

            System.out.print("Please type any option: ");
            int choice = keyboardInput.nextInt();
            return choice;


        }


        // CREATING FILES

        public void creatingFile(){

            String YESorNO = "";
            do {
                keyboardInput.nextLine();
                System.out.print("Type name of file (with extension) or press 0 if you want to return to main context: ");
                fileName = keyboardInput.next();

                this.newFile = new File(fileName);

                if (newFile.exists()) {

                    keyboardInput.nextLine();
                    System.out.print("File " + newFile.getName() + " already exists!.Do you want to give another name? (y/n)");
                    YESorNO = keyboardInput.next();

                } else if(fileName.equals("0")){

                    break;
                    // requirementsOfProject();
                    //break;


                }else {
                    try {
                        newFile.createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("File " + newFile.getName() + " has been created successfully.");
                    break;
                }
            }while(YESorNO.equals("y") ||  YESorNO.equals("Y"));
        }


        // WRITING IN FILE


        public void writingInFile(){

            keyboardInput.nextLine();
            System.out.print("Type name of file (with extension) in which you want to write or press 0 if you want to return to main context: ");
            String toWriteInFile = keyboardInput.next();

            this.newFile = new File(toWriteInFile);

            if(newFile.exists()) {
                FileWriter writing;
                try {
                    writing = new FileWriter(toWriteInFile, true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                keyboardInput.nextLine();
                System.out.println("Write below");
                String toWrite = keyboardInput.nextLine();
                try {
                    writing.write("\n" + toWrite);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    writing.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    writing.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else if (toWriteInFile.equals("0")) {
                requirementsOfProject();
            }else{
                System.out.println("\nFile doesn't exist.Please give valid input.\n");
                writingInFile();

            }
        }


        // READING FILE


        public void readingFile(){

            keyboardInput.nextLine();
            System.out.print("Type name of file (with extension) which you want to read or press 0 if you want to return to main context: ");
            String toReadFile = keyboardInput.next();

            this.newFile = new File(toReadFile);

            if(newFile.exists()) {
                FileReader reading = null;


                try {
                    reading = new FileReader(toReadFile);
                } catch (FileNotFoundException e) {
                    System.out.println("File " + toReadFile + " doesn't exist.Please give valid Input.");

                }
                Scanner scanning = new Scanner(reading);
                while (scanning.hasNextLine()) {
                    String line = scanning.nextLine();
                    System.out.println(line);
                }

                try {
                    reading.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else if (toReadFile.equals("0")) {
                requirementsOfProject();
            }else{

                System.out.println("\nFile doesn't exist.Please give valid input.\n");
                readingFile();
            }
        }


    // EXITING


    public void exit(){

        System.out.println("Thanks for visiting!");
    }
}
