package Election;


import java.util.ArrayList;


public class Registration {
    private  int counter;
    private  String voterCountID;
    private String  candidateID;




    private static ArrayList<Candidate> candidates = new ArrayList<>();
    private static ArrayList<Voter> voters = new ArrayList<>();



    public String generateVoterCountID(){
            counter++;
            return "vtr" +( counter);

    }
    public String generateCandidateCountID(){
        counter++;
        return  "Cd"+ (counter);
    }
    public Candidate registerCandidate(String name, String position) {
        this.candidateID = generateCandidateCountID();
        Candidate newCandidate = new Candidate(candidateID, name, position);
        candidates.add(newCandidate);
        System.out.print(candidateID);
        return newCandidate;
    }

    public  Voter registerVoter(String name, String password) {
        this.voterCountID = generateVoterCountID();
        Voter newVoter = new Voter(voterCountID, name, password);
        voters.add(newVoter);
        System.out.print(voterCountID);
        return newVoter;
    }

    public Candidate findCandidate(String CandidateId) {
        for (Candidate newCandidate : candidates) {
            if (newCandidate.getCandidateId().equals(CandidateId)) return newCandidate;
        }
        return null;
    }

    public Voter findVoter(String voterId) {
        for (Voter voter : voters) {
            if (voter.getVoterId().equals(voterId)) return voter;
            else
                throw new IllegalArgumentException("Voter not found.");
        }
    return null;
    }
    public static ArrayList<Candidate> getCandidates() {
        return candidates;
    }
    public static ArrayList<Voter> getVoters(){return voters;}




}
