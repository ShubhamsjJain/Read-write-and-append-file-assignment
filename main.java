package SIMPLILEARN.assignmentsSelflearningVideo.ReadWriteAndAppendFile;

import java.util.Scanner;

public class main {

    public static void main(String args []) {

        file fm = new file();
        Scanner keyboardInput = new Scanner(System.in);
        String performMoreActions = "";

        do {


            int choice = 0;

            try {
                choice = fm.requirementsOfProject();
            } catch (Exception e) {
                e.getMessage();
            }

            switch (choice) {

                case 1:
                    fm.creatingFile();
                    break;

                case 2:

                    fm.writingInFile();
                    break;

                case 3:

                    fm.readingFile();
                    break;


                case 4:

                    fm.exit();
                    break;


                default:

                    System.out.println("INVALID Input!!Please try again.");
                    break;
            }

            do {
                keyboardInput.nextLine();
                System.out.println("Do you want to perform some more actions? (Y/N)");
                performMoreActions = keyboardInput.next();
                if ((performMoreActions.equals("y")) || (performMoreActions.equals("Y")) || (performMoreActions.equals("n")) || (performMoreActions.equals("N"))) {
                    break;
                } else {
                    System.out.println("Invalid Input.Please try again.");
                }
            }while(!((performMoreActions.equals("y")) || (performMoreActions.equals("Y"))));

        }while((performMoreActions.equals("y")) ||(performMoreActions.equals("Y")));
    }
}
