package Election;

public class Candidate {

    private String CandidateId;
    private  String name;
    private String position;
    private int voteCounter;



    public Candidate(String candidateId, String name, String position) {
        this.CandidateId = candidateId;
        this.name = name;
        this.position = position;
        voteCounter = 0;
    }

    public int getVoteCounter() {
        return voteCounter;
    }
    public void addVote(){
        voteCounter++;
    }
    public String getCandidateId(){
        return this.CandidateId;
    }

    public void displayCandidate() {
        System.out.printf("%n %-4s %-20s %12s%n", CandidateId, name, position);

    }
    public String getPosition() {
        return position;
    }

    public String  getName() {
        return name;
    }


}
