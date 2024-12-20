package Election;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Election {

        private String category;

        public Election(String category){
            this.category = category;
        }
    private static Registration registration =  new Registration();
    public static void main(String[] args) {
        goToMainMenu();
    }


    public static void goToMainMenu() {
        String mainMenu = """
                 <><><><><><><><><><><>
                 1. RegisterVoter
                 2. RegisterCandidate
                 3. vote
                 4. DisplayResult
                 5. Exit
                     
                <><><><><><><><><><><><>
                     
                    """;


        char userInput = input(mainMenu).charAt(0);
        switch (userInput) {
            case '1':
                registerVoter();
            case '2':
                registerCandidate();
            case '3':
                vote();
            case '4':
                displayResult();
            case '5':
                exit();

        }
    }
        private static void registerVoter(){
            String name = input("Enter name: ");
            String password = input("Enter password: ");
            Registration registration = new Registration();
           Voter voter =  registration.registerVoter(name,password);
           display(String.format("Your ID is %s ", voter.getVoterId()));
            goToMainMenu();
        }
        private static void registerCandidate(){
            String name = input("Enter name: ");
            String position = input("Enter position: ");
            Registration registration = new Registration();
            Candidate candidate = registration.registerCandidate(name,position);
            display(String.format("Your ID is %s ", candidate.getCandidateId()));
            goToMainMenu();
        }

        private static void vote(){

            String voteCategory = """
                 <><><><><><><><><><><>
                 1. president category
                 2. Senator category
                 3. governor category
                     
                <><><><><><><><><><><><>
                     
                    """;
            char userInput = input(voteCategory).charAt(0);
            switch (userInput) {
                case '1':
                    presidentCategory();
               case '2':
                    senatorCategory();
                case '3':
                    governorCategory();

            }

        }
        private static void checkPositionToVote(String position){

            display(String.format("To cast vote follow the process below %n"));
            String voterId = input("Enter voter identification number: ");
            String password = input("Enter password: ");
            String candidateId = input("Enter candidate identification number: ");
            Voter voter = registration.findVoter(voterId);
            if(voter.getVoted().contains(position)) throw new IllegalArgumentException("No duplicate vote allowed");
            voter.castVote(voterId,password,candidateId);
            voter.getVoted().add(position);
            goToMainMenu();

        }


        private static void presidentCategory() {
            Election elect =  new Election("president");
            elect.displayCandidates("president");
            checkPositionToVote("president");


        }
        private static void senatorCategory(){
            Election elect = new Election("Senator");
            elect.displayCandidates("Senator");
            checkPositionToVote("senator");

        }
        private static void governorCategory(){
            Election elect = new Election("governor");
            elect.displayCandidates("governor");
            checkPositionToVote("governor");

        }

        private static void displayResult(){
            ArrayList<Candidate> candidates = Registration.getCandidates();
            display(String.format("%n %-18s %-13s %-7s%n", "Name","Position","Vote Count"));
            for (Candidate candidate : candidates){
                 display(String.format("%n %-18s %-13s %-7s%n", candidate.getName(), candidate.getPosition(),candidate.getVoteCounter()));
            }
            goToMainMenu();
        }
        private static void exit(){
            display("Goodbye");
            System.exit(49);
        }

        private static String input(String prompt) {
        display(prompt);
        Scanner scan = new Scanner(System.in);
         return scan.nextLine();

        }

        private static void display(String prompt) {
        System.out.print(prompt);

        }

        private void displayCandidates(String position){
            ArrayList<Candidate> candidates = Registration.getCandidates();
            if(candidates.isEmpty())throw new IllegalArgumentException("Candidate list is empty");
            display(String.format("%n %-10s %-16s %-13s%n", "ID" ,"Name","Position"));
            for(Candidate candidate : candidates){
                if(this.category.equals(position)){
                    candidate.displayCandidate();
                }
            }
        }



}